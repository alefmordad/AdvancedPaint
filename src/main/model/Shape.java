package main.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import main.dao.Dao;
import main.utils.DaoException;

public abstract class Shape implements Model {

    private int identifier;
    private User user;
    private Paint stroke;
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

    public void setStroke(Paint p) {
        stroke = p;
    }

    public Paint getStroke() {
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

}
