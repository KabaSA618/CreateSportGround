package com.example.sport.Model;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 * Класс прототип
 */
public abstract class Components implements SportsGrounds,Cloneable{
    /**
     * Изображение
     */
    public Image img;
    /**
     * Увеличение
     */
    public double mash;
    /**
     * Координаты
     */
    public Double ox=0.,oy=0.;
    /**
     * высота и ширина
     */
    public Double w,h;
    /**
     * Имя
     */
    public String Name="Компонент";

    /**
     * Функция рисования прототипа
     * @param pane панели компоновки
     */
    public abstract void draw(Pane pane);

    /**
     * Устанавливаем положение на координатной оси
     * @param ox координата X
     * @param oy координата Y
     */
    public void setMargin(Double ox, Double oy){
        this.oy=oy;
        this.ox=ox;
    }

    /**
     * Устанавливаем размер
     * @param w ширина
     * @param h высота
     */
    public void setSize(Double w, Double h){
        this.w=w;
        this.h=h;
    }

    /**
     * Устанавливает Увеличение
     * @param mash Увеличение
     */
    public void setMash(int mash){ this.mash=mash;
    }

    /**
     * Переопределение стандартной функции
     * @return Имя
     */
    @Override
    public String toString() {
        return Name;
    }

    /**
     * Клонирование оюъекта
     * @return клонированный объект
     */
    @Override
    public Components clone() {
        Object clone = null;
        try {
        clone = super.clone();
    } catch (CloneNotSupportedException e) { e.printStackTrace();	}
        return (Components) clone;//
    }
}

