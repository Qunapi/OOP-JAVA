package labOOP.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Circle implements Shape {
    private Point2D center;
    private int radius;
    private GraphicsContext gc;

    public Circle(Point2D center, int radius, GraphicsContext gc){
        this.center = center;
        this.radius = radius;
        this.gc = gc;
    }

    public void draw() {
//        radius = 100;
        gc.strokeOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
    }
}
