package edu.au.cpsc.satpass.controller;

import edu.au.cpsc.satpass.data.Pass;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PassTableViewController
{
    private List<Pass> passList;
    @FXML
    private TableView<Pass> passTableView;
    @FXML
    private DetailedPassTableViewController detailedPassTableViewController;
    @FXML
    private TableColumn<Pass,String> riseTimeColumn, setTimeColumn, riseAzColumn,
                                    maxElColumn, setAzColumn;

    public void initialize()
    {
        passList = new ArrayList<>();
        riseTimeColumn.setCellValueFactory
                (new PropertyValueFactory<Pass,String>("riseTime"));
        riseTimeColumn.prefWidthProperty().bind(passTableView.widthProperty().multiply(.2));
        riseAzColumn.setCellValueFactory
                (new PropertyValueFactory<Pass,String>("riseAz"));
        riseAzColumn.prefWidthProperty().bind(passTableView.widthProperty().multiply(.2));
        maxElColumn.setCellValueFactory
                (new PropertyValueFactory<Pass,String>("maxEl"));
        maxElColumn.prefWidthProperty().bind(passTableView.widthProperty().multiply(.2));
        setTimeColumn.setCellValueFactory
                (new PropertyValueFactory<Pass,String>("setTime"));
        setTimeColumn.prefWidthProperty().bind(passTableView.widthProperty().multiply(.2));
        setAzColumn.setCellValueFactory
                (new PropertyValueFactory<Pass,String>("setAz"));
        setAzColumn.prefWidthProperty().bind(passTableView.widthProperty().multiply(.2));

        EventHandler<MouseEvent> onTableClick = this::tableRowClicked;
        passTableView.setRowFactory(s ->
        {
            TableRow<Pass> row = new TableRow<>();
            row.setOnMouseClicked(onTableClick);
            return row;
        });
    }
    private void tableRowClicked(MouseEvent event)
    {
        @SuppressWarnings("unchecked")
        TableRow<Pass> row = (TableRow<Pass>) event.getSource();
        if (!row.isEmpty() && row.getItem() != null)
        {
            try
            {
                detailedPassTableViewController = DetailedPassTableViewController.show();
                detailedPassTableViewController.showPass(row.getItem().getFixPoints());
            }
            catch (IOException e)
            {
                System.out.println("Unable to open detailed pass view.\n" + e.getMessage());
            }
        }
    }
    public void setPassList(List<Pass> passList)
    {
        this.passList = passList;
    }
    public void clearPasses()
    {
        passList = new ArrayList<>();
    }
    public void showPasses()
    {
        passTableView.setItems(FXCollections.observableList(passList));
        passTableView.refresh();
    }

}
