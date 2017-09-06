package main.model;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import main.dao.Dao;
import main.utils.DaoException;

public abstract class Shape implements Model {

    private int identifier;
    private User user;
    private String stroke;
    private Dao dao;

    public Shape() {
    }

    public Shape(Dao dao, User user) {
        this.dao = dao;
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
        dao.create(this);
    }

    public abstract void draw(GraphicsContext gc);

    public abstract void clear(GraphicsContext gc);

    public abstract boolean contains(Point2D point);

    public abstract Point2D center();

    public void update() throws DaoException {
        dao.update(this);
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
