package edu.ucr.rp.lab03.tmp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        root.getChildren().add(new Label("42"));
        primaryStage.setScene(new Scene(root, 420, 420));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}