package edu.au.cpsc.part2.uimodel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FlightDetailModel
{
    private StringProperty flightDesignatorProperty;
    private StringProperty departureAirportProperty;
    private StringProperty arrivalAirportPropery;
    private BooleanProperty sundayProperty;
    private BooleanProperty mondayProperty;
    private BooleanProperty tuesdayProperty;
    private BooleanProperty wednesdayProperty;
    private BooleanProperty thursdayProperty;
    private BooleanProperty fridayProperty;
    private BooleanProperty saturdayProperty;
    private BooleanProperty modifiedProperty;
    private BooleanProperty newProperty;

    public FlightDetailModel()
    {
        //Initialize
        flightDesignatorProperty = new SimpleStringProperty();
        departureAirportProperty = new SimpleStringProperty();
        arrivalAirportPropery = new SimpleStringProperty();
        sundayProperty = new SimpleBooleanProperty();
        mondayProperty = new SimpleBooleanProperty();
        tuesdayProperty = new SimpleBooleanProperty();
        wednesdayProperty = new SimpleBooleanProperty();
        thursdayProperty = new SimpleBooleanProperty();
        fridayProperty = new SimpleBooleanProperty();
        saturdayProperty = new SimpleBooleanProperty();
        modifiedProperty = new SimpleBooleanProperty();
        newProperty = new SimpleBooleanProperty();

        //Add listeners
        flightDesignatorProperty.addListener(((observable, oldValue, newValue) -> setModified(true)));
        arrivalAirportPropery.addListener(((observable, oldValue, newValue) -> setModified(true)));
        departureAirportProperty.addListener(((observable, oldValue, newValue) -> setModified(true)));
        sundayProperty.addListener(((observable, oldValue, newValue) -> setModified(true)));
        mondayProperty.addListener(((observable, oldValue, newValue) -> setModified(true)));
        tuesdayProperty.addListener(((observable, oldValue, newValue) -> setModified(true)));
        wednesdayProperty.addListener(((observable, oldValue, newValue) -> setModified(true)));
        thursdayProperty.addListener(((observable, oldValue, newValue) -> setModified(true)));
        fridayProperty.addListener(((observable, oldValue, newValue) -> setModified(true)));
        saturdayProperty.addListener(((observable, oldValue, newValue) -> setModified(true)));
    }

    public StringProperty flightDesignatorProperty() { return flightDesignatorProperty; }
    public StringProperty departureAirportProperty() { return departureAirportProperty; }
    public StringProperty arrivalAirportProperty() { return arrivalAirportPropery; }
    public BooleanProperty sundayProperty() { return sundayProperty; }
    public BooleanProperty mondayProperty() { return mondayProperty; }
    public BooleanProperty tuesdayProperty() { return tuesdayProperty; }
    public BooleanProperty wednesdayProperty() { return wednesdayProperty; }
    public BooleanProperty thursdayProperty() { return thursdayProperty; }
    public BooleanProperty fridayProperty() { return fridayProperty; }
    public BooleanProperty saturdayProperty() { return saturdayProperty; }
    public BooleanProperty modifiedProperty() { return modifiedProperty; }
    public BooleanProperty newProperty() { return newProperty; }

    public String getFlightDesignator() { return flightDesignatorProperty.get(); }
    public void setFlightDesignator(String fd) { flightDesignatorProperty.set(fd); }
    public String getDepartureAirport() { return departureAirportProperty.get(); }
    public void setDepartureAirport(String da) { departureAirportProperty.set(da); }
    public String getArrivalAirport() { return arrivalAirportPropery.get(); }
    public void setArrivalAirport(String aa) { arrivalAirportPropery.set(aa); }
    public boolean getSundayProperty() { return sundayProperty.get(); }
    public void setSundayProperty(boolean b) { sundayProperty.set(b); }
    public boolean getMondayProperty() { return mondayProperty.get(); }
    public void setMondayProperty(boolean b) { mondayProperty.set(b); }
    public boolean getTuesdayProperty() { return tuesdayProperty.get(); }
    public void setTuesdayProperty(boolean b) { tuesdayProperty.set(b); }
    public boolean getWednesdayProperty() { return wednesdayProperty.get(); }
    public void setWednesdayProperty(boolean b) { wednesdayProperty.set(b); }
    public boolean getThursdayProperty() { return thursdayProperty.get(); }
    public void setThursdayProperty(boolean b) { thursdayProperty.set(b); }
    public boolean getFridayProperty() { return fridayProperty.get(); }
    public void setFridayProperty(boolean b) { fridayProperty.set(b); }
    public boolean getSaturdayProperty() { return  saturdayProperty.get(); }
    public void setSaturdayProperty(boolean b) { saturdayProperty.set(b); }
    public boolean isModified() { return modifiedProperty.get(); }
    public void setModified(boolean b) { modifiedProperty.set(b); }
    public boolean isNew() { return newProperty.get(); }
    public void setNew(boolean b) { newProperty.set(b); }
}
