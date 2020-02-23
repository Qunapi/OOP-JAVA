package labOOP.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Rectangle implements Shape {
    private Point2D firstPoint, secondPoint;
    private GraphicsContext gc;

    public Rectangle(Point2D firstPoint,Point2D secondPoint, GraphicsContext gc){
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.gc = gc;
    }

    public void draw() {
        var width = Math.abs(firstPoint.getX() - secondPoint.getX());
        var height = Math.abs(firstPoint.getY() - secondPoint.getY());
        var x = Math.min(firstPoint.getX(), secondPoint.getX());
        var y = Math.min(firstPoint.getY(), secondPoint.getY());
        gc.strokeRect(x, y, width, height);
    }
}
