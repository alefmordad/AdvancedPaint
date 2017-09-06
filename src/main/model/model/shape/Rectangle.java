package main.model.model.shape;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import main.dao.Dao;
import main.dao.RectangleDao;
import main.model.User;

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
        super(user);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.strokeRect(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public boolean contains(Point2D point) {
        if (point.getX() >= getX() && point.getX() <= getX() + width)
            if (point.getY() >= getY() && point.getY() <= getY() + height)
                return true;
        return false;
    }

    @Override
    public Point2D center() {
        return new Point2D(x + width / 2, y + height / 2);
    }

    @Override
    public Dao dao() {
        return new RectangleDao(getUser());
    }

}
