package main.dao;

import main.model.model.shape.Rectangle;
import main.model.model.shape.Shape;
import main.model.User;

public class RectangleDao extends Dao<Shape> {

    public RectangleDao(User user) {
        super(Rectangle.class, user);
    }

}
