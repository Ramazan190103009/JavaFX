package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    private double x = 0;
    private Circle circle;
    private Pane pane;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Circle cir = new Circle(50,100,50);
        cir.setFill(Color.RED);
        cir.setStroke(Color.BLACK);
        TranslateTransition translate = new TranslateTransition();
        translate.setDuration(Duration.millis(5000));
        translate.setCycleCount(Timeline.INDEFINITE);
        translate.setByX(400);
        translate.setNode(cir);
        translate.play();
        Button play = new Button("Play");
        Button pause = new Button("Pause");
        pause.setLayoutX(100);
        pause.setLayoutY(150);
        play.setLayoutX(300);
        play.setLayoutY(150);
        EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent event) {
               if (event.getSource()==pause){
                   translate.pause();
               }
               if (event.getSource()==play){
                   translate.play();
               }
           }
       };
        pause.setOnMouseClicked(handler);
        play.setOnMouseClicked(handler);
        Group root = new Group();
        root.getChildren().addAll(cir, play, pause);
        Scene scene = new Scene(root,500,200,Color.WHEAT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Translate Transition example");
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }

}