package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
       private Button add;
       private Button subtract;
       private Button divide;
       private Button multiply;
       private TextField textField1;
       private TextField textField2;
       private TextField textField3;
    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane gridPane = new GridPane();
        Label label1 = new Label("Number 1: ");
        textField1 = new TextField();
        textField1.setMaxWidth(150);
        Label label2 = new Label("Number 2: ");
        textField2 = new TextField();
        textField2.setMaxWidth(150);
        Label label3 = new Label("Result: ");
        textField3 = new TextField();
        textField3.setMaxWidth(150);
        gridPane.add(label1,  0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(label2, 3, 0);
        gridPane.add(textField2, 4, 0);
        gridPane.add(label3, 5, 0);
        gridPane.add(textField3, 6, 0);
         add = new Button("Add");
         subtract = new Button("Subtract");
         multiply = new Button("Multiply");
         divide = new Button("Divide");
         add.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 textField3.setText(String.valueOf(Double.parseDouble(textField1.getText()) + Double.parseDouble(textField2.getText())));
             }
         });
         subtract.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 textField3.setText(String.valueOf(Double.parseDouble(textField1.getText()) - Double.parseDouble(textField2.getText())));
             }
         });
         multiply.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 textField3.setText(String.valueOf(Double.parseDouble(textField1.getText()) * Double.parseDouble(textField2.getText())));
             }
         });
         divide.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 textField3.setText(String.valueOf(Double.parseDouble(textField1.getText()) / Double.parseDouble(textField2.getText())));
             }
         });
        gridPane.add(add, 0, 2);
        gridPane.add(subtract, 1, 2);
        gridPane.add(multiply, 3, 2);
        gridPane.add(divide, 4, 2);
        Scene scene = new Scene(gridPane, 660, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ex-15-04");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
