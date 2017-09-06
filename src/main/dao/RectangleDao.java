package main.dao;

import main.model.Rectangle;
import main.model.Shape;
import main.model.User;

public class RectangleDao extends Dao<Shape> {

    public RectangleDao(User user) {
        super(Rectangle.class, user);
    }

}
