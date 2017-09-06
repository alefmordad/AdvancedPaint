package main.model;

import javafx.scene.paint.Paint;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Canvas {

    private javafx.scene.canvas.Canvas canvas;
    private Set<Shape> shapes = new HashSet<>();
    private double scale = 1;

    public Canvas(javafx.scene.canvas.Canvas canvas) {
        this.canvas = canvas;
    }

    public void zoomIn() {
        scale *= 1.1;
        setXYScale();
    }

    public void zoomOut() {
        scale /= 1.1;
        setXYScale();
    }

    public void resetZoom() {
        scale = 1;
        setXYScale();
    }

    private void setXYScale() {
        canvas.setScaleX(scale);
        canvas.setScaleY(scale);
    }

    public void draw(Shape shape) {
        shapes.add(shape);
        canvas.getGraphicsContext2D().setStroke(Paint.valueOf(shape.getStroke()));
        shape.draw(canvas.getGraphicsContext2D());
    }

    public void draw(List<Shape> shapes) {
        shapes.stream().forEach(shape -> draw(shape));
    }

    public void clear() {
        shapes.clear();
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}