package labOOP.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import labOOP.ShapesList;

public class TrapeziumCreator extends ShapeCreator {
    enum State {waiting, firstPointSet, secondPointSet, thirdPointSet}

    private Point firstPoint, secondPoint, thirdPoint, fourthPoint;
    private State state;
    private String name = "Trapezium";

    public String getName() {
        return name;
    }

    public TrapeziumCreator(GraphicsContext gc, ShapesList shapeList) {
        super(gc);
        state = State.waiting;
        this.shapeList = shapeList;
    }

    public void dispatch(MouseEvent e) {
        switch (state) {
            case waiting: {
                firstPoint = new Point(e.getX(), e.getY());
                state = State.firstPointSet;
                break;
            }
            case firstPointSet: {
                secondPoint = new Point(e.getX(), e.getY());
                state = State.secondPointSet;
                break;
            }
            case secondPointSet: {
                thirdPoint = new Point(e.getX(), e.getY());
                state = State.thirdPointSet;
                break;
            }
            case thirdPointSet: {
                fourthPoint = new Point(e.getX(), e.getY());
                var shape = new Trapezium(firstPoint, secondPoint, thirdPoint, fourthPoint);
                shapeList.add(shape, gc);
                state = State.waiting;
                break;
            }
        }
    }
}