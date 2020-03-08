package Shapes;

import Shapes.Shape;
import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShapesList implements Serializable {
    public List<Shape> shapesList;

    public ShapesList(GraphicsContext gc) {
        shapesList = new ArrayList<Shape>();
    }

    public void draw(GraphicsContext gc) {
        gc.clearRect(0, 0,gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
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
