package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;




public class Main extends Application {

    private Rectangle rectangle;
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        rectangle = new Rectangle(100, 50, 70, 50);
        rectangle.setStroke(Color.BLACK);
        Button rotate = new Button("Rotate");
        rotate.setLayoutX(100);
        rotate.setLayoutY(150);
        rotate.setOnAction(event -> setRotate());
        pane.getChildren().addAll(rectangle, rotate);
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("15-02");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    void setRotate() {
        rectangle.setRotate(rectangle.getRotate() + 20);
    }
}