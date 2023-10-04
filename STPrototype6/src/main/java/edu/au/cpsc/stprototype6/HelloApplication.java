package edu.au.cpsc.stprototype6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.orekit.propagation.analytical.tle.TLE;

import java.io.IOException;

public class HelloApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        ElsetPuller elsetPuller = new ElsetPuller("25544");
        String lines[] = elsetPuller.toString().split("\n");
        lines[1] = lines[1].substring(1);
        lines[2] = lines[2].substring(2);
        TLE tle = new TLE(lines[1], lines[2]);
        launch();
    }
}