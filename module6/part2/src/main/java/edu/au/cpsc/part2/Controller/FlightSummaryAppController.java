package edu.au.cpsc.part2.Controller;

import edu.au.cpsc.part2.Data.DB;
import edu.au.cpsc.part2.Model.ScheduledFlight;
import edu.au.cpsc.part2.uimodel.FlightDetailModel;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FlightSummaryAppController
{
    @FXML
    private FlightTableViewController flightTableViewController;
    @FXML
    private FlightEditorViewController flightEditorViewController;
    @FXML
    private Button updateButton, newButton, deleteButton;

    private ScheduledFlight flightBeingEdited;
    private boolean flightBeingEditedIsNew;

    public void initialize()
    {
        flightTableViewController.showFlights(DB.getDatabase().getScheduledFlights());
        flightTableViewController.onFlightSelectionChanged(
                event -> showFlight(event.getSelectedFlight()));
        FlightDetailModel uiModel = flightEditorViewController.getModel();
        setBindings(uiModel);
        showFlight(null);
    }
    public void setBindings(FlightDetailModel uiModel)
    {
        StringBinding labelProperty = Bindings.
                when(uiModel.newProperty()).
                then("Add").
                otherwise("Update");
        updateButton.textProperty().bind(labelProperty);
        updateButton.disableProperty().bind(uiModel.modifiedProperty().not());
        newButton.disableProperty().bind(uiModel.modifiedProperty().or(uiModel.newProperty()));
        deleteButton.disableProperty().bind(uiModel.modifiedProperty().or(uiModel.newProperty()));

    }
    private void showFlight(ScheduledFlight flight)
    {
        flightEditorViewController.showFlight(flight);
    }

    @FXML
    protected void updateButtonAction()
    {
        if (flightEditorViewController.getModel().isNew())
        {
            addFlight();
        }
        else
        {
            updateFlight();
        }
    }
    private void addFlight()
    {
        ScheduledFlight flight = new ScheduledFlight();
        if (!flightEditorViewController.updateFlight(flight))
        {
            return;
        }
        DB.getDatabase().addScheduledFlight(flight);
        saveDatabaseAndUpdateTable(flight);
    }
    private void updateFlight()
    {
        ScheduledFlight flight = getFlightBeingEdited();
        if (!flightEditorViewController.updateFlight(flight))
        {
            return;
        }
        DB.getDatabase().updateScheduledFlight(flight);
        saveDatabaseAndUpdateTable(flight);
    }
    public ScheduledFlight getFlightBeingEdited()
    {
        return flightTableViewController.getSelectedFlight();
    }
    private void saveDatabaseAndUpdateTable(ScheduledFlight flight)
    {
        DB.saveDatabase();
        flightTableViewController.showFlights(DB.getDatabase().getScheduledFlights());
        flightTableViewController.select(flight);
    }
    @FXML
    protected void newButtonAction()
    {
        flightTableViewController.select(null);
    }
    @FXML
    protected void deleteButtonAction()
    {
        if (flightEditorViewController.getModel().isNew())
        {
            flightTableViewController.select(null);
        }
        else
        {
            DB.getDatabase().removeScheduledFlight(getFlightBeingEdited());
            DB.saveDatabase();
            flightTableViewController.showFlights(DB.getDatabase().getScheduledFlights());
        }
    }

}