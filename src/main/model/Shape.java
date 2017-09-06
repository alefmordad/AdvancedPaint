package main.model;

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

}
