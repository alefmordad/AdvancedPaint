package main.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.model.User;

import java.io.IOException;

public class Paint extends Application {

    private User user;

    public Paint(User user) {
        this.user = user;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Paint.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Hello " + user.getUsername());
        primaryStage.setOnCloseRequest(t -> System.exit(0));
        primaryStage.show();
    }
}
