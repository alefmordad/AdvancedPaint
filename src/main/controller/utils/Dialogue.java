package main.controller.utils;

import javafx.scene.control.Alert;
import main.controller.utils.utils.exceptions.EmptyFieldException;

public class Dialogue {

    public static void info(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void error(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void nonEmptyCheck(String str, String errorMessage) throws EmptyFieldException {
        if (str.trim().isEmpty())
            throw new EmptyFieldException(errorMessage);
    }

}
