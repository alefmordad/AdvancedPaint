package main.model;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import main.dao.LineDao;

public class Line extends Shape {

    private double startX;
    private double startY;
    private double endX;
    private double endY;

    public Line() {
    }

    public Line(User user) {
        super(new LineDao(user), user);
    }

    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public double getEndX() {
        return endX;
    }

    public void setEndX(double endX) {
        this.endX = endX;
    }

    public double getEndY() {
        return endY;
    }

    public void setEndY(double endY) {
        this.endY = endY;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.strokeLine(getStartX(), getStartY(), getEndX(), getEndY());
    }

    @Override
    public void clear(GraphicsContext gc) {
        double width = Math.abs(startX - endX);
        double height = Math.abs(startY - endY);
        Point2D rectangleStartPoint = topLeftOf(new Point2D(startX, startY), new Point2D(endX, endY));
        gc.clearRect(rectangleStartPoint.getX(), rectangleStartPoint.getY(), width, height);
    }

    @Override
    public boolean contains(Point2D point) {
        double width = Math.abs(startX - endX);
        double height = Math.abs(startY - endY);
        Point2D rectangleStartPoint = topLeftOf(new Point2D(startX, startY), new Point2D(endX, endY));
        Rectangle r = new Rectangle();
        r.setX(rectangleStartPoint.getX());
        r.setY(rectangleStartPoint.getY());
        r.setWidth(width);
        r.setHeight(height);
        return r.contains(point);
    }

    @Override
    public Point2D center() {
        return new Point2D((startX + endX) / 2, (startY + startY) / 2);
    }

    private static Point2D topLeftOf(Point2D base, Point2D end) {
        return new Point2D(Math.min(base.getX(), end.getX()), Math.min(base.getY(), end.getY()));
    }
}
