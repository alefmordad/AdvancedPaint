package main.model;

import javafx.scene.canvas.GraphicsContext;
import main.dao.RectangleDao;

public class Rectangle extends Shape {

    private double x;
    private double y;
    private double width;
    private double height;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Rectangle() {
    }

    public Rectangle(User user) {
        super(new RectangleDao(user), user);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.strokeRect(getX(), getY(), getWidth(), getHeight());
    }

}
