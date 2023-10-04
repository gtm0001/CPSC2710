package edu.au.cpsc.satpass.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class SatelliteEditorViewController
{
    @FXML
    protected TextField satelliteNumberTextField;
    @FXML
    protected DatePicker fromDatePicker, toDatePicker;
    @FXML
    protected TextField latitudeTextField, longitudeTextField, altitudeTextField;

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
