package labOOP.shapes;

import Shapes.Point;
import Shapes.ShapeCreator;
import Shapes.ShapesList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class CircleCreator extends ShapeCreator {

    enum State {waiting, centerSet}

    private Point center;
    private State state;
    private String name = "Circle";

    public String getName() {
        return name;
    }

    public CircleCreator(GraphicsContext gc, ShapesList shapeList) {
        super(gc);
        state = State.waiting;
        this.shapeList = shapeList;
    }

    public void dispatch(MouseEvent e) {
        switch (state) {
            case waiting: {
                center = new Point(e.getX(), e.getY());
                state = State.centerSet;
                break;
            }
            case centerSet: {
                var x = e.getX();
                var y = e.getY();
                var radius = (int) Math.sqrt(Math.pow(center.getX() - x, 2) + Math.pow(center.getY() - y, 2));
                var shape = new Circle(center, radius);
                shapeList.add(shape, gc);
                state = State.waiting;
                break;
            }
        }
    }
}
