package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {
    private Circle circle;
    private Button left;
    private Button right;
    private Button up;
    private Button down;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();
        circle = new Circle(200, 170, 50);
        left = new Button("Left");
        right = new Button("Right");
        up = new Button("Up");
        down = new Button("Down");
        left.setOnAction(event -> setLeft());
        right.setOnAction(event -> setRight());
        up.setOnAction(event -> setUp());
        down.setOnAction(event -> setDown());
        HBox hBox = new HBox();
        hBox.setLayoutY(300);
        hBox.setLayoutX(100);
        hBox.setSpacing(10);
        hBox.getChildren().addAll(left, right, up, down);
        pane.getChildren().addAll(circle, hBox);
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ex-15-03");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    void setLeft(){
       circle.setCenterX(circle.getCenterX() - 10);
    }
    void setRight(){
        circle.setCenterX(circle.getCenterX() + 10);
    }
    void setUp(){
        circle.setCenterY(circle.getCenterY() - 10);
    }
    void setDown(){
        circle.setCenterY(circle.getCenterY() + 10);
    }
}