package edu.au.cpsc.module4.Controller;

import edu.au.cpsc.module4.Data.DB;
import edu.au.cpsc.module4.Model.ScheduledFlight;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FlightSummaryAppController
{
    @FXML
    private FlightTableViewController flightTableViewController;
    @FXML
    private FlightEditorViewController flightEditorViewController;
    @FXML
    private Button updateButton;

    private ScheduledFlight flightBeingEdited;
    private boolean flightBeingEditedIsNew;

    public void initialize()
    {
        flightTableViewController.showFlights(DB.getDatabase().getScheduledFlights());
        flightTableViewController.onFlightSelectionChanged(
                event -> showFlight(event.getSelectedFlight()));
        showFlight(null);
    }
    private void showFlight(ScheduledFlight flight)
    {
        flightEditorViewController.showFlight(flight);
        flightBeingEdited = flight == null ? new ScheduledFlight() : flight;
        flightBeingEditedIsNew = flight == null;
        String buttonLabel = flightBeingEditedIsNew ? "Add" : "Update";
        updateButton.setText(buttonLabel);
    }

    @FXML
    protected void updateButtonAction()
    {
        flightEditorViewController.updateFlight(flightBeingEdited);
        if (flightBeingEditedIsNew)
        {
            DB.getDatabase().addScheduledFlight(flightBeingEdited);
        }
        else
        {
            DB.getDatabase().updateScheduledFlight(flightBeingEdited);
        }
        DB.saveDatabase();
        flightTableViewController.showFlights(DB.getDatabase().getScheduledFlights());
        flightTableViewController.select(flightBeingEdited);
    }
    @FXML
    protected void newButtonAction()
    {
        flightTableViewController.select(null);
    }
    @FXML
    protected void deleteButtonAction()
    {
        if (flightBeingEditedIsNew)
        {
            flightTableViewController.select(null);
        }
        else
        {
            DB.getDatabase().removeScheduledFlight(flightBeingEdited);
            DB.saveDatabase();
            flightTableViewController.showFlights(DB.getDatabase().getScheduledFlights());
        }
    }

}