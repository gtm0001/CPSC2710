package edu.au.cpsc.part2.Controller;

import edu.au.cpsc.part2.Model.ScheduledFlight;
import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class FlightTableViewController {

    @FXML
    private TableView<ScheduledFlight> flightTableView;

    @FXML
    private TableColumn<ScheduledFlight, String> flightDesignatorTableColumn,
        departureAirportTableColumn, arrivalAirportTableColumn, daysOfWeekTableColumn;

    public void initialize()
    {
        flightDesignatorTableColumn.setCellValueFactory
                (new PropertyValueFactory<ScheduledFlight, String>("flightDesignator"));
        arrivalAirportTableColumn.setCellValueFactory
                (new PropertyValueFactory<ScheduledFlight, String>("arrivalAirportIdent"));
        departureAirportTableColumn.setCellValueFactory
                (new PropertyValueFactory<ScheduledFlight, String>("departureAirportIdent"));
        daysOfWeekTableColumn.setCellValueFactory
                (new PropertyValueFactory<ScheduledFlight, String>("formattedDaysOfWeek"));
        flightTableView.getSelectionModel().selectedItemProperty().
                addListener(change -> tableSelectionChanged());
    }

    public void showFlights(List<ScheduledFlight> flights)
    {
        SortedList<ScheduledFlight> sortedList =
                new SortedList<>(FXCollections.observableList(flights));
        flightTableView.setItems(sortedList);
        sortedList.comparatorProperty().bind(flightTableView.comparatorProperty());
        flightTableView.refresh();
    }

    public void onFlightSelectionChanged(EventHandler<FlightTableEvent> handler)
    {
        flightTableView.addEventHandler(FlightTableEvent.FLIGHT_SELECTED, handler);
    }

    public void tableSelectionChanged()
    {
        ScheduledFlight selectedFlight = flightTableView.getSelectionModel().getSelectedItem();
        FlightTableEvent event = new FlightTableEvent(FlightTableEvent.FLIGHT_SELECTED,
                selectedFlight);
        flightTableView.fireEvent(event);
    }

    public void select(ScheduledFlight flight)
    {
        flightTableView.getSelectionModel().select(flight);
    }
    public ScheduledFlight getSelectedFlight()
    {
        return flightTableView.getSelectionModel().getSelectedItem();
    }

    public static class FlightTableEvent extends Event
    {
        public static final EventType<FlightTableEvent> ANY =
                new EventType<>(Event.ANY, "ANY");
        public static final EventType<FlightTableEvent> FLIGHT_SELECTED =
                new EventType<>(ANY, "FLIGHT_SELECTED");

        public ScheduledFlight selectedFlight;

        public FlightTableEvent(EventType<? extends Event> eventType,
                                ScheduledFlight selectedFlight)
        {
            super(eventType);
            this.selectedFlight = selectedFlight;
        }
        public ScheduledFlight getSelectedFlight()
        {
            return selectedFlight;
        }
    }
}
