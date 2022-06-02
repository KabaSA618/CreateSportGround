package com.example.sport.Model;
import javafx.collections.ObservableList; import javafx.scene.image.Image;
import javafx.scene.image.ImageView; import javafx.scene.layout.Pane; import javafx.scene.paint.Color; import javafx.stage.FileChooser; import javafx.stage.Window;

import java.io.*;
import java.util.ArrayList;

/**
 * Класс для работы с файлами
 */
public class FileClass {
    /**
     * Список, который позволяет слушателям отслеживать изменения, когда они происходят.
     */
    ObservableList<Components> C;

    /**
     * Конструктор файла
     * @param content Список прототипов
     */
    public FileClass(ObservableList<Components> content){
        C=content;
    }

    /**
     * Функция сохранения в файл
     * @param AOR ArrayList компанентов
     */
    public void Save(ArrayList<Components> AOR){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите файл...");
        fileChooser.setInitialFileName("Компоненты");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Date Files", "*.dat"));
        File file=fileChooser.showSaveDialog(null);
        if (file != null) {
        try(FileOutputStream fos=new FileOutputStream( file)) {
            for (var a:AOR) {
            int NumClass=-1;
            for (int i = 0; i < C.size(); i++) {

                if(a.getClass().toString().equals(C.get(i).getClass().toString()))
                { NumClass=i;
                    break;
                }
            }
                byte[] buffer =(NumClass+" "+a.w+" "+a.h+" "+a.ox+" "+a.oy+"\n").getBytes();
                fos.write(buffer);
        }

        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }
    }

    /**
     * Функция загрузки из файла
     * @return ArrayList
     */
    public ArrayList<Components> Load() {
        ArrayList<Components> AOR = new ArrayList<Components>();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Загрузка содержимого аудитории в формате dat");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Date Files", "*.dat"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            try {
                FileInputStream fos = new FileInputStream(file);
                int i = -1;
                String s = "";
                while ((i = fos.read()) != -1) {
                    System.out.print((char) i);
                    s += (char) i;
                    if ((char) i == '\n') {
                        String[] temp = s.split(" ");
                        s = "";
                        var comp = C.get(Integer.parseInt(temp[0]));


                        comp.setSize(Double.parseDouble(temp[1]), Double.parseDouble(temp[2]));

                        comp.setMargin(Double.parseDouble(temp[3]), Double.parseDouble(temp[4]));
                        AOR.add(comp.clone());
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

            return AOR;
}


    /**
     * Открытия изображения
     * @param p панели компоновки
     * @return ImageView
     */
    public ImageView OpenImg(Pane p){
        FileChooser fileChooser = new FileChooser(); fileChooser.setTitle("Открытие файла"); fileChooser.setInitialFileName("new_image"); fileChooser.getExtensionFilters().add(new
                FileChooser.ExtensionFilter("Изображение", "*.png"));
        File loadImageFile=fileChooser.showOpenDialog(p.getScene().getWindow());
        Image image = new Image(loadImageFile.toURI().toString()); ImageView imV= new ImageView(image);
        imV.setFitHeight(p.getHeight()); imV.setFitWidth(p.getWidth());
        p.getChildren().add(imV);
        return imV;
    }
}

