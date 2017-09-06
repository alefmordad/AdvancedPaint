package main.model;

import javafx.scene.canvas.GraphicsContext;

public class Line extends javafx.scene.shape.Line implements Shape {

    private int identifier;
    private User user;

    public Line() {
    }

    public Line(User user) {
        this.user = user;
    }

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

    public void setIdentifier(int id) {
        this.identifier = id;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.strokeLine(getStartX(), getStartY(), getEndX(), getEndY());
    }
}
