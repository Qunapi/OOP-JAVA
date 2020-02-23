package labOOP.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;

public interface Shape extends Serializable{

    public void draw(GraphicsContext gc);


}

