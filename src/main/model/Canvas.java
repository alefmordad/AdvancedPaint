package main.model;

import javafx.scene.paint.Paint;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Canvas {

    private javafx.scene.canvas.Canvas canvas;
    private Set<Shape> shapes = new HashSet<>();

    public Canvas(javafx.scene.canvas.Canvas canvas) {
        this.canvas = canvas;
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