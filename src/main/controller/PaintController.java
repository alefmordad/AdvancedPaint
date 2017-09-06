package main.controller;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import main.model.*;

import static java.lang.Math.abs;

public class PaintController {

    @FXML
    ColorPicker colorPicker;

    @FXML
    javafx.scene.canvas.Canvas javafxCanvas;

    private Shape shape;
    private State state;
    private Point2D base;
    private Point2D end;
    private Canvas canvas;
    private boolean isInitialized;

    {
        state = State.CREATE;
        shape = new Circle();
        base = new Point2D(0, 0);
        end = new Point2D(0, 0);
        isInitialized = false;
    }

    public void circleClick() {
        state = State.CREATE;
        shape = new Circle();
    }

    public void rectangleClick() {
        state = State.CREATE;
        shape = new Rectangle();
    }

    public void lineClick() {
        state = State.CREATE;
        shape = new Line();
    }

    public void canvasMousePressed(MouseEvent mouseEvent) {
        if (!isInitialized) {
            initialize();
            isInitialized = true;
        }
        base = new Point2D(mouseEvent.getX(), mouseEvent.getY());
    }

    public void canvasMouseReleased(MouseEvent mouseEvent) {
        end = new Point2D(mouseEvent.getX(), mouseEvent.getY());
        shape.setStroke(pickColor());
        switch (state) {
            case CREATE:
                if (shape instanceof Circle) {
                    ((Circle) shape).setCenterX(base.getX());
                    ((Circle) shape).setCenterY(base.getY());
                    ((Circle) shape).setRadius(base.distance(end));
                } else if (shape instanceof Rectangle) {
                    ((Rectangle) shape).setX(base.getX());
                    ((Rectangle) shape).setY(base.getY());
                    ((Rectangle) shape).setWidth(abs(base.getX() - end.getX()));
                    ((Rectangle) shape).setHeight(abs(base.getY() - end.getY()));
                } else if (shape instanceof Line) {
                    ((Line) shape).setStartX(base.getX());
                    ((Line) shape).setStartY(base.getY());
                    ((Line) shape).setEndX(end.getX());
                    ((Line) shape).setEndY(end.getY());
                }
                canvas.add(shape);
                break;
        }
    }

    private Color pickColor() {
        return colorPicker.getValue();
    }

    private void initialize() {
        canvas = new Canvas(javafxCanvas);
    }

}
