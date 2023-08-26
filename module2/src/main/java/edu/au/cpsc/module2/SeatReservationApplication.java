package edu.au.cpsc.module2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class SeatReservationApplication extends Application {
    private SeatReservation seatReservation;
    private TextField flightDesignatorText;
    private DatePicker flightDateDisplay;
    private TextField firstNameText;
    private TextField lastNameText;
    private TextField numberOfBagsText;
    private CheckBox flyingWithInfantBox;
    private TextField numPassengersText;
    @Override
    public void start(Stage stage) {
        initSeatReservation();

        GridPane gridPane = getGridPane();

        HBox hBox = new HBox();
        Button save = new Button("Save");
        save.setOnAction(event -> saveAction());
        Button cancel = new Button("Cancel");
        cancel.setOnAction(event -> cancelAction());
        hBox.getChildren().addAll(save, cancel);
        hBox.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(gridPane);
        root.setBottom(hBox);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Seat Reservation");
        stage.setScene(scene);
        updateUI();
        stage.show();
    }

    private void initSeatReservation() {
        seatReservation = new SeatReservation();
        seatReservation.setFlightDesignator("ABC3F");
        seatReservation.setFlightDate(LocalDate.of(2001,1,1));
        seatReservation.setFirstName("Jane");
        seatReservation.setLastName("Doe");
        seatReservation.makeNotFlyingWithInfant();
        seatReservation.setNumberOfBags(0);
    }

    private GridPane getGridPane() {
        GridPane gridPane = new GridPane();

        gridPane.add(new Label("Flight Designator:  "),0,0);
        gridPane.add(new Label("Flight Date:  "),0,1);
        gridPane.add(new Label("First Name:  "),0,2);
        gridPane.add(new Label("Last Name:  "),0,3);
        gridPane.add(new Label("Number of Bags:  "),0,4);
        gridPane.add(new Label("Flying with Infant:  "),0,5);
        gridPane.add(new Label("Number of passengers:  "), 0,6);

        flightDesignatorText = new TextField();
        flightDateDisplay = new DatePicker();
        firstNameText = new TextField();
        lastNameText = new TextField();
        numberOfBagsText = new TextField();
        flyingWithInfantBox = new CheckBox();
        flyingWithInfantBox.setOnAction(event -> flyingWithInfantAction());
        numPassengersText = new TextField("1");
        numPassengersText.setEditable(false);

        gridPane.add(flightDesignatorText,1,0);
        gridPane.add(flightDateDisplay,1,1);
        gridPane.add(firstNameText,1,2);
        gridPane.add(lastNameText,1,3);
        gridPane.add(numberOfBagsText,1,4);
        gridPane.add(flyingWithInfantBox,1,5);
        gridPane.add(numPassengersText,1,6);

        return gridPane;
    }

    public void updateUI()
    {
        flightDesignatorText.setText(seatReservation.getFlightDesignator());
        flightDateDisplay.setValue(seatReservation.getFlightDate());
        firstNameText.setText(seatReservation.getFirstName());
        lastNameText.setText(seatReservation.getLastName());
        numberOfBagsText.setText(String.valueOf(seatReservation.getNumberOfBags()));
        flyingWithInfantBox.setSelected(seatReservation.isFlyingWithInfant());
    }

    private void flyingWithInfantAction()
    {
        if (flyingWithInfantBox.isSelected()) {numPassengersText.setText("2");}
        else numPassengersText.setText("1");
    }

    private void saveAction() throws IllegalArgumentException
    {
        try
        {
            seatReservation.setFlightDesignator(flightDesignatorText.getText());
            seatReservation.setFlightDate(flightDateDisplay.getValue());
            seatReservation.setFirstName(firstNameText.getText());
            seatReservation.setLastName(lastNameText.getText());
            seatReservation.setNumberOfBags(Integer.parseInt(numberOfBagsText.getText()));
            if (flyingWithInfantBox.isSelected()) {
                seatReservation.makeFlyingWithInfant();
            } else seatReservation.makeNotFlyingWithInfant();
            System.out.println(seatReservation.toString());
            Platform.exit();
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.toString());
        }
    }

    private void cancelAction()
    {
        System.out.println("Cancel clicked");
        Platform.exit();
    }

    public static void main(String[] args) {
        launch();
    }
}