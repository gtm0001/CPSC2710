package edu.au.cpsc.satpass.controller;

import edu.au.cpsc.satpass.data.Visibility;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.orekit.propagation.analytical.tle.TLE;

import java.util.ArrayList;

public class SatelliteDetailTableViewController
{
    Visibility visibility;
    @FXML
    TableView<Visibility> satelliteDetailTable;

    @FXML
    TableColumn<Visibility, String> satNoColumn, ildColumn, launchYearColumn, nameColumn,
            inclinationColumn, meanMotionColumn, eccentricityColumn, epochColumn;


    public void initialize()
    {
        visibility = new Visibility();
        satNoColumn.setCellValueFactory
                (new PropertyValueFactory<Visibility,String>("satelliteNumber"));
        satNoColumn.prefWidthProperty().bind(satelliteDetailTable.widthProperty().multiply(.08));
        ildColumn.setCellValueFactory
                (new PropertyValueFactory<Visibility,String>("launchNumber"));
        ildColumn.prefWidthProperty().bind(satelliteDetailTable.widthProperty().multiply(.08));
        launchYearColumn.setCellValueFactory
                (new PropertyValueFactory<Visibility,String>("launchYear"));
        launchYearColumn.prefWidthProperty().bind(satelliteDetailTable.widthProperty().multiply(.08));
        nameColumn.setCellValueFactory
                (new PropertyValueFactory<Visibility,String>("satelliteName"));
        nameColumn.prefWidthProperty().bind(satelliteDetailTable.widthProperty().multiply(.2));
        inclinationColumn.setCellValueFactory
                (new PropertyValueFactory<Visibility,String>("inclination"));
        inclinationColumn.prefWidthProperty().bind(satelliteDetailTable.widthProperty().multiply(.12));
        meanMotionColumn.setCellValueFactory
                (new PropertyValueFactory<Visibility,String>("meanMotion"));
        meanMotionColumn.prefWidthProperty().bind(satelliteDetailTable.widthProperty().multiply(.12));
        eccentricityColumn.setCellValueFactory
                (new PropertyValueFactory<Visibility,String>("eccentricity"));
        eccentricityColumn.prefWidthProperty().bind(satelliteDetailTable.widthProperty().multiply(.12));
        epochColumn.setCellValueFactory
                (new PropertyValueFactory<Visibility,String>("epoch"));
        epochColumn.prefWidthProperty().bind(satelliteDetailTable.widthProperty().multiply(.2));
    }
    public void setVisibility(Visibility visibility)
    {
        this.visibility = visibility;
        ArrayList<Visibility> visList = new ArrayList<>();
        visList.add(visibility);
        satelliteDetailTable.setItems(FXCollections.observableList(visList));
        satelliteDetailTable.refresh();
    }

}
