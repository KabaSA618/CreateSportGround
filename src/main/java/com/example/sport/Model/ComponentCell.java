package com.example.sport.Model;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext; import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext; import javafx.scene.control.ListCell; import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javax.swing.text.html.ImageView;

/**
 * Класс для отображения ListView
 */
public class ComponentCell extends ListCell<Components> {
    Slider mash;

    /**Конструктор - создание нового объекта
     * @param value - слайдер, указывающий масштаб фигуры
     */

    public ComponentCell(Slider value){ mash=value;
    }

    /**Метод обновления компонента
     *	@param item1 - передаваемый компонент
     *	@param empty {@link Boolean}
     */
    @Override
    public void updateItem(Components item1, boolean empty) {
        super.updateItem(item1, empty);
        if (item1 != null) {
            item1.mash=(mash.getValue()+500)/350;
            Pane p=new Pane();
            item1.setSize(item1.img.getWidth()/8,item1.img.getHeight()/8);
//            item1.setMargin(60+(90-item1.img.getWidth()/5)/2,(60-
//                    item1.img.getHeight()/5)/2);
            item1.setMargin(100-item1.img.getWidth()/10.0,100-
                    item1.img.getHeight()/10.0);
            p.getChildren().add(new Label(item1.toString()));
            item1.draw(p); // ее отрисовка на канве
            setGraphic(p); //установка канвы вместо cell
        }

    }
}

