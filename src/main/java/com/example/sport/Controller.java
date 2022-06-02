package com.example.sport;

import com.example.sport.Model.*;
import javafx.scene.control.Label;

import javafx.application.Platform; import javafx.collections.FXCollections; import javafx.collections.ObservableList; import javafx.event.ActionEvent;
import javafx.fxml.Initializable; import javafx.scene.control.*;
import javafx.scene.control.TextField; import javafx.scene.image.ImageView; import javafx.scene.input.MouseButton; import javafx.scene.input.MouseEvent; import javafx.scene.layout.Pane; import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList; import java.util.ResourceBundle;

/**
 * Класс контроллера
 */
public class Controller implements Initializable {
    public Pane pan;
    public ListView LV;
    public TextField MargT;
    public TextField MargL;
    public Label LableName;
    public Slider silder;
    public Label Mode;
    double X=0,Y=0;
    int item=0;//-1-focus,0-add,1-saveadd,2-per,3-copy
    double H1,W1,ox1,oy1;
    ImageView componentsImageView=null;
    ArrayList<Components> componentsArrayList =new ArrayList<Components>();
    ObservableList<Components> content;
    FileClass FC;
    private Components components=new Components() {
        @Override
    public void draw(Pane pane) {

    }
    };

    /**
     * Функция инициализации
     * @param url URL
     * @param resourceBundle ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        content= FXCollections.observableArrayList(new TrenOne(),new TrenTwo(),new TrenThree(), new TrenFour(),new TrenFive(),new TrenSix(), new TrenSeven());
        LV.setItems(content);
        LV.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        LV.setCellFactory(new Callback<ListView<Components>,
                                  ListCell<Components>>() {
                              @Override
                              public ListCell<Components> call(ListView<Components> list) {
                                  return new ComponentCell(silder);
                              }
                          }
        );

        LV.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            Mode.setText("Добавления");
            item=0;
            components=content.get(LV.getSelectionModel().getSelectedIndex());
            System.out.println(components);
        });
        item=-1;
        Mode.setText("Выбора");
        FC =new FileClass(content);
    }

    /**
     * Обновление рисунка
     */
    public void UpdateDate(){
        pan.getChildren().clear();
        if (componentsImageView!=null)
            pan.getChildren().add(componentsImageView);
        for (Components r:componentsArrayList) {
            r.draw(pan);
        }
    }

    /**
     * Функция удаляет все элементы
     * @param actionEvent ActionEvent
     */
    public void deleteall(ActionEvent actionEvent) {
        componentsImageView=null;
        componentsArrayList.clear();
        pan.getChildren().clear();
    }

    /**
     * Функция добавляет элементы
     * @param actionEvent ActionEvent
     */
    public void Add(ActionEvent actionEvent) {
        item=1;
        Mode.setText("Выбрать");
        LV.getSelectionModel().select(-1);
    }
    /**
     * Функция удаляет элементы
     * @param actionEvent ActionEvent
     */
    public void Del(ActionEvent actionEvent) {
        item=4;
        Mode.setText("Удаления");
    }
    /**
     * Функция перемещает элементы
     * @param actionEvent ActionEvent
     */
    public void Per(ActionEvent actionEvent) {
        LV.getSelectionModel().select(-1);
        item=2;
        Mode.setText("Перемещения");
    }
    /**
     * Функция Копирования элементы
     * @param actionEvent ActionEvent
     */
    public void Cop(ActionEvent actionEvent) {
        item=3;
        Mode.setText("Копирования");
    }

    /**
     * Функция закрытия программы
     * @param actionEvent ActionEvent
     */
    public void Close(ActionEvent actionEvent) { Platform.exit();
    }
    /**
     * Функция сохранения рисунка
     * @param actionEvent ActionEvent
     */
    public void Save(ActionEvent actionEvent) {

        FC.Save(componentsArrayList);
    }
    /**
     * Функция открытия  файла
     * @param actionEvent ActionEvent
     */
    public void Load(ActionEvent actionEvent) {
        componentsArrayList=FC.Load();
        UpdateDate();
    }
    /**
     * Функция открытия  фона
     * @param actionEvent ActionEvent
     */
    public void OpenImage(ActionEvent actionEvent) {
        componentsImageView=FC.OpenImg(pan);
    }

    /**
     * Функция перетаскивания элемента по Pane
     * @param mouseEvent MouseEvent
     */
    public void PaneMm(MouseEvent mouseEvent)
    {
        X=mouseEvent.getX(); Y=mouseEvent.getY();
        // Plb.setText(""+X+"\n"+Y);
        if(item==0){
            ox1=0; oy1=0;
            W1=components.w/2;
            H1=components.h/2;
            item=1;
            Mode.setText("Установки");
        }
        if (item==1)
        {
            components.ox=ox1+X-W1;
            components.oy=oy1+Y-H1;
            UpdateDate();
            components.draw(pan);
            LableName.setText(components.toString());
            MargT.setText(components.oy.toString());
            MargL.setText(components.ox.toString());
        }

    }

    /**
     * Функция обнаружения компонента
     * @return компонент
     */
    private Components McFocus()
    {
        for (int i=componentsArrayList.size()-1;i>=0;i--) {
            var t=componentsArrayList.get(i);
            if(X>t.ox && X<t.ox+t.w && Y>t.oy && Y<t.oy+t.h)
            {
                return t;
            }
        }
        return null;
    }

    /**
     *
     * @param mouseEvent
     */
    private void McAdd(MouseEvent mouseEvent)
    {
        if(mouseEvent.getButton()== MouseButton.PRIMARY) {
            componentsArrayList.add(components.clone());
            LV.getSelectionModel().select(-1);
            item = -1;
            Mode.setText("Выборать");
        }
    }
    /**
     * Функция перетаскивания элемента по Pane
     * @param mouseEvent MouseEvent
     */
    private void McPer(MouseEvent mouseEvent){
        if(mouseEvent.getButton()== MouseButton.PRIMARY) {
        var t=McFocus(); if(t!=null) {
            H1 = Y; W1 = X;
            oy1 = t.oy; ox1 = t.ox;
            item = 1; Mode.setText("Установки"); components=t; componentsArrayList.remove(t);
        }
    }
    }
    /**
     * Функция копирования элемента по Pane
     * @param mouseEvent MouseEvent
     */
    private void McCopy(MouseEvent mouseEvent){
        if(mouseEvent.getButton()== MouseButton.PRIMARY) {
        var t=McFocus(); if(t!=null) {
            H1 = Y; W1 = X;
            oy1 = t.oy; ox1 = t.ox;
            item = 1;
            Mode.setText("Установки"); components=t.clone();
        }
    }
    }
    /**
     * Функция удаления элемента по Pane
     * @param mouseEvent MouseEvent
     */
    private void McDel(MouseEvent mouseEvent){
        if(mouseEvent.getButton()== MouseButton.PRIMARY) {
        var t=McFocus();
        if(t!=null) {
            componentsArrayList.remove(t);
            UpdateDate();
        }
        item = -1;
        Mode.setText("Выборать");
    }
    }
    /**
     * Функция клика по Pane
     * @param mouseEvent MouseEvent
     */
    public void PaneCl(MouseEvent mouseEvent) {
        switch (item)
    {
        case -1:
            components=McFocus()!=null?McFocus():components;
            break;
        case 1:McAdd(mouseEvent);
        break;
        case 2:McPer(mouseEvent);
        break;
        case 3:McCopy(mouseEvent);
        break;
        case 4:McDel(mouseEvent);
        break;
    }
        LableName.setText(components.toString());
        MargT.setText(components.oy.toString());
        MargL.setText(components.ox.toString());
    }

    /**
     * 1
     * @param mouseEvent MouseEvent
     */
    public void ChangeMash(MouseEvent mouseEvent) {
    }

    /**
     * Функция изменения размера эелемента
     * @param actionEvent ActionEvent
     */
    public void changeMarg(ActionEvent actionEvent) {

        components.setMargin(Double.parseDouble(MargL.getText()),Double.parseDouble( MargT.getText()));
        UpdateDate();
    }
}
