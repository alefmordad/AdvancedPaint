package main.model;

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
        super(new LineDao(), user);
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
}
