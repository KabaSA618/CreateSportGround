package com.example.sport;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Класс HelloApplication загрузки приложения
 */
public class HelloApplication extends Application {
    /**
     * Функция начала приложения
     * @param stage s
     * @throws IOException ошибка открытия файла
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Главная функция
     * @param args String[]
     */
    public static void main(String[] args) {
        launch();
    }
}