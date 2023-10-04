package edu.au.cpsc.satpass.controller;

import edu.au.cpsc.satpass.data.Visibility;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.LocalTime;

public class PassSummaryAppController
{
    @FXML
    private Button generatePassListButton;
    @FXML
    private PassTableViewController passTableViewController;
    @FXML
    private SatelliteDetailTableViewController satelliteDetailTableViewController;
    @FXML
    private SatelliteEditorViewController satelliteEditorViewController;

    @FXML
    private Label errorLabel;

    public void initialize()
    {
        passTableViewController.showPasses();
    }

    @FXML
    protected void generatePassList()
    {
        errorLabel.setText("");
        errorLabel.getStyleClass().add("hidden");
        String satelliteNumber = satelliteEditorViewController.getSatelliteNumber();
        LocalDate fromDate = satelliteEditorViewController.getFromDate();
        LocalDate toDate = satelliteEditorViewController.getToDate();
        String latitude = satelliteEditorViewController.getLatitude();
        String longitude = satelliteEditorViewController.getLongitude();
        String altitude = satelliteEditorViewController.getAltitude();

        if (satelliteNumber == null || fromDate == null || toDate == null ||
            latitude == null || longitude == null || altitude == null)
        {
            errorLabel.setText("Please fill in empty fields. ");
            errorLabel.getStyleClass().remove("hidden");
        }
        else
        {
            if (validInputs(satelliteNumber, fromDate, toDate, latitude, longitude, altitude))
            {
                try
                {
                    Visibility visibility = new Visibility(satelliteNumber, Double.parseDouble(latitude),
                            Double.parseDouble(longitude), Double.parseDouble(altitude), fromDate, toDate);
                    passTableViewController.setPassList(visibility.getPassList());
                    passTableViewController.showPasses();
                    satelliteDetailTableViewController.setVisibility(visibility);
                }
                catch (Exception e)
                {
                    errorLabel.setText(e.getMessage());
                    errorLabel.getStyleClass().remove("hidden");
                }
            }
        }
    }
    private boolean validInputs(String satelliteNumber, LocalDate fromDate, LocalDate toDate,
                                String latitude, String longitude, String altitude)
    {
        boolean valid = true;
        try
        {
            int satNo = Integer.valueOf(satelliteNumber);
            if (satNo < 1 || satNo > 99999)
            {
                valid = false;
                if (!errorLabel.getText().isEmpty()) errorLabel.setText(errorLabel.getText() + "\n");
                errorLabel.setText(errorLabel.getText() + "Satellite Number must be between 1 and 99999. ");
                errorLabel.getStyleClass().remove("hidden");
            }
        }
        catch (NumberFormatException e)
        {
            valid = false;
            if (!errorLabel.getText().isEmpty()) errorLabel.setText(errorLabel.getText() + "\n");
            errorLabel.setText(errorLabel.getText() + "Satellite Number must be an Integer. ");
            errorLabel.getStyleClass().remove("hidden");
        }
        if (fromDate.isAfter(toDate))
        {
            valid = false;
            if (!errorLabel.getText().isEmpty()) errorLabel.setText(errorLabel.getText() + "\n");
            errorLabel.setText(errorLabel.getText() + "From date must be before to date. ");
            errorLabel.getStyleClass().remove("hidden");
        }
        try
        {
            Double lat = Double.valueOf(latitude);
            if (lat < -90.0 || lat > 90.0)
            {
                valid = false;
                if (!errorLabel.getText().isEmpty()) errorLabel.setText(errorLabel.getText() + "\n");
                errorLabel.setText(errorLabel.getText() + "Latitude should be between -90 and 90. ");
                errorLabel.getStyleClass().remove("hidden");
            }
        }
        catch (NumberFormatException e)
        {
            valid = false;
            if (!errorLabel.getText().isEmpty()) errorLabel.setText(errorLabel.getText() + "\n");
            errorLabel.setText(errorLabel.getText() + "Latitude must be a number. ");
            errorLabel.getStyleClass().remove("hidden");
        }
        try
        {
            Double lon = Double.valueOf(longitude);
            if (lon < -180.0 || lon > 180.0)
            {
                valid = false;
                if (!errorLabel.getText().isEmpty()) errorLabel.setText(errorLabel.getText() + "\n");
                errorLabel.setText(errorLabel.getText() + "Longitude should be between -180 and 180. ");
                errorLabel.getStyleClass().remove("hidden");
            }
        }
        catch (NumberFormatException e)
        {
            valid = false;
            if (!errorLabel.getText().isEmpty()) errorLabel.setText(errorLabel.getText() + "\n");
            errorLabel.setText(errorLabel.getText() + "Longitude must be a number. ");
            errorLabel.getStyleClass().remove("hidden");
        }
        try
        {
            Double alt = Double.valueOf(altitude);
            if (alt < 0 || alt > 10000)
            {
                valid = false;
                if (!errorLabel.getText().isEmpty()) errorLabel.setText(errorLabel.getText() + "\n");
                errorLabel.setText(errorLabel.getText() + "Altitude should be between 0 and 10000. ");
                errorLabel.getStyleClass().remove("hidden");
            }
        }
        catch (NumberFormatException e)
        {
            valid = false;
            if (!errorLabel.getText().isEmpty()) errorLabel.setText(errorLabel.getText() + "\n");
            errorLabel.setText(errorLabel.getText() + "Altitude must be a number. ");
            errorLabel.getStyleClass().remove("hidden");
        }
        return valid;
    }
}