package labOOP.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import labOOP.ShapesList;

public class LineCreator extends ShapeCreator {

    enum State {waiting, firstPointSet}

    private Point firstPoint, secondPoint;
    private State state;
    private String name = "Line";

    public String getName() {
        return name;
    }

    public LineCreator(GraphicsContext gc, ShapesList shapeList) {
        super(gc, shapeList);
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
                var shape = new Line(firstPoint, secondPoint, gc);
                shapeList.add(shape, gc);
                state = State.waiting;
                break;
            }
        }
    }
}
