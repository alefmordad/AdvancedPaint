package main.dao;

import main.model.User;
import main.model.model.shape.Circle;

public class CircleDao extends ShapeDao<Circle> {

    public CircleDao(User user) {
        super(Circle.class, user);
    }

}
