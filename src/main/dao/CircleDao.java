package main.dao;

import main.model.Circle;
import main.model.Shape;
import main.model.User;

public class CircleDao extends Dao<Shape> {

    public CircleDao(User user) {
        super(Circle.class, user);
    }
}
