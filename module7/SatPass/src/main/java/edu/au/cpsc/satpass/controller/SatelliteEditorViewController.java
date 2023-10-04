package edu.au.cpsc.satpass.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SatelliteEditorViewController
{
    @FXML
    protected TextField satelliteNumberTextField;
    @FXML
    protected DatePicker fromDatePicker, toDatePicker;
    @FXML
    protected TextField latitudeTextField, longitudeTextField, altitudeTextField;
    @FXML
    protected ComboBox<String> locationComboBox, satelliteComboBox;

    public void initialize()
    {
        //Setup for built-in locations
        List<String> locations = new ArrayList<>();
        locations.add("Auburn Haley Center");
        locations.add("Huntsville Space and Rocket Center");
        locationComboBox.getItems().addAll(locations);
        locationComboBox.setOnAction(event -> {
            locationComboBoxSelectionChanged();});

        //Setup for built-in satellites
        List<String> satellites = new ArrayList<>();
        satellites.add("International Space Station");
        satellites.add("Chinese Space Station");
        satellites.add("Hubble Telescope");
        satelliteComboBox.getItems().addAll(satellites);
        satelliteComboBox.setOnAction(event -> {
            satelliteComboBoxSelectionChanged();});
    }
    public void locationComboBoxSelectionChanged()
    {
        String selectedLocation = locationComboBox.getValue();
        switch (selectedLocation)
        {
            case "Auburn Haley Center":
                latitudeTextField.setText("32.603580782721906");
                longitudeTextField.setText("-85.48681425767028");
                altitudeTextField.setText("312");
                break;
            case "Huntsville Space and Rocket Center":
                latitudeTextField.setText("34.711308561966774");
                longitudeTextField.setText("-86.65396849059177");
                altitudeTextField.setText("177");
                break;
        }
    }
    public void satelliteComboBoxSelectionChanged()
    {
        String selectedSatellite = satelliteComboBox.getValue();
        switch (selectedSatellite)
        {
            case "International Space Station":
                satelliteNumberTextField.setText("25544");
                break;
            case "Chinese Space Station":
                satelliteNumberTextField.setText("48274");
                break;
            case "Hubble Telescope":
                satelliteNumberTextField.setText("20580");
                break;
        }
    }
    public String getSatelliteNumber()
    {
        String s = satelliteNumberTextField.getText();
        if (s.isEmpty()) return null;
        return satelliteNumberTextField.getText().trim();
    }
    public LocalDate getFromDate()
    {
        return fromDatePicker.getValue();
    }
    public LocalDate getToDate()
    {
        return toDatePicker.getValue();
    }
    public String getLatitude()
    {
        if (latitudeTextField.getText().isEmpty()) return null;
        return latitudeTextField.getText().trim();
    }
    public String getLongitude()
    {
        if (longitudeTextField.getText().isEmpty()) return null;
        return longitudeTextField.getText().trim();
    }
    public String getAltitude()
    {
        if (altitudeTextField.getText().isEmpty()) return null;
        return altitudeTextField.getText().trim();
    }

}
