package edu.au.cpsc.module4.Controller;

import edu.au.cpsc.module4.Data.DB;
import edu.au.cpsc.module4.Model.ScheduledFlight;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FlightScheduleController
{
    @FXML
    private FlightTableController flightTableController;
    @FXML
    private FlightEditorController flightEditorController;
    @FXML
    private Button updateButton;

    private ScheduledFlight flightBeingEdited;
    private boolean flightBeingEditedIsNew;

    public void initialize()
    {
        flightTableController.showFlights(DB.getDatabase().getScheduledFlights());
        flightTableController.onFlightSelectionChanged(
                event -> showFlight(event.getSelectedFlight()));
        showFlight(null);
    }
    private void showFlight(ScheduledFlight flight)
    {
        flightEditorController.showFlight(flight);
        flightBeingEdited = flight == null ? new ScheduledFlight() : flight;
        flightBeingEditedIsNew = flight == null;
        String buttonLabel = flightBeingEditedIsNew ? "Add" : "Update";
        updateButton.setText(buttonLabel);
    }

    @FXML
    protected void updateButtonAction()
    {

    }
    @FXML
    protected void newButtonAction()
    {

    }
    @FXML
    protected void deleteButtonAction()
    {

    }

}