
package labOOP.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;


public class PolygonalChain implements Shape {
    private ArrayList<Point> points;

    public PolygonalChain(ArrayList<Point> points) {
        this.points = points;
    }

    public void draw(GraphicsContext gc) {
        gc.beginPath();
        var x = points.get(0).getX();
        var y = points.get(0).getY();
        for (int i = 1; i < points.size(); i++) {
            gc.strokeLine(x, y, points.get(i).getX(), points.get(i).getY());
            x = points.get(i).getX();
            y = points.get(i).getY();
        }
        gc.closePath();
        gc.stroke();

    }
}