package main.utils;

import javafx.scene.control.Alert;

public class Dialogue {

    private static Alert alert;

    public static void error(String msg) {
        alert = new Alert(Alert.AlertType.ERROR);
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
