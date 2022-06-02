package com.example.sport.Model;

import com.example.sport.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Класс Тренажера №2
 */
public class TrenTwo extends Components{
    /**
     * Конструктор Тренажера №2
     */
    public TrenTwo() {
    Name="Тренажер №2";
    img=new Image(String.valueOf(HelloApplication.class.getResource("tren2.png")));
}
    /**
     * Функция рисования Тренажера №2
     * @param panet панель компоновки
     */
    public void draw(Pane panet){
        ImageView imgview= new ImageView(img);
        imgview.setLayoutX(ox);
        imgview.setLayoutY(oy);
        imgview.setFitWidth(w*mash);
        imgview.setFitHeight(h*mash);
        panet.getChildren().add(imgview);
    }
}

