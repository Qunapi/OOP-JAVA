package labOOP.shapes;

import Shapes.Point;
import Shapes.Shape;
import javafx.scene.canvas.GraphicsContext;

public class Line implements Shape {
    private Point firstPoint, secondPoint;

    public Line(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public void draw(GraphicsContext gc) {
        gc.strokeLine(firstPoint.getX(), firstPoint.getY(), secondPoint.getX(), secondPoint.getY());
    }
}
