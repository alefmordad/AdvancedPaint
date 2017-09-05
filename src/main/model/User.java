package main.model;

import main.utils.Digest;

import java.util.Random;

public class User extends Model {

    private static Random random = new Random();

    private String username;
    private String password;
    private int salt;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        salt = random.nextInt() % 1000000000;
        calculatePassword(password);
    }

    public User(String username, String password, int salt) {
        this.username = username;
        this.salt = salt;
        calculatePassword(password);
    }

    private void calculatePassword(String password) {
        this.password = Digest.getMD5String(password + String.valueOf(salt));
    }

    public int getSalt() {
        return salt;
    }

    public void setSalt(int salt) {
        this.salt = salt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (salt != user.salt) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + salt;
        return result;
    }
}