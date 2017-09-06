package main.model;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends javafx.scene.shape.Rectangle implements Shape {

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
        gc.strokeRect(getX(), getY(), getWidth(), getHeight());
    }
}
