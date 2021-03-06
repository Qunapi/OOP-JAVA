package Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public abstract class ShapeCreator {
    protected GraphicsContext gc;
    protected String name = "Name";
    protected ShapesList shapeList;

    public String getName() {
        return this.name;
    }

    public ShapeCreator(GraphicsContext context) {
        gc = context;
    }

    public abstract void dispatch(MouseEvent e);
    public void dispatch(KeyEvent e){};
}
