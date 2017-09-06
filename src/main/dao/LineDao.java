package main.dao;

import main.model.model.shape.Line;
import main.model.model.shape.Shape;
import main.model.User;

public class LineDao extends Dao<Shape> {

    public LineDao(User user) {
        super(Line.class, user);
    }

}
