package edu.au.cpsc.part2.Model;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;

public class ScheduledFlight implements Serializable
{
    private String flightDesignator;
    private String departureAirportIdent;
    private String arrivalAirportIdent;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private HashSet<DayOfWeek> daysOfWeek;
    private String formattedDaysOfWeek;

    public ScheduledFlight()
    {
        flightDesignator = "";
        departureAirportIdent = "";
        arrivalAirportIdent = "";
        departureTime = LocalTime.now();
        arrivalTime = LocalTime.now();
        daysOfWeek = new HashSet<DayOfWeek>();
        formattedDaysOfWeek = "";
    }

    public String getFlightDesignator() {
        return flightDesignator;
    }

    public void setFlightDesignator(String flightDesignator) throws IllegalArgumentException
    {
        if (flightDesignator == null)
        {
            throw new IllegalArgumentException("Flight designator is null.");
        }
        this.flightDesignator = flightDesignator;
    }

    public String getDepartureAirportIdent() {
        return departureAirportIdent;
    }

    public void setDepartureAirportIdent(String departureAirportIdent) throws IllegalArgumentException
    {
        if (departureAirportIdent == null)
        {
            throw new IllegalArgumentException("Departure Airport Ident is null.");
        }
        this.departureAirportIdent = departureAirportIdent;
    }

    public String getArrivalAirportIdent() {
        return arrivalAirportIdent;
    }

    public void setArrivalAirportIdent(String arrivalAirportIdent) throws IllegalArgumentException
    {
        if (arrivalAirportIdent == null)
        {
            throw new IllegalArgumentException("Arrival Airport Ident is null.");
        }
        this.arrivalAirportIdent = arrivalAirportIdent;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) throws IllegalArgumentException
    {
        if (departureTime == null)
        {
            throw new IllegalArgumentException("Departure time is null.");
        }
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) throws IllegalArgumentException
    {
        if (arrivalTime == null)
        {
            throw new IllegalArgumentException("Arrival time is null.");
        }
        this.arrivalTime = arrivalTime;
    }

    public HashSet<DayOfWeek> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(HashSet<DayOfWeek> daysOfWeek) throws IllegalArgumentException
    {
        if (daysOfWeek == null)
        {
            throw new IllegalArgumentException("daysOfWeek Hashset is null.");
        }
        this.daysOfWeek = daysOfWeek;
        updateFormattedDaysOfWeek();
    }

    @Override
    public String toString() {
        return "ScheduledFlight{" +
                "flightDesignator='" + flightDesignator + '\'' +
                ", departureAirportIdent='" + departureAirportIdent + '\'' +
                ", arrivalAirportIdent='" + arrivalAirportIdent + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", daysOfWeek=" + daysOfWeek +
                '}';
    }
    public String getFormattedDaysOfWeek()
    {
        return formattedDaysOfWeek;
    }
    private void updateFormattedDaysOfWeek()
    {
        formattedDaysOfWeek = "";
        if (daysOfWeek.contains(DayOfWeek.SUNDAY)) formattedDaysOfWeek += "U";
        if (daysOfWeek.contains(DayOfWeek.MONDAY)) formattedDaysOfWeek += "M";
        if (daysOfWeek.contains(DayOfWeek.TUESDAY)) formattedDaysOfWeek += "T";
        if (daysOfWeek.contains(DayOfWeek.WEDNESDAY)) formattedDaysOfWeek += "W";
        if (daysOfWeek.contains(DayOfWeek.THURSDAY)) formattedDaysOfWeek += "R";
        if (daysOfWeek.contains(DayOfWeek.FRIDAY)) formattedDaysOfWeek += "F";
        if (daysOfWeek.contains(DayOfWeek.SATURDAY)) formattedDaysOfWeek += "S";
    }
}
