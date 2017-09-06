package main.model.model.shape;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.dao.Dao;
import main.model.Model;
import main.model.User;
import main.utils.utils.exceptions.DaoException;

public abstract class Shape implements Model {

    private int identifier;
    private User user;
    private String stroke;

    public Shape() {
    }

    public Shape(User user) {
        this.user = user;
    }

    @Override
    public int getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public String getStroke() {
        return stroke;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void save() throws DaoException {
        dao().create(this);
    }

    public abstract void draw(GraphicsContext gc);

    public void clear(GraphicsContext gc) {
        gc.setStroke(Color.WHITE);
        draw(gc);
    }

    public abstract boolean contains(Point2D point);

    public abstract Point2D center();

    public abstract Dao dao();

    public void update() throws DaoException {
        dao().update(this);
    }

    @Override
    public Object clone() {
        Shape shape;
        if (this instanceof Rectangle)
            shape = new Rectangle(user);
        else if (this instanceof Line)
            shape = new Line(user);
        else
            shape = new Circle(user);
        return shape;
    }
}
