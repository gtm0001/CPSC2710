package cpsc.auburn.edu.module3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class AirportApplicationController
{
    @FXML
    private TextField identTextField;
    @FXML
    private TextField iataCodeTextField;
    @FXML
    private TextField localCodeTextField;
    @FXML
    private WebView webView;
    @FXML
    private Button searchButton;
    @FXML
    private TextField typeTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField elevationTextField;
    @FXML
    private TextField countryTextField;
    @FXML
    private TextField regionTextField;
    @FXML
    private TextField municipalityTextField;
    @FXML
    private Label searchFailedLabel;
    private List<Airport> airportList;

    private void populateList() throws IOException {
        try
        {
            airportList = Airport.readAll();
        } catch (IOException e)
        {
            throw new IOException(e);
        }
    }
    @FXML
    protected void identTextFieldAction()
    {
        searchFailedLabel.setText("");
        String code = identTextField.getText().toUpperCase();
        if (airportList == null || airportList.isEmpty())
        {
            try
            {
                populateList();
            }
            catch (IOException e)
            {
                searchFailedLabel.setText("Could not load airports.");
            }
        }
        boolean found = false;
        Iterator<Airport> iter = airportList.iterator();
        Airport temp = new Airport();
        while (iter.hasNext() && !found)
        {
            temp = iter.next();
            if (temp.getAirportCode().equals(code))
            {
                found = true;
            }
        }
        if (found == false)
        {
            searchFailedLabel.setText("Airport code not found.");
        }
        else
        {
            iataCodeTextField.setText(temp.getIataCode());
            localCodeTextField.setText(temp.getLocalCode());
            setTextFields(temp);
            String url = "https://www.windy.com/?"
                    + temp.getCoordinatesLatitude().toString() + ","
                    + temp.getCoordinatesLongitude().toString() + ",12";
            webView.getEngine().load(url);
        }
    }

    @FXML
    protected void iataCodeTextFieldAction()
    {
        searchFailedLabel.setText("");
        String code = iataCodeTextField.getText().toUpperCase();
        if (airportList == null || airportList.isEmpty())
        {
            try
            {
                populateList();
            }
            catch (IOException e)
            {
                searchFailedLabel.setText("Could not load airports.");
            }
        }
        boolean found = false;
        Iterator<Airport> iter = airportList.iterator();
        Airport temp = new Airport();
        while (iter.hasNext() && !found)
        {
            temp = iter.next();
            if (temp.getIataCode().equals(code))
            {
                found = true;
            }
        }
        if (found == false)
        {
            searchFailedLabel.setText("Airport code not found.");
        }
        else
        {
            identTextField.setText(temp.getAirportCode());
            localCodeTextField.setText(temp.getLocalCode());
            setTextFields(temp);
            String url = "https://www.windy.com/?"
                    + temp.getCoordinatesLatitude().toString() + ","
                    + temp.getCoordinatesLongitude().toString() + ",12";
            webView.getEngine().load(url);
        }
    }

    @FXML
    protected void localCodeTextFieldAction()
    {
        searchFailedLabel.setText("");
        String code = localCodeTextField.getText().toUpperCase();
        if (airportList == null || airportList.isEmpty())
        {
            try
            {
                populateList();
            }
            catch (IOException e)
            {
                searchFailedLabel.setText("Could not load airports.");
            }
        }
        boolean found = false;
        Iterator<Airport> iter = airportList.iterator();
        Airport temp = new Airport();
        while (iter.hasNext() && !found)
        {
            temp = iter.next();
            if (temp.getLocalCode().equals(code))
            {
                found = true;
            }
        }
        if (found == false)
        {
            searchFailedLabel.setText("Airport code not found.");
        }
        else
        {
            iataCodeTextField.setText(temp.getIataCode());
            identTextField.setText(temp.getAirportCode());
            setTextFields(temp);
            String url = "https://www.windy.com/?"
                    + temp.getCoordinatesLatitude().toString() + ","
                    + temp.getCoordinatesLongitude().toString() + ",12";
            webView.getEngine().load(url);
        }
    }

    @FXML
    protected void searchButtonAction()
    {
        if (!identTextField.getText().isEmpty())
        {
            identTextFieldAction();
        }
        else if (!iataCodeTextField.getText().isEmpty())
        {
            iataCodeTextFieldAction();
        }
        else if (!localCodeTextField.getText().isEmpty())
        {
            localCodeTextFieldAction();
        }
        else
        {
            searchFailedLabel.setText("Search fields empty.");
        }
    }

    protected void setTextFields(Airport airport)
    {
        typeTextField.setText(airport.getType());
        nameTextField.setText(airport.getName());
        elevationTextField.setText(airport.getElevationInFeet().toString());
        countryTextField.setText(airport.getCountry());
        regionTextField.setText(airport.getRegion());
        municipalityTextField.setText(airport.getMunicipality());
    }

}