package main.model.dao;

import main.model.User;
import main.model.model.shape.Rectangle;

public class RectangleDao extends ShapeDao {

    public RectangleDao(User user) {
        super(Rectangle.class, user);
    }

}
