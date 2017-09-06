package main.model;

import java.util.HashSet;
import java.util.Set;

public class Canvas {

    private javafx.scene.canvas.Canvas canvas;
    private Set<Shape> shapes = new HashSet<>();

    public Canvas(javafx.scene.canvas.Canvas canvas) {
        this.canvas = canvas;
    }

    public void add(Shape shape) {
        shapes.add(shape);
        canvas.getGraphicsContext2D().setStroke(shape.getStroke());
        shape.draw(canvas.getGraphicsContext2D());
    }
}
