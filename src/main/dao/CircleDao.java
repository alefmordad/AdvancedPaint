package main.dao;

import main.model.Circle;
import main.utils.DaoException;

public class CircleDao extends Dao<Circle> {

    public CircleDao() {
        super(Circle.class);
    }

    @Override
    public Circle get(Circle circle) throws DaoException {
        return null;
    }
}
