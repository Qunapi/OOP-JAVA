package labOOP;

import io.github.classgraph.*;
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
        primaryStage.setTitle("OOP");

        var borderPane = new BorderPane();
        var scene = new Scene(borderPane, 640, 480);
        primaryStage.setScene(scene);
        primaryStage.show();

        var menuBar = new MenuBar();

        var shapesMenu = new Menu("Shapes");

        var canvas = new Canvas(600, 600);
        gc = canvas.getGraphicsContext2D();
        canvas.setOnMouseClicked(mouseEvent -> shapesMenuList.dispatch(mouseEvent));
        scene.setOnKeyReleased(keyEvent -> shapesMenuList.dispatch(keyEvent));

        shapesList = new ShapesList(gc);

        var openBtn = new MenuItem("Open");
        openBtn.setOnAction((e) -> openList());

        var saveBtn = new MenuItem("Save");
        saveBtn.setOnAction((e) -> saveList());

        var serializationMenu = new Menu("Serialisation");
        serializationMenu.getItems().addAll(saveBtn, openBtn);

        shapesMenuList = new ShapesSelector();

        ScanResult scanResult = new ClassGraph()
                .enableClassInfo()
                .scan();

        for (ClassInfo routeClassInfo : scanResult.getSubclasses(ShapeCreator.class.getName())) {
            Class da2 = Class.forName(routeClassInfo.getName());
            var shapeCreator = (ShapeCreator) da2.getDeclaredConstructor(GraphicsContext.class, ShapesList.class).newInstance(gc, shapesList);
            shapesMenuList.addShape(shapeCreator);
        }

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
        }
    }

    ;

    private void saveList() {
        File f = new File("data.list");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(shapesList);
        } catch (Exception e) {
        }
    }
}
