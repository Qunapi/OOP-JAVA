package labOOP.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import labOOP.ShapesList;

import java.util.List;

public class CircleCreator extends ShapeCreator {

    enum State {waiting, centerSet}

    private Point2D center;
    private State state;


    public CircleCreator(GraphicsContext gc, ShapesList shapeList) {
        super(gc, shapeList);
        state = State.waiting;
        this.shapeList = shapeList;
    }

    public void dispatch(MouseEvent e) {
        switch (state) {
            case waiting: {
                center = new Point2D(e.getX(), e.getY());
                state = State.centerSet;
                break;
            }
            case centerSet: {
                var x = e.getX();
                var y = e.getY();
                var radius = (int) Math.sqrt(Math.pow(center.getX() - x, 2) + Math.pow(center.getY() - y, 2));
                var shape = new Circle(center, radius, gc);
                shapeList.add(shape);
                state = State.waiting;
                break;
            }
        }
    }
}
