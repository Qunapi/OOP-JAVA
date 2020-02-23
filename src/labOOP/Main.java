package labOOP;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import labOOP.shapes.*;

import java.io.*;


public class Main extends Application {

    private ShapesSelector shapesMenuList;
    private ShapesList shapesList;
    private GraphicsContext gc;

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World");

        var borderPane = new BorderPane();
        var scene = new Scene(borderPane, 640, 480);
        primaryStage.setScene(scene);
        primaryStage.show();

        var menuBar = new MenuBar();
        var button = new Button();

        var shapesMenu = new Menu("Shapes");

        var canvas = new Canvas(600, 600);
        gc = canvas.getGraphicsContext2D();
        canvas.setOnMouseClicked(mouseEvent -> {
            shapesMenuList.dispatch(mouseEvent);
        });

        shapesList = new ShapesList(gc);

        var openBtn = new MenuItem("Open");
        openBtn.setOnAction((e) -> openList());

        var saveBtn = new MenuItem("Save");
        saveBtn.setOnAction((e) -> saveList());

        var serializationMenu = new Menu("Serialisation");
        serializationMenu.getItems().addAll(saveBtn, openBtn);

        shapesMenuList = new ShapesSelector();
        shapesMenuList.addShape(new CircleCreator(gc, shapesList));
        shapesMenuList.addShape(new RectangleCreator(gc, shapesList));
        shapesMenuList.addShape(new LineCreator(gc, shapesList));
        shapesMenuList.addShape(new TrapeziumCreator(gc, shapesList));

        menuBar.getMenus().addAll(shapesMenu, serializationMenu);
        borderPane.setTop(menuBar);
        shapesMenu.getItems().addAll(shapesMenuList.menuItems);

        borderPane.setCenter(canvas);
    }

    private void openList() {
        var f = new File("data.list");
        try {
            var fis = new FileInputStream(f);
            var oos = new ObjectInputStream(fis);

            var newShapesList = (ShapesList) oos.readObject();
            newShapesList.shapesList.forEach(shape -> shapesList.add(shape, gc));

        } catch (Exception e) {
            var a = 5;
        }
    }

    ;

    private void saveList() {
        File f = new File("data.list");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(shapesList);
//            var a = 5;
//            FileUtils.writeLines(new File("input.txt"), MenuArray)
        } catch (Exception e) {
            var a = 5;
        }
    }
}
