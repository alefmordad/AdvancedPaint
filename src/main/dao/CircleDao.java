package main.dao;

import main.model.model.shape.Circle;
import main.model.model.shape.Shape;
import main.model.User;

public class CircleDao extends Dao<Shape> {

    public CircleDao(User user) {
        super(Circle.class, user);
    }

}
