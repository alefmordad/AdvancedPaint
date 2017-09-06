package main.controller;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import main.dao.CircleDao;
import main.dao.LineDao;
import main.dao.RectangleDao;
import main.model.Canvas;
import main.model.UsageState;
import main.model.User;
import main.model.model.shape.Circle;
import main.model.model.shape.Line;
import main.model.model.shape.Rectangle;
import main.model.model.shape.Shape;
import main.utils.utils.exceptions.DaoException;

import static java.lang.Math.abs;

public class PaintController {

    @FXML
    ColorPicker colorPicker;
    @FXML
    javafx.scene.canvas.Canvas jfxCanvas;
    @FXML
    Button btnLoad;
    @FXML
    Button btnCircle;
    @FXML
    Button btnRectangle;
    @FXML
    Button btnLine;
    @FXML
    Button btnChangeColor;
    @FXML
    Button btnZoomIn;
    @FXML
    Button btnZoomOut;
    @FXML
    Button btnResetZoom;
    @FXML
    Button btnClear;

    private Shape shape;
    private UsageState state;
    private Point2D base;
    private Point2D end;
    private Canvas canvas;
    private User user;
    private CircleDao circleDao;
    private RectangleDao rectangleDao;
    private LineDao lineDao;
    private boolean isInitialized;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void loadClicked() {
        initialize();
    }

    public void changeColorClicked() {
        state = UsageState.SELECT;
    }

    public void zoomInClicked() {
        canvas.zoomIn();
    }

    public void zoomOutClicked() {
        canvas.zoomOut();
    }

    public void zoomResetClicked() {
        canvas.resetZoom();
    }

    public void circleClicked() {
        state = UsageState.CREATE;
        shape = new Circle(user);
    }

    public void rectangleClicked() {
        state = UsageState.CREATE;
        shape = new Rectangle(user);
    }

    public void lineClicked() {
        state = UsageState.CREATE;
        shape = new Line(user);
    }

    public void canvasMousePressed(MouseEvent mouseEvent) {
        base = parsePoint(mouseEvent);
    }

    public void canvasMouseReleased(MouseEvent mouseEvent) throws DaoException {
        end = parsePoint(mouseEvent);
        switch (state) {
            case CREATE:
                shape = (Shape) shape.clone();
                prepareShapeAppearance(shape);
                generateShape(shape, base, end);
                canvas.draw(shape);
                shape.save();
                break;
            case SELECT:
                shape = canvas.selectedShape(mouseEvent);
                if (shape == null)
                    return;
                shape.setStroke(pickColor().toString());
                canvas.changeColor(shape);
                shape.update();
                break;
        }
    }

    public void clearClicked() {
        canvas.clear();
        try {
            circleDao.clearFromUser();
            rectangleDao.clearFromUser();
            lineDao.clearFromUser();
        } catch (DaoException e) {
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
        shape.setStroke(pickColor().toString());
    }

    private Color pickColor() {
        return colorPicker.getValue();
    }

    private void initialize() {
        if (!isInitialized) {
            enableComponents();
            initializeFields();
            loadShapes();
            isInitialized = true;
        }
    }

    private void initializeFields() {
        state = UsageState.CREATE;
        shape = new Circle(user);
        base = new Point2D(0, 0);
        end = new Point2D(0, 0);
        circleDao = new CircleDao(user);
        rectangleDao = new RectangleDao(user);
        lineDao = new LineDao(user);
        canvas = new Canvas(jfxCanvas);
    }

    private void enableComponents() {
        btnLoad.setText("Load Done");
        btnLoad.setDisable(true);
        btnCircle.setDisable(false);
        btnRectangle.setDisable(false);
        btnLine.setDisable(false);
        btnChangeColor.setDisable(false);
        btnZoomIn.setDisable(false);
        btnZoomOut.setDisable(false);
        btnResetZoom.setDisable(false);
        btnClear.setDisable(false);
        colorPicker.setDisable(false);
        jfxCanvas.setDisable(false);
    }

    private void loadShapes() {
        try {
            canvas.draw(circleDao.getAll());
            canvas.draw(rectangleDao.getAll());
            canvas.draw(lineDao.getAll());
        } catch (DaoException e) {
        }
    }

    private Point2D parsePoint(MouseEvent mouseEvent) {
        return new Point2D(mouseEvent.getX(), mouseEvent.getY());
    }
}
