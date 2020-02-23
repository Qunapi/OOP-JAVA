package labOOP;

import javafx.scene.canvas.GraphicsContext;
import labOOP.shapes.Shape;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShapesList implements Serializable {
    public List<Shape> shapesList;

    ShapesList(GraphicsContext gc) {
        shapesList = new ArrayList<Shape>();
    }

    public void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, 2000, 2000);
        shapesList.forEach(shape -> shape.draw(gc));
    }

    public boolean add(Shape shape, GraphicsContext gc) {
        shapesList.add(shape);
        draw(gc);
        return true;
    }

    public void remove(Shape shape, GraphicsContext gc) {
        shapesList.remove(shape);
        draw(gc);
    }
}
