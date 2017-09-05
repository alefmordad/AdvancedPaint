package main.utils;

import javax.swing.*;

public class Dialogue {

    public static void show(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public static void nonEmptyCheck(String str, String errorMessage) throws EmptyFieldException {
        if (str.trim().isEmpty())
            throw new EmptyFieldException(errorMessage);
    }

}
