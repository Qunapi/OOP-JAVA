import Shapes.Point;
import Shapes.ShapeCreator;
import Shapes.ShapesList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

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
                var x1 = firstPoint.getX();
                var x2 = secondPoint.getX();
                var x3 = thirdPoint.getX();
                var x4 = e.getX();
                var y1 = firstPoint.getY();
                var y2 = secondPoint.getY();
                var y3 = thirdPoint.getY();
                var y4 = e.getY();

                var lambda = ((x4 - x3) * (x2 - x1) + (y4 - y3) * (y2 - y1)) / (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

                var x = lambda * (x2 - x1) + x3;
                var y = lambda * (y2 - y1) + y3;

                fourthPoint = new Point(x, y);
                var shape = new Trapezium(firstPoint, secondPoint, thirdPoint, fourthPoint);
                shapeList.add(shape, gc);
                state = State.waiting;
                break;
            }
        }
    }
}