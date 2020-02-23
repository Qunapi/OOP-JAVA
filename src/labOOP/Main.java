package labOOP;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import labOOP.shapes.*;


public class Main extends Application {

    private Scene scene;
    private MenuBar menuBar;
    private Menu menu;
    private ShapesSelector shapesMenuList;
    private Canvas canvas;
    private GraphicsContext gc;
    private ShapesList shapeList;


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World");
        shapeList = new ShapesList();

        var borderPane = new BorderPane();
        scene = new Scene(borderPane, 640, 480);
        primaryStage.setScene(scene);
        primaryStage.show();

        menuBar = new MenuBar();
        menu = new Menu("Shapes");

        canvas = new Canvas(600, 600);
        gc = canvas.getGraphicsContext2D();
        canvas.setOnMouseClicked(mouseEvent -> {
            shapesMenuList.dispatch(mouseEvent);
        });

        shapesMenuList = new ShapesSelector();
        shapesMenuList.addShape(new CircleCreator(gc, shapeList));
        shapesMenuList.addShape(new RectangleCreator(gc, shapeList));
        shapesMenuList.addShape(new LineCreator(gc, shapeList));

        menuBar.getMenus().add(menu);
        borderPane.setTop(menuBar);
        menu.getItems().addAll(shapesMenuList.menuItems);

        borderPane.setCenter(canvas);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
