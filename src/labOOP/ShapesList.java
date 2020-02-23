package labOOP;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import labOOP.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class ShapesList extends ArrayList<Shape> {
    private List<Shape> shapesList;

    ShapesList() {
        shapesList = new ArrayList<Shape>();
    }

    public void draw() {
        shapesList.forEach(shape -> shape.draw());
    }

    public boolean add(Shape shape) {
        shapesList.add(shape);
        draw();
        return true;
    }

    public void remove(Shape shape) {
        shapesList.remove(shape);
        draw();
    }

    public void invalidated (Observable o){}
}
