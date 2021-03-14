package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Time;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Car pane = new Car();
        pane.setOnMousePressed(e -> pane.pause());
        pane.setOnMouseReleased(e -> pane.play());
        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                pane.increase();
            } else if (e.getCode() == KeyCode.DOWN) {
                pane.decrease();
            }
        });
        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setTitle("Ex15_29");
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.requestFocus();
}
    public static void main(String[] args) {
        launch(args);
    }
    public class Car extends Pane {
        private double x = 0;
        private double y = 100;
        private double radius = 5;
        private Rectangle rectangle;
        private Polygon polygon;
        private Circle circle1;
        private Circle circle2;
        private Timeline timeline;
        Car() {
            createCar();
            timeline = new Timeline(new KeyFrame(Duration.millis(50), event -> moveCar()));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }
        private void createCar() {
            getChildren().clear();
            rectangle = new Rectangle(x, y + 50, 50, 12);
            polygon = new Polygon(x + 10, y - 20, x + 20, y - 30, x + 30, y - 30, x + 40, y - 20);
            polygon.setLayoutY(70);
            circle1 = new Circle(x + 15, y + 65, radius);
            circle2 = new Circle(x + 35, y + 65, radius);
            rectangle.setFill(Color.GREEN);
            polygon.setFill(Color.RED);
            getChildren().addAll(rectangle, circle1, circle2, polygon);
        }
        public void pause(){
            timeline.pause();
        }
        public void play(){
            timeline.play();
        }
        public void increase(){
            timeline.setRate(timeline.getRate() + 1);
        }
        public void decrease(){
            timeline.setRate((timeline.getRate() > 0 ? timeline.getRate() - 1:0));
        }
        void moveCar() {
            if (x <= getWidth()) {
                x += 1;
            } else
                x = 0;
                createCar();
        }
    }
}
