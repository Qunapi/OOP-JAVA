package labOOP.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Line implements Shape {
    private Point2D firstPoint, secondPoint;
    private GraphicsContext gc;

    public Line(Point2D firstPoint, Point2D secondPoint, GraphicsContext gc) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.gc = gc;
    }

    public void draw() {
        gc.strokeLine(firstPoint.getX(), firstPoint.getY(), secondPoint.getX(), secondPoint.getY());
    }
}
