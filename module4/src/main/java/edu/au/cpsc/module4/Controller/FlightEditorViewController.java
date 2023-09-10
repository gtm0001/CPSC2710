package edu.au.cpsc.module4.Controller;

import edu.au.cpsc.module4.Model.ScheduledFlight;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

import java.time.DayOfWeek;
import java.util.HashSet;

public class FlightEditorViewController
{
    @FXML
    private GridPane flightEditorView;
    @FXML
    private TextField flightDesignatorTextField, departureAirportTextField, arrivalAirportTextField;
    @FXML
    private ToggleButton sundayButton, mondayButton, tuesdayButton, wednesdayButton,
            thursdayButton, fridayButton, saturdayButton;

    public void showFlight(ScheduledFlight flight)
    {
        if (flight == null)
        {
            flightDesignatorTextField.clear();
            departureAirportTextField.clear();
            arrivalAirportTextField.clear();
            sundayButton.setSelected(false);
            mondayButton.setSelected(false);
            tuesdayButton.setSelected(false);
            wednesdayButton.setSelected(false);
            thursdayButton.setSelected(false);
            fridayButton.setSelected(false);
            saturdayButton.setSelected(false);
            return;
        }
        flightDesignatorTextField.setText(flight.getFlightDesignator());
        departureAirportTextField.setText(flight.getDepartureAirportIdent());
        arrivalAirportTextField.setText(flight.getArrivalAirportIdent());
        HashSet<DayOfWeek> daysOfWeek = flight.getDaysOfWeek();
        if(daysOfWeek.contains(DayOfWeek.SUNDAY))
        {
            sundayButton.setSelected(true);
        }
        if(daysOfWeek.contains(DayOfWeek.MONDAY))
        {
            mondayButton.setSelected(true);
        }
        if(daysOfWeek.contains(DayOfWeek.TUESDAY))
        {
            tuesdayButton.setSelected(true);
        }
        if(daysOfWeek.contains(DayOfWeek.WEDNESDAY))
        {
            wednesdayButton.setSelected(true);
        }
        if(daysOfWeek.contains(DayOfWeek.THURSDAY))
        {
            thursdayButton.setSelected(true);
        }
        if(daysOfWeek.contains(DayOfWeek.FRIDAY))
        {
            fridayButton.setSelected(true);
        }
        if(daysOfWeek.contains(DayOfWeek.SATURDAY))
        {
            saturdayButton.setSelected(true);
        }
    }
    public void updateFlight(ScheduledFlight flight)
    {
        flight.setFlightDesignator(flightDesignatorTextField.getText());
        flight.setDepartureAirportIdent(departureAirportTextField.getText());
        flight.setArrivalAirportIdent(arrivalAirportTextField.getText());
        HashSet<DayOfWeek> daysOfWeek = new HashSet<>();
        if(sundayButton.isSelected())
        {
            daysOfWeek.add(DayOfWeek.SUNDAY);
        }
        if(mondayButton.isSelected())
        {
            daysOfWeek.add(DayOfWeek.MONDAY);
        }
        if(tuesdayButton.isSelected())
        {
            daysOfWeek.add(DayOfWeek.TUESDAY);
        }
        if(wednesdayButton.isSelected())
        {
            daysOfWeek.add(DayOfWeek.WEDNESDAY);
        }
        if(thursdayButton.isSelected())
        {
            daysOfWeek.add(DayOfWeek.THURSDAY);
        }
        if(fridayButton.isSelected())
        {
            daysOfWeek.add(DayOfWeek.FRIDAY);
        }
        if(saturdayButton.isSelected())
        {
            daysOfWeek.add(DayOfWeek.SATURDAY);
        }
        flight.setDaysOfWeek(daysOfWeek);
    }
    @FXML
    protected void sundayOnAction()
    {

    }
    @FXML
    protected void mondayOnAction()
    {

    }
    @FXML
    protected void tuesdayOnAction()
    {

    }
    @FXML
    protected void wednesdayOnAction()
    {

    }
    @FXML
    protected void thursdayOnAction()
    {

    }
    @FXML
    protected void fridayOnAction()
    {

    }
    @FXML
    protected void saturdayOnAction()
    {

    }
}
