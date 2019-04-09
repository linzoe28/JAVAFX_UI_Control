/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui_controls_test;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class UI_Progress extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        ProgressBar pb = new ProgressBar();
        pb.setProgress(0.5);
        pb.setPrefWidth(500);
        ProgressBar pb1 = new ProgressBar();
        pb1.setProgress(-1);
        pb1.setPrefWidth(500);
        ProgressIndicator pi = new ProgressIndicator(0.5);
        ProgressIndicator pi1 = new ProgressIndicator(-1);
        
        Slider slider=new Slider(0,100,50);
        slider.setPrefWidth(500);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double radio=newValue.doubleValue()/slider.getMax();
                pb.setProgress(radio);
                pi.setProgress(radio);
            }
        });
        
        root.getChildren().addAll(slider,pb, pb1, pi, pi1);
        Scene scene = new Scene(root, 500, 500);

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
