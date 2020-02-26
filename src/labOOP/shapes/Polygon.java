package labOOP.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;


public class Polygon implements Shape {
    private ArrayList<Point> points;

    public Polygon(ArrayList<Point> points) {
        this.points = points;
    }

    public void draw(GraphicsContext gc) {
        gc.beginPath();
        gc.moveTo(points.get(0).getX(), points.get(0).getY());
        for (int i = 1; i < points.size(); i++) {
            gc.lineTo(points.get(i).getX(), points.get(i).getY());
        }
        gc.closePath();
        gc.stroke();

    }
}