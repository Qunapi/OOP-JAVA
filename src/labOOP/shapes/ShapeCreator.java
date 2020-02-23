package labOOP.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

import java.util.List;


public abstract class ShapeCreator {
    protected GraphicsContext gc;
    protected String name;
    protected List<Shape> shapeList;

    ShapeCreator(GraphicsContext context, List<Shape> shapeList) {
        gc = context;
    }

    public abstract void dispatch(MouseEvent e);
}
