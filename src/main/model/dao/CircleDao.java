package main.model.dao;

import main.model.User;
import main.model.model.shape.Circle;

public class CircleDao extends ShapeDao {

    public CircleDao(User user) {
        super(Circle.class, user);
    }

}
