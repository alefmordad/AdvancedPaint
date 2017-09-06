package main.model;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import main.dao.CircleDao;

public class Circle extends Shape {

    private double centerX;
    private double centerY;
    private double radius;

    public Circle() {
    }

    public Circle(User user) {
        super(new CircleDao(user), user);
    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.strokeOval(getCenterX() - getRadius(), getCenterY() - getRadius(), getRadius() * 2, getRadius() * 2);
    }

    @Override
    public void clear(GraphicsContext gc) {
        gc.clearRect(getCenterX() - getRadius(), getCenterY() - getRadius(), getRadius() * 2, getRadius() * 2);
    }

    @Override
    public boolean contains(Point2D point) {
        return (point.distance(new Point2D(centerX, centerY)) <= radius);
    }

    @Override
    public Point2D center() {
        return new Point2D(centerX, centerY);
    }

}
