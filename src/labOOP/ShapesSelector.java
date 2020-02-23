package labOOP;

import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import labOOP.shapes.Shape;
import labOOP.shapes.ShapeCreator;

import java.util.ArrayList;
import java.util.List;

public class ShapesSelector extends ArrayList<Shape> {

    List<MenuItem> menuItems;
    ShapeCreator selectedShapeCreator;

    ShapesSelector() {
        menuItems = new ArrayList();
    }

    public void addShape(ShapeCreator shapeCreator) {
        var menuItem = new MenuItem(shapeCreator.getName());
        menuItems.add(menuItem);
        menuItem.setOnAction((event) -> {
            selectedShapeCreator = shapeCreator;
        });
    }

    public void dispatch(MouseEvent e) {
        if (selectedShapeCreator != null) selectedShapeCreator.dispatch(e);
    }
}
