package main.dao;

import main.model.Line;
import main.model.Shape;
import main.model.User;

public class LineDao extends Dao<Shape> {

    public LineDao(User user) {
        super(Line.class, user);
    }

}
