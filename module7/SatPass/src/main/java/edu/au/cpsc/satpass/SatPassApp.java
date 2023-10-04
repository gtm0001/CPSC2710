package edu.au.cpsc.satpass;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.orekit.data.DataContext;
import org.orekit.data.DataProvidersManager;
import org.orekit.data.DirectoryCrawler;



import java.io.File;
import java.io.IOException;

public class SatPassApp extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(SatPassApp.class.getResource("pass-summary-app.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("SatPass - Satellite Visibility Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        File orekitData = new File("src/main/resources/orekit-data");
        DataProvidersManager manager = DataContext.getDefault().getDataProvidersManager();
        manager.addProvider(new DirectoryCrawler(orekitData));
        launch();
    }
}