/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.WindowEvent;

/**
 *
 * @author alexey
 */
public class JavaFXApplication1 extends Application {
    
    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    
    @Override
    public void start(Stage primaryStage) {
        
        TextField textField1 = new TextField();
        ComboBox<String> comboBox1 = new ComboBox<String>();
        Button buttonCombo = new Button("Add");
        buttonCombo.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                int i;
                String s = textField1.getText();
                if (comboBox1.getItems().isEmpty()){
                    if(!s.equals("")){
                        comboBox1.getItems().addAll(s);
                    }
                    textField1.clear();
                }
                else {
                    for(i = 0; i < comboBox1.getItems().size(); i++){
                        if(comboBox1.getItems().get(i).equals(s)){
                            Alert alert1 = new Alert(AlertType.WARNING);
                            alert1.setHeaderText("Такая запись уже существует");
                            alert1.showAndWait();
                            break;
                        }
                    }
                    if(i == comboBox1.getItems().size()){
                        if(!s.equals("")){
                            comboBox1.getItems().addAll(s);
                        }
                        textField1.clear();
                    }
                }
                
            }
            
        });
        TextField textField2 = new TextField();
        Button buttonSwap = new Button();
        Button buttonRename = new Button();
        buttonRename.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               String s = textField2.getText();
               if(!s.equals("")){
                buttonSwap.setText(s);
               }
               textField2.clear();
            }
        });
        buttonSwap.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                String s = buttonRename.getText();
                buttonRename.setText(buttonSwap.getText());
                buttonSwap.setText(s);
            }
        });
        TextField textField3 = new TextField();
        RadioButton radioButton1 = new RadioButton(ONE);
        RadioButton radioButton2 = new RadioButton(TWO); 
        RadioButton radioButton3 = new RadioButton(THREE);
        ToggleGroup group = new ToggleGroup();
        radioButton1.setToggleGroup(group);
        radioButton2.setToggleGroup(group);
        radioButton3.setToggleGroup(group);
        Button buttonRadio = new Button("Choice");
        buttonRadio.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                String s = textField3.getText();
                
                if(radioButton1.getText().equals(s)){
                    radioButton1.setSelected(true);
                    textField3.clear();
                }
                else if(radioButton2.getText().equals(s)){
                    radioButton2.setSelected(true);
                    textField3.clear();
                }
                else if(radioButton3.getText().equals(s)){
                    radioButton3.setSelected(true);
                    textField3.clear();
                }
                else{
                    
                    Alert alert1 = new Alert(AlertType.WARNING);
                            alert1.setHeaderText("Такой записи нет");
                            alert1.showAndWait();
                            textField3.clear();
                }
            }
        });
        TextField textField4 = new TextField();
        CheckBox checkBox1 = new CheckBox(ONE);
        CheckBox checkBox2 = new CheckBox(TWO);
        CheckBox checkBox3 = new CheckBox(THREE);
        Button buttonCheck = new Button("Choice");
        buttonCheck.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                String s = textField4.getText();
                
                if(checkBox1.getText().equals(s)){
                    if(checkBox1.isSelected()){
                        checkBox1.setSelected(false);
                    }
                    else {
                        checkBox1.setSelected(true);
                    }
                    textField4.clear();
                }
                else if(checkBox2.getText().equals(s)){
                    if(checkBox2.isSelected()){
                        checkBox2.setSelected(false);
                    }
                    else {
                        checkBox2.setSelected(true);
                    }
                    textField4.clear();
                }
                else if(checkBox3.getText().equals(s)){
                    if(checkBox3.isSelected()){
                        checkBox3.setSelected(false);
                    }
                    else {
                        checkBox3.setSelected(true);
                    }
                    textField4.clear();
                }
                else{Alert alert1 = new Alert(AlertType.WARNING);
                     alert1.setHeaderText("Такой записи нет");
                     alert1.showAndWait();
                     textField4.clear();
                }
            }
        });
        TextField textField5 = new TextField();
        TableView<Person> tableView1 = new TableView<>();
        ObservableList<Person> data = FXCollections.observableArrayList();
        tableView1.setMaxSize(305, 150);
        TableColumn tableColumn1 = new TableColumn("First"); 
        tableColumn1.setMinWidth(150);
        tableColumn1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        
        TableColumn tableColumn2 = new TableColumn("Second");
        tableColumn2.setMinWidth(150);
        tableColumn2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        
        tableView1.setItems(data);
        tableView1.getColumns().addAll(tableColumn1, tableColumn2);
        
        Button buttonAdd = new Button("Add");
        buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                String s = textField5.getText();
                if(!s.equals("")){
                    data.add(new Person(s));
                }
                
                textField5.clear();
                
            }
        });
        
        
        Button buttonToSecond = new Button("To second");
        buttonToSecond.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                Person person = tableView1.getSelectionModel().getSelectedItem();
                String s = person.getFirstName();
                if(!s.equals("")){
                person.setLastName(s);
                person.setFirstName("");
                }
                tableView1.refresh();
            }
        });
        
        Button buttonToFirst = new Button("To first");
        buttonToFirst.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                Person person = tableView1.getSelectionModel().getSelectedItem();
                String s = person.getLastName();
                if(!s.equals("")){
                person.setFirstName(s);
                person.setLastName("");
                }
                tableView1.refresh();
            }
        });
        
        VBox vBox1 = new VBox(20);
        VBox vBox2 = new VBox(10);
        vBox2.getChildren().addAll(textField5, buttonAdd, buttonToSecond, buttonToFirst);
        FlowPane flowPane1 = new FlowPane(20, 5);
        FlowPane flowPane2 = new FlowPane(20, 5);
        FlowPane flowPane3 = new FlowPane(20, 5);
        FlowPane flowPane4 = new FlowPane(20, 5);
        FlowPane flowPane5 = new FlowPane(20, 5);
        
        flowPane1.getChildren().addAll(textField1, buttonCombo, comboBox1);
        flowPane2.getChildren().addAll(textField2, buttonRename, buttonSwap);
        flowPane3.getChildren().addAll(textField3, radioButton1, radioButton2, 
                                       radioButton3, buttonRadio);
        flowPane4.getChildren().addAll(textField4, checkBox1, checkBox2, 
                                       checkBox3, buttonCheck);
        flowPane5.getChildren().addAll(tableView1, vBox2);
        
        flowPane1.setAlignment(Pos.CENTER);
        flowPane2.setAlignment(Pos.CENTER);
        flowPane3.setAlignment(Pos.CENTER);
        flowPane4.setAlignment(Pos.CENTER);
        flowPane5.setAlignment(Pos.CENTER);
        
        vBox1.getChildren().addAll(flowPane1, flowPane2, flowPane3,
                                   flowPane4, flowPane5);
        
        vBox1.setFillWidth(true);
        Scene scene = new Scene(vBox1, 500, 350);
        
        primaryStage.setTitle("Laba_1");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        ChangePane thread = new ChangePane(vBox1);
        Thread th = new Thread(thread);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent key){
                if(key.getCode().equals(KeyCode.R)){
                    System.out.println("run");
                    
                        if(th.getState() == Thread.State.WAITING)
                            thread.setFlag(false);
                        else if(!th.isAlive()){
                                th.start();
                             }
                }
                if(key.getCode().equals(KeyCode.S)){
                    System.out.println("stop");
                    thread.setFlag(true);
                }
            }
        });
        
    primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent t) {
            Platform.exit();
            System.exit(0);
        }
    });
    
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    

class ChangePane implements Runnable {
    
    Object object = new Object();
    boolean flag = false;
    VBox vBox1 = new VBox();
    FlowPane[] fl;
    StackPane[] st;
    BorderPane[] br;
    GridPane[] gr;
    TilePane[] tl;
    ObservableList<Node> obs;
    int i = 0;

    ChangePane(VBox vBox1) {
        
        this.vBox1 = vBox1;
        fl = new FlowPane[5];
        st = new StackPane[5];
        br = new BorderPane[5];
        gr = new GridPane[5];
        tl = new TilePane[5];
        for(int i=0;i<5;i++){
            fl[i] = new FlowPane();
            st[i] = new StackPane();
            br[i] = new BorderPane();
            gr[i] = new GridPane();
            tl[i] = new TilePane();
        }
    }
    
    @Override
    public void run(){
        
        Runnable updater = new Runnable() {
            @Override
            public void run() {
                System.out.println(i);
                i %= vBox1.getChildren().size();
                switch(i){
                    case 0:
                        for(int j = 0; j<vBox1.getChildren().size(); j++){
                            fl[j] = (FlowPane) vBox1.getChildren().get(j);
                            st[j].getChildren().addAll(fl[j].getChildren());
                            vBox1.getChildren().remove(j);
                            vBox1.getChildren().add(j, st[j]);
                        }
                        break;
                    case 1:
                        for(int j = 0; j<vBox1.getChildren().size(); j++){
                            st[j] = (StackPane) vBox1.getChildren().get(j);
                            br[j].getChildren().addAll(st[j].getChildren());
                            vBox1.getChildren().remove(j);
                            vBox1.getChildren().add(j, br[j]);
                        }
                        break;
                    case 2:
                        for(int j = 0; j<vBox1.getChildren().size(); j++){
                            br[j] = (BorderPane) vBox1.getChildren().get(j);
                            gr[j].getChildren().addAll(br[j].getChildren());
                            vBox1.getChildren().remove(j);
                            vBox1.getChildren().add(j, gr[j]);
                        }
                        break;
                    case 3:
                        for(int j = 0; j<vBox1.getChildren().size(); j++){
                            gr[j] = (GridPane) vBox1.getChildren().get(j);
                            tl[j].getChildren().addAll(gr[j].getChildren());
                            vBox1.getChildren().remove(j);
                            vBox1.getChildren().add(j, tl[j]);
                        }
                        break;
                    case 4:
                        for(int j = 0; j<vBox1.getChildren().size(); j++){
                            tl[j] = (TilePane) vBox1.getChildren().get(j);
                            fl[j].getChildren().addAll(tl[j].getChildren());
                            vBox1.getChildren().remove(j);
                            vBox1.getChildren().add(j, fl[j]);
                        }
                        break;
                    default:
                        break;
                }
                i++;
            }
        };
        try{
            while(true){
                
                Thread.sleep(2000);
                synchronized(object){
                    while(flag){
                        object.wait();
                    }
                }
                Platform.runLater(updater);
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void setFlag(boolean flag){
        this.flag = flag;
        if(!this.flag){
            synchronized(object){
                object.notifyAll();
            }
        }
    }
}

public static class Person {
 
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;

        private Person(String fName) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty("");
        }
 
        public String getFirstName() {
            return firstName.get();
        }
 
        public void setFirstName(String fName) {
            firstName.set(fName);
        }
        
        public String getLastName() {
            return lastName.get();
        }
 
        public void setLastName(String fName) {
            lastName.set(fName);
        }
    }   
    
}