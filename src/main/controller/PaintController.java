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
    public ColorPicker colorPicker;

    @FXML
    public javafx.scene.canvas.Canvas jfxCanvas;

    private Shape shape;
    private State state;
    private Point2D base;
    private Point2D end;
    private Canvas canvas;
    private User user;
    private boolean isInitialized = false;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void circleClick() {
        state = State.CREATE;
        shape = new Circle(user);
    }

    public void rectangleClick() {
        state = State.CREATE;
        shape = new Rectangle(user);
    }

    public void lineClick() {
        state = State.CREATE;
        shape = new Line(user);
    }

    public void canvasMousePressed(MouseEvent mouseEvent) {
        if (!isInitialized) {
            initialize();
            isInitialized = true;
        }
        base = parsePoint(mouseEvent);
    }

    public void canvasMouseReleased(MouseEvent mouseEvent) {
        end = parsePoint(mouseEvent);
        prepareShapeAppearance(shape);
        switch (state) {
            case CREATE:
                generateShape(shape, base, end);
                canvas.add(shape);
                break;
        }
    }

    private void generateShape(Shape shape, Point2D base, Point2D end) {
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
    }

    private void prepareShapeAppearance(Shape shape) {
        shape.setStroke(pickColor());
    }

    private Color pickColor() {
        return colorPicker.getValue();
    }

    private void initialize() {
        state = State.CREATE;
        shape = new Circle(user);
        base = new Point2D(0, 0);
        end = new Point2D(0, 0);
        canvas = new Canvas(jfxCanvas);
    }

    private Point2D parsePoint(MouseEvent mouseEvent) {
        return new Point2D(mouseEvent.getX(), mouseEvent.getY());
    }
}
