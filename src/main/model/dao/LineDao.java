package main.model.dao;

import main.model.User;
import main.model.model.shape.Line;

public class LineDao extends ShapeDao {

    public LineDao(User user) {
        super(Line.class, user);
    }

}
