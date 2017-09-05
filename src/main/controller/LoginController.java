package main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.dao.UserDao;
import main.model.User;
import main.utils.Dialogue;
import main.utils.EmptyFieldException;
import main.utils.DaoException;

import static main.utils.Constants.*;

public class LoginController {

    private User user;
    private UserDao userDAO = new UserDao();

    @FXML
    public TextField txtUsername;

    @FXML
    public PasswordField txtPassword;

    public void register() {
        try {
            readUserInfo();
            userDAO.create(user);
            Dialogue.error(user + USER_SUCCESSFULLY_ADDED);
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
            readUserInfo();
            user = userDAO.get(user);
            User otherUser = new User(txtUsername.getText(), txtPassword.getText(), user.getSalt());
            if (otherUser.equals(user))
                System.out.println("right");
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

    private void readUserInfo() throws EmptyFieldException {
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