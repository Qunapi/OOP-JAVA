package labOOP.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Circle implements Shape{
    private Point center;
    private int radius;

    public Circle(Point center, int radius){
        this.center = center;
        this.radius = radius;
    }

    public void draw(GraphicsContext gc) {
        gc.strokeOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
    }
}
