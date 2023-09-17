package edu.au.cpsc.part2.Data;

import edu.au.cpsc.part2.Model.ScheduledFlight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AirlineDatabase implements Serializable
{
    private List<ScheduledFlight> scheduledFlights;

    public AirlineDatabase()
    {
        scheduledFlights = new ArrayList<>();
    }

    public List<ScheduledFlight> getScheduledFlights()
    {
        return scheduledFlights;
    }
    public void addScheduledFlight(ScheduledFlight sf)
    {
        scheduledFlights.add(sf);
    }
    public void removeScheduledFlight(ScheduledFlight sf)
    {
        scheduledFlights.remove(sf);
    }
    public void updateScheduledFlight(ScheduledFlight sf)
    {

    }
}
