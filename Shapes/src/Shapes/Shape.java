package Shapes;

import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;

public interface Shape extends Serializable {
    void draw(GraphicsContext gc);
}

