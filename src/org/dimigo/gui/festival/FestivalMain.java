package org.dimigo.gui.festival;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FestivalMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {


        Parent root = FXMLLoader.load(getClass().getResource("Festival.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Dimigo Festival");
        stage.setTitle("Dimigo Festival");

        // 메인 윈도우 보이기

        stage.show();
    }
}


