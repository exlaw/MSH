package main;
/**
 * Created by Sorumi on 16/11/16.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ui.controller.MainUIController;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader rootLoader = new FXMLLoader();
        rootLoader.setLocation(Main.class.getResource("../view/main.fxml"));
        BorderPane root = rootLoader.load();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        MainUIController controller = rootLoader.getController();
        controller.setRootPane(root);
        controller.showHeaderAndNavbar();
        controller.showOrderList();

    }
}