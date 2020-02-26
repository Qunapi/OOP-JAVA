package labOOP.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Rhombus implements Shape {
    private Point firstPoint, secondPoint, thirdPoint, fourthPoint;

    public Rhombus(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.fourthPoint = fourthPoint;
    }

    public void draw(GraphicsContext gc) {
        gc.beginPath();
        gc.moveTo(firstPoint.getX(), firstPoint.getY());
        gc.lineTo(secondPoint.getX(), secondPoint.getY());
        gc.lineTo(thirdPoint.getX(), thirdPoint.getY());
        gc.lineTo(fourthPoint.getX(), fourthPoint.getY());
        gc.closePath();
        gc.stroke();
    }
}
