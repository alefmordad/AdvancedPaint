package main.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.controller.PaintController;
import main.model.User;

import java.io.IOException;

public class Paint extends Application {

    private User user;

    public Paint(User user) {
        this.user = user;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Paint.fxml"));
//        fxmlLoader.setController(new PaintController());
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/Paint.fxml"));
        Parent root = fxmlLoader.load();
        ((PaintController) fxmlLoader.getController()).setUser(user);
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Hello '" + user.getUsername() + "'");
        primaryStage.setOnCloseRequest(t -> System.exit(0));
        primaryStage.show();
    }
}
