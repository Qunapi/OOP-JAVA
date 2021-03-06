
package labOOP.shapes;

import Shapes.Point;
import Shapes.ShapeCreator;
import Shapes.ShapesList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class PolygonCreator extends ShapeCreator {

    enum State {waiting, nextPoint}

    private ArrayList<Point> points;
    private State state;
    private String name = "Polygon";

    public String getName() {
        return name;
    }

    public PolygonCreator(GraphicsContext gc, ShapesList shapeList) {
        super(gc);
        state = State.waiting;
        points = new ArrayList<Point>();
        this.shapeList = shapeList;
    }

    public void dispatch(MouseEvent e) {
        switch (state) {
            case waiting: {
                points.add(new Point(e.getX(), e.getY()));
                state = State.nextPoint;
                break;
            }
            case nextPoint: {
                points.add(new Point(e.getX(), e.getY()));
//              break;
            }
        }
    }

    public void dispatch(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) {
            var shape = new Polygon(points);
            points = new ArrayList<Point>();
            shapeList.add(shape, gc);
        }
        state = State.waiting;
    }

}
