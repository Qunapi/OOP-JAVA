package labOOP.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import labOOP.ShapesList;

import java.util.List;


public abstract class ShapeCreator  {
    protected GraphicsContext gc;
    protected String name = "Name";
    protected ShapesList shapeList;

    public String getName(){
        return this.name;
    };

    ShapeCreator(GraphicsContext context, ShapesList shapeList) {
        gc = context;
    }

    public abstract void dispatch(MouseEvent e);
}
