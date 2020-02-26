package labOOP.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import labOOP.ShapesList;

import java.util.ArrayList;

public class PolygonalChainCreator extends ShapeCreator {

    enum State {waiting, nextPoint}

    private ArrayList<Point> points;
    private State state;
    private String name = "Polygon Chain";

    public String getName() {
        return name;
    }

    public PolygonalChainCreator(GraphicsContext gc, ShapesList shapeList) {
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
            }
        }
    }

    public void dispatch(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) {
            var shape = new PolygonalChain(points);
            points = new ArrayList<Point>();
            shapeList.add(shape, gc);
        }
        state = State.waiting;
    }

}
