/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui_controls_test;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class UI_ListView extends Application {

    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox();
        ListView listview = new ListView();
        Text text = new Text("HELLO");
        Font font = Font.font("Arial", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 35);
        text.setFont(font);
        ObservableList<String> items = FXCollections.observableArrayList("Jokerman", "Chiller", "Colonna M");

        items.add("741"); //ontime可動態繼續加資料進去
        listview.setItems(items);
        Button bt = new Button("add");
        bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                items.add("test");
            }
        });
        listview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                text.setFont(Font.font(newValue, FontWeight.SEMI_BOLD, FontPosture.REGULAR, 35));
            }
        });
        root.getChildren().addAll(listview, bt, text);
        Scene scene = new Scene(root, 800, 600);

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
