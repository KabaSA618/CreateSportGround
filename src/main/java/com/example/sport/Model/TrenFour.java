package com.example.sport.Model;

import com.example.sport.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;

/**
 * Класс Тренажера №4
 */
public class TrenFour extends Components{
    /**
     * Конструктор Тренажера №4
     */
    public TrenFour() {
    Name="Тренажер №4";

    img=new Image(String.valueOf(HelloApplication.class.getResource("tren8.png")));
}
    /**
     * Функция рисования Тренажера №4
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

