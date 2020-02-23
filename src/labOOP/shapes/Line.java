//package labOOP.shapes;
//
//import javafx.geometry.Point2D;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.input.MouseEvent;
//
//public class Line extends ShapeCreator {
//
//    enum State {waiting, firstPointSet}
//
//    private State state;
//    private Point2D firstPoint, secondPoint;
//
//    public Line(GraphicsContext gc) {
//        super(gc);
//        state = State.waiting;
//    }
//
//    public void startDrawing() {
//
//    }
//    public void endDrawing(){
//
//    }
//
//    public void dispatch(MouseEvent e) {
//        switch (state) {
//            case waiting: {
//                firstPoint = new Point2D(e.getX(), e.getY());
//                state = State.firstPointSet;
//                break;
//            }
//            case firstPointSet: {
//                secondPoint = new Point2D(e.getX(), e.getY());
//                gc.strokeLine(e.getX(),e.getY(), firstPoint.getX(), firstPoint.getY());
//                state = State.waiting;
//                break;
//            }
//        }
//    }
//}
