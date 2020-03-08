package labOOP.shapes;

import Shapes.Point;
import Shapes.Shape;
import javafx.scene.canvas.GraphicsContext;

public class Rectangle implements Shape {
    private Point firstPoint, secondPoint;

    public Rectangle(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public void draw(GraphicsContext gc) {
        var width = Math.abs(firstPoint.getX() - secondPoint.getX());
        var height = Math.abs(firstPoint.getY() - secondPoint.getY());
        var x = Math.min(firstPoint.getX(), secondPoint.getX());
        var y = Math.min(firstPoint.getY(), secondPoint.getY());
        gc.strokeRect(x, y, width, height);
    }
}
