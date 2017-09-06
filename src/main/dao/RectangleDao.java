package main.dao;

import main.model.Rectangle;
import main.utils.DaoException;

public class RectangleDao extends Dao<Rectangle> {

    public RectangleDao() {
        super(Rectangle.class);
    }

    @Override
    public Rectangle get(Rectangle rectangle) throws DaoException {
        return null;
    }
}
