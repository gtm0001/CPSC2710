package edu.au.cpsc.part2.Controller;

import edu.au.cpsc.part2.Model.ScheduledFlight;
import edu.au.cpsc.part2.uimodel.FlightDetailModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    @FXML
    private Label validationErrorLabel, daysOfWeekLabel;
    private FlightDetailModel model;

    public void initialize()
    {
        model = new FlightDetailModel();
        flightDesignatorTextField.textProperty().bindBidirectional(model.flightDesignatorProperty());
        arrivalAirportTextField.textProperty().bindBidirectional(model.arrivalAirportProperty());
        departureAirportTextField.textProperty().bindBidirectional(model.departureAirportProperty());
        sundayButton.selectedProperty().bindBidirectional(model.sundayProperty());
        mondayButton.selectedProperty().bindBidirectional(model.mondayProperty());
        tuesdayButton.selectedProperty().bindBidirectional(model.tuesdayProperty());
        wednesdayButton.selectedProperty().bindBidirectional(model.wednesdayProperty());
        thursdayButton.selectedProperty().bindBidirectional(model.thursdayProperty());
        fridayButton.selectedProperty().bindBidirectional(model.fridayProperty());
        saturdayButton.selectedProperty().bindBidirectional(model.saturdayProperty());
    }

    public FlightDetailModel getModel() { return model; }

    public void showFlight(ScheduledFlight flight)
    {
        if (flight == null)
        {
            model.setFlightDesignator("");
            model.setArrivalAirport("");
            model.setDepartureAirport("");
            clearDayButtons();
            model.setModified(false);
            model.setNew(true);
            return;
        }
        model.setFlightDesignator(flight.getFlightDesignator());
        model.setArrivalAirport(flight.getArrivalAirportIdent());
        model.setDepartureAirport(flight.getDepartureAirportIdent());
        HashSet<DayOfWeek> daysOfWeek = flight.getDaysOfWeek();
        model.setSundayProperty(daysOfWeek.contains(DayOfWeek.SUNDAY));
        model.setMondayProperty(daysOfWeek.contains(DayOfWeek.MONDAY));
        model.setTuesdayProperty(daysOfWeek.contains(DayOfWeek.TUESDAY));
        model.setWednesdayProperty(daysOfWeek.contains(DayOfWeek.WEDNESDAY));
        model.setThursdayProperty(daysOfWeek.contains(DayOfWeek.THURSDAY));
        model.setFridayProperty(daysOfWeek.contains(DayOfWeek.FRIDAY));
        model.setSaturdayProperty(daysOfWeek.contains(DayOfWeek.SATURDAY));
        model.setModified(false);
        model.setNew(false);
    }
    public boolean updateFlight(ScheduledFlight flight)
    {
        if (!validate()) return false;
        flight.setFlightDesignator(model.getFlightDesignator());
        flight.setDepartureAirportIdent(model.getDepartureAirport());
        flight.setArrivalAirportIdent(model.getArrivalAirport());
        HashSet<DayOfWeek> daysOfWeek = new HashSet<>();
        if(model.sundayProperty().get())
        {
            daysOfWeek.add(DayOfWeek.SUNDAY);
        }
        if(model.mondayProperty().get())
        {
            daysOfWeek.add(DayOfWeek.MONDAY);
        }
        if(model.tuesdayProperty().get())
        {
            daysOfWeek.add(DayOfWeek.TUESDAY);
        }
        if(model.wednesdayProperty().get())
        {
            daysOfWeek.add(DayOfWeek.WEDNESDAY);
        }
        if(model.thursdayProperty().get())
        {
            daysOfWeek.add(DayOfWeek.THURSDAY);
        }
        if(model.fridayProperty().get())
        {
            daysOfWeek.add(DayOfWeek.FRIDAY);
        }
        if(model.saturdayProperty().get())
        {
            daysOfWeek.add(DayOfWeek.SATURDAY);
        }
        flight.setDaysOfWeek(daysOfWeek);
        return true;
    }
    private boolean validate()
    {
        boolean isValid = true;
        isValid = validFieldNotEmpty(flightDesignatorTextField);
        isValid = validFieldNotEmpty(arrivalAirportTextField) && isValid;
        isValid = validFieldNotEmpty(departureAirportTextField) && isValid;
        isValid = validButtonsNotSet() && isValid;
        if (isValid)
        {
            validationErrorLabel.getStyleClass().add("hidden");
        }
        else
        {
            validationErrorLabel.getStyleClass().remove("hidden");
        }
        return isValid;
    }
    private boolean validFieldNotEmpty(TextField field)
    {
        if (field.getText().trim().length() == 0)
        {
            field.getStyleClass().add("error");
            return false;
        }
        else
        {
            field.getStyleClass().remove("error");
        }
        return true;
    }
    //Returns true if at least one toggle button is set
    private boolean validButtonsNotSet()
    {
        boolean isValid =
                model.getSundayProperty() || model.getMondayProperty() ||
                model.getTuesdayProperty() || model.getWednesdayProperty() ||
                model.getThursdayProperty() || model.getFridayProperty() ||
                model.getSaturdayProperty();
        if (isValid)
        {
            daysOfWeekLabel.getStyleClass().remove("error");
        }
        else
        {
            daysOfWeekLabel.getStyleClass().add("error");
        }
        return isValid;
    }
    public void clearDayButtons()
    {
        model.setSundayProperty(false);
        model.setMondayProperty(false);
        model.setTuesdayProperty(false);
        model.setWednesdayProperty(false);
        model.setThursdayProperty(false);
        model.setFridayProperty(false);
        model.setSaturdayProperty(false);
    }
    @FXML
    protected void flightDesignatorFieldTyped()
    {
        validFieldNotEmpty(flightDesignatorTextField);
    }
    @FXML
    protected void departureFieldTyped()
    {
        validFieldNotEmpty(departureAirportTextField);
    }
    @FXML
    protected void  arrivalFieldTyped()
    {
        validFieldNotEmpty(arrivalAirportTextField);
    }
    @FXML
    protected void dayOfWeekButtonSelected()
    {
        validButtonsNotSet();
    }
}
