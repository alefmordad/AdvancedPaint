package main.dao;

import main.model.User;
import main.model.model.shape.Line;

public class LineDao extends ShapeDao<Line> {

    public LineDao(User user) {
        super(Line.class, user);
    }

}
