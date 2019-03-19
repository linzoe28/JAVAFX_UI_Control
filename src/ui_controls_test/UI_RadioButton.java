/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui_controls_test;

import java.io.File;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class UI_RadioButton extends Application {

    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox(10);
        VBox leftBox = new VBox(5);
        HBox rightBox = new HBox(5);
        RadioButton[] radioButtons = new RadioButton[]{
            new RadioButton("First"), new RadioButton("Second"), new RadioButton("Third")
        };
        ToggleGroup toggleGroup = new ToggleGroup();
        for (RadioButton radioButton : radioButtons) {
            radioButton.setToggleGroup(toggleGroup);
        }
        Image[] images = new Image[]{
            new Image(new File("img/Super_Mushroom_SM3DL2.png").toURI().toString()), //file:/C:/Users/User/Documents/NetBeansProjects/UI_Controls_Test/img/bape-drawing-simpsons-6.png
            new Image(new File("img/SmallMario.png").toURI().toString()),
            new Image(new File("img/211-2119050_mini-mushroom-by-yoshigo99-super-mario-blue-mushroom.png").toURI().toString())
        };
        ImageView[] imageView = new ImageView[]{
            new ImageView(images[0]), new ImageView(images[1]), new ImageView(images[2])
        };
        for (ImageView imageView1 : imageView) {
            imageView1.setPreserveRatio(true);
            imageView1.setFitHeight(200);
            imageView1.setVisible(false);
        }

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                for (int i = 0; i < radioButtons.length; i++) {
                    RadioButton radioButton = radioButtons[i];
                    imageView[i].setVisible(radioButton.isSelected());
                }
            }
        });

        leftBox.getChildren().addAll(radioButtons[0], radioButtons[1], radioButtons[2]);
        rightBox.getChildren().addAll(imageView[0], imageView[1], imageView[2]);

        root.getChildren().addAll(leftBox, rightBox);
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
