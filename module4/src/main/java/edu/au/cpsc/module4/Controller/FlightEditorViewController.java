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
            clearDayButtons();
            return;
        }
        flightDesignatorTextField.setText(flight.getFlightDesignator());
        departureAirportTextField.setText(flight.getDepartureAirportIdent());
        arrivalAirportTextField.setText(flight.getArrivalAirportIdent());
        HashSet<DayOfWeek> daysOfWeek = flight.getDaysOfWeek();
        sundayButton.setSelected(daysOfWeek.contains(DayOfWeek.SUNDAY));
        mondayButton.setSelected(daysOfWeek.contains(DayOfWeek.MONDAY));
        tuesdayButton.setSelected(daysOfWeek.contains(DayOfWeek.TUESDAY));
        wednesdayButton.setSelected(daysOfWeek.contains(DayOfWeek.WEDNESDAY));
        thursdayButton.setSelected(daysOfWeek.contains(DayOfWeek.THURSDAY));
        fridayButton.setSelected(daysOfWeek.contains(DayOfWeek.FRIDAY));
        saturdayButton.setSelected(daysOfWeek.contains(DayOfWeek.SATURDAY));
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
    public void clearDayButtons()
    {
        sundayButton.setSelected(false);
        mondayButton.setSelected(false);
        tuesdayButton.setSelected(false);
        wednesdayButton.setSelected(false);
        thursdayButton.setSelected(false);
        fridayButton.setSelected(false);
        saturdayButton.setSelected(false);
    }
}
