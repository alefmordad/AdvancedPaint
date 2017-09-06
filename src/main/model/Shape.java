package main.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public interface Shape extends Model {

    void draw(GraphicsContext gc);
    void setStroke(Paint p);
    Paint getStroke();
    void setFill(Paint p);
    Paint getFill();
    User getUser();

}
