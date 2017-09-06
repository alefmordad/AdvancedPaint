package main.model;

import javafx.scene.canvas.GraphicsContext;

public class Circle extends javafx.scene.shape.Circle implements Shape {

    private int identifier;
    private User user;

    @Override
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(int id) {
        this.identifier = id;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.strokeOval(getCenterX() - getRadius(), getCenterY() - getRadius(), getRadius() * 2, getRadius() * 2);
    }
}
