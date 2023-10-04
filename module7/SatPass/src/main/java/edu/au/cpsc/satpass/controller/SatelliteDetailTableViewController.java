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
        ildColumn.setCellValueFactory
                (new PropertyValueFactory<Visibility,String>("launchNumber"));
        launchYearColumn.setCellValueFactory
                (new PropertyValueFactory<Visibility,String>("launchYear"));
        nameColumn.setCellValueFactory
                (new PropertyValueFactory<Visibility,String>("satelliteName"));
        inclinationColumn.setCellValueFactory
                (new PropertyValueFactory<Visibility,String>("inclination"));
        meanMotionColumn.setCellValueFactory
                (new PropertyValueFactory<Visibility,String>("meanMotion"));
        eccentricityColumn.setCellValueFactory
                (new PropertyValueFactory<Visibility,String>("eccentricity"));
        epochColumn.setCellValueFactory
                (new PropertyValueFactory<Visibility,String>("epoch"));
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
