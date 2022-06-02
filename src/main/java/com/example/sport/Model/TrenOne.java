package com.example.sport.Model;

import com.example.sport.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

/**Класс первого тренажера
 *@version 2.0
 */
public class TrenOne extends Components{
    /**
     * Конструктор - создание нового объекта
     */
    public TrenOne() {
        Name="Тренажер №1";
        img=new Image(String.valueOf(HelloApplication.class.getResource("tren1.png")));
    }

    /**
     * Переопределение метода
     * @return название класса
     */
    @Override
    public String toString(){
        return this.Name;
    }
    /**Метод рисования первого тренажера
     *	@param panet – панель, на которой произведен рисунок
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

