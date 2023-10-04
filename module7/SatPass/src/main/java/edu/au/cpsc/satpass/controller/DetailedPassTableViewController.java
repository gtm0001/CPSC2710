package edu.au.cpsc.satpass.controller;

import edu.au.cpsc.satpass.data.FixPoint;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DetailedPassTableViewController
{
    @FXML
    private TableView<FixPoint> detailedPassTableView;
    @FXML
    private TableColumn<FixPoint,String> timeColumn, azimuthColumn, elevationColumn, rangeColumn;
    private List<FixPoint> fixPoints;

    public void initialize()
    {
        List<String> temp = new ArrayList<>();
        temp.add("");
        temp.add("");
        temp.add("");
        temp.add("");
        fixPoints = new ArrayList<>();
        fixPoints.add(new FixPoint(temp));
        timeColumn.setCellValueFactory
                (new PropertyValueFactory<FixPoint,String>("time"));
        timeColumn.prefWidthProperty().bind(detailedPassTableView.widthProperty().multiply(.25));
        azimuthColumn.setCellValueFactory
                (new PropertyValueFactory<FixPoint,String>("azimuth"));
        azimuthColumn.prefWidthProperty().bind(detailedPassTableView.widthProperty().multiply(.25));
        elevationColumn.setCellValueFactory
                (new PropertyValueFactory<FixPoint,String>("elevation"));
        elevationColumn.prefWidthProperty().bind(detailedPassTableView.widthProperty().multiply(.25));
        rangeColumn.setCellValueFactory
                (new PropertyValueFactory<FixPoint,String>("range"));
        rangeColumn.prefWidthProperty().bind(detailedPassTableView.widthProperty().multiply(.25));
    }
    public void showPass(List<FixPoint> list)
    {
        fixPoints = list;
        detailedPassTableView.setItems(FXCollections.observableList(fixPoints));
        detailedPassTableView.refresh();
    }

    public static DetailedPassTableViewController show() throws IOException
    {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(DetailedPassTableViewController.class.getResource("/edu/au/cpsc/satpass/views/detailed-pass-table-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Detailed Pass Viewer");
        stage.setScene(scene);
        stage.show();
        return fxmlLoader.getController();
    }
}
