/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui_controls_test;

import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class UI_CheckBox extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox(10);
        VBox leftBox = new VBox(5);
        HBox rightBox = new HBox(5);
        CheckBox[] checkBoxs = new CheckBox[]{
            new CheckBox("First"), new CheckBox("Second"), new CheckBox("Third")
        };
        
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
        
        for (int i = 0; i < checkBoxs.length; i++) {
            CheckBox checkBox = checkBoxs[i];
            final int index = i;
            checkBox.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    imageView[index].setVisible(checkBox.isSelected());
                }
            });
        }
        leftBox.getChildren().addAll(checkBoxs[0], checkBoxs[1], checkBoxs[2]);
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
