package fi.iki.pj.aapinen;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloFX extends Application {
	 
	 private StringProperty value = new SimpleStringProperty("Elisa");


    @Override
    public void start(Stage stage) {
        //String javaVersion = System.getProperty("java.version");
        //String javafxVersion = System.getProperty("javafx.version");
    	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    	int width = gd.getDisplayMode().getWidth();
    	int height = gd.getDisplayMode().getHeight();
        Label l = new Label();
        l.setFont(Font.font(936));
        l.textProperty().bind(value);
        Scene scene = new Scene(new StackPane(l), width, height);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
        	value.set(key.getText());
        	//System.out.println(key.getText());
        	stage.setTitle("Aapinen");
        });
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
