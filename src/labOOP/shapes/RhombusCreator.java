package labOOP.shapes;

import Shapes.Point;
import Shapes.ShapeCreator;
import Shapes.ShapesList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class RhombusCreator extends ShapeCreator {
    enum State {waiting, firstPointSet, secondPointSet}

    private Point firstPoint, secondPoint, thirdPoint, fourthPoint;
    private State state;
    private String name = "Rhombus";

    public String getName() {
        return name;
    }

    public RhombusCreator(GraphicsContext gc, ShapesList shapeList) {
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

                var firstY = firstPoint.getY();
                var secondY = secondPoint.getY();
                var thirdY = thirdPoint.getY();

                var firstX = firstPoint.getX();
                var secondX = secondPoint.getX();
                var thirdX = thirdPoint.getX();

                var y = secondY + (firstY - secondY)  + (thirdY - secondY);
                var x = secondX + (firstX - secondX)  + (thirdX - secondX);
                var fourthPoint = new Point(x, y);

                var shape = new Rhombus(firstPoint, secondPoint, thirdPoint, fourthPoint);
                shapeList.add(shape, gc);
                state = State.waiting;
            }
        }
    }
}