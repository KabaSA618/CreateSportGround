package com.example.sport.Model;

import com.example.sport.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


/**
 * Класс Тренажера №6
 */
public class TrenSix extends Components{

    public TrenSix() {
    Name="Тренажер №6";
    img=new Image(String.valueOf(HelloApplication.class.getResource("tren6.png")));
}
/**
     * Функция рисования Тренажера №6
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

