package main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.dao.UserDao;
import main.model.User;
import main.utils.Dialogue;
import main.utils.utils.exceptions.DaoException;
import main.utils.utils.exceptions.EmptyFieldException;
import main.view.Paint;

import java.io.IOException;

import static main.utils.Constants.*;

public class LoginController {

    @FXML
    TextField txtUsername;

    @FXML
    PasswordField txtPassword;

    private User user;
    private final UserDao dao = new UserDao();

    public void register() {
        try {
            parseUserInfo();
            dao.create(user);
            Dialogue.info(user + USER_SUCCESSFULLY_ADDED);
        } catch (EmptyFieldException e) {
            Dialogue.error(e.getMessage());
        } catch (DaoException e) {
            Dialogue.error(USERNAME + " '" + user.getUsername() + "' " + IS_TAKEN);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resetFields();
        }
    }

    public void login() {
        try {
            parseUserInfo();
            user = dao.get(user);
            User otherUser = new User(txtUsername.getText(), txtPassword.getText(), user.getSalt());
            if (otherUser.equals(user))
                startPaint();
            else
                Dialogue.error(WRONG_PASSWORD);
        } catch (EmptyFieldException e) {
            Dialogue.error(e.getMessage());
        } catch (DaoException e) {
            Dialogue.error(NO_SUCH_USER);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resetFields();
        }
    }

    private void startPaint() throws IOException {
        ((Stage) txtUsername.getScene().getWindow()).close();
        new Paint(user).start(new Stage());
    }

    private void parseUserInfo() throws EmptyFieldException {
        Dialogue.nonEmptyCheck(txtUsername.getText(), USERNAME + " " + CANT_BE_EMPTY);
        Dialogue.nonEmptyCheck(txtPassword.getText(), PASSWORD + " " + CANT_BE_EMPTY);
        generateUser();
    }

    private void resetFields() {
        txtUsername.setText("");
        txtPassword.setText("");
    }

    private void generateUser() {
        user = new User(txtUsername.getText(), txtPassword.getText());
    }

}