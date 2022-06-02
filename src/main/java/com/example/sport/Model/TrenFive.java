package com.example.sport.Model;

import com.example.sport.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;

/**
 * Класс Тренажера №5
 */
public class TrenFive extends Components{
    /**
     * Конструктор Тренажера №5
     */
    public TrenFive() {
    Name="Тренажер №5";
    img=new Image(String.valueOf(HelloApplication.class.getResource("tren5.png")));
}

    /**
     * Функция рисования Тренажера №5
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

