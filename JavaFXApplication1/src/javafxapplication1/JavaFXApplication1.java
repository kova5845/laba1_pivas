/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author alexey
 */
public class JavaFXApplication1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button button1 = new Button("first text");
        Button button2 = new Button("second text");
        TextField text = new TextField();
        button1.setFocusTraversable(false);
        
        button1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
               button2.setText(text.getText());
               text.clear();
               
            }
        });
        
        button2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String s = button1.getText();
                button1.setText(button2.getText());
                button2.setText(s);
            }
        });
        
        button1.setMinWidth(100);
        button1.setMinHeight(50);
        button2.setMinWidth(100);
        button2.setMinHeight(50);
        button1.setLayoutX(50);
        button1.setLayoutY(50);
        button2.setLayoutX(150);
        button2.setLayoutY(50);
        
        
        text.setMinSize(200, 50);
        text.setLayoutX(50);
        text.setLayoutY(100);
        
        Pane root = new Pane();
        
        root.getChildren().add(button1);
        root.getChildren().add(button2);
        root.getChildren().add(text);
        
        Scene scene = new Scene(root, 300, 200);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
