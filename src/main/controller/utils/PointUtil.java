package main.controller.utils;

import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

public class PointUtil {

    public static Point2D parsePoint(MouseEvent mouseEvent) {
        return new Point2D(mouseEvent.getX(), mouseEvent.getY());
    }

    public static Point2D topLeftOf(Point2D base, Point2D end) {
        return new Point2D(Math.min(base.getX(), end.getX()), Math.min(base.getY(), end.getY()));
    }

}
