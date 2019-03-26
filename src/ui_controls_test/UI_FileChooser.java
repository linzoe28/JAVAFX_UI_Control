/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui_controls_test;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class UI_FileChooser extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        FlowPane flowPane = new FlowPane();
        root.setTop(flowPane);
        TabPane tabPane = new TabPane();
        tabPane.setSide(Side.BOTTOM);
        root.setCenter(tabPane);
        Button button = new Button("open");
        flowPane.getChildren().add(button);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser(); //開啟檔案管理器
                fileChooser.setInitialDirectory(new File("C:\\Users\\User\\Documents\\NetBeansProjects\\JAVAFX_UI_Control\\img")); //設定檔案起始點
                fileChooser.setTitle("Open File");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("All Image", "*.jpg", "*.png", "*.jpeg"),
                        new FileChooser.ExtensionFilter("PNG", "*.png"),
                        new FileChooser.ExtensionFilter("JPG", "*.jpg", "*.jpeg")
                );
                File file = fileChooser.showOpenDialog(primaryStage);
                try {
                    if (file != null) {
                        Image image = new Image(file.toURI().toString());
                        ImageView imageView = new ImageView(image);
                        ScrollPane scrollPane = new ScrollPane(imageView);
                        tabPane.getTabs().add(new Tab(file.getName(), scrollPane));
                    }
                } catch (Exception ex) {
                    Logger.getLogger(UI_FileChooser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Scene scene = new Scene(root, 300, 250);

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
