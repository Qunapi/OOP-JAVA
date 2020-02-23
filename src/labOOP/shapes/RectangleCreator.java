package labOOP.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import labOOP.ShapesList;

import java.util.List;

public class RectangleCreator extends ShapeCreator {

    enum State {waiting, firstPointSet}

    private Point2D firstPoint, secondPoint;
    private State state;

    public RectangleCreator(GraphicsContext gc, ShapesList shapeList) {
        super(gc, shapeList);
        state = State.waiting;
        this.shapeList = shapeList;
    }

    public void dispatch(MouseEvent e) {
        switch (state) {
            case waiting: {
                firstPoint = new Point2D(e.getX(), e.getY());
                state = State.firstPointSet;
                break;
            }
            case firstPointSet: {
                secondPoint = new Point2D(e.getX(), e.getY());
                var shape = new Rectangle(firstPoint, secondPoint, gc);
                shapeList.add(shape);
                state = State.waiting;
                break;
            }
        }
    }
}