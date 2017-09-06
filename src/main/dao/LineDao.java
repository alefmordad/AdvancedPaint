package main.dao;

import main.model.Line;
import main.utils.DaoException;

public class LineDao extends Dao<Line> {

    public LineDao() {
        super(Line.class);
    }

    @Override
    public Line get(Line line) throws DaoException {
        return null;
    }
}
