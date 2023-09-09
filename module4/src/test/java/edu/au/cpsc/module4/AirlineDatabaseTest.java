package edu.au.cpsc.module4;

import edu.au.cpsc.module4.Data.AirlineDatabase;
import edu.au.cpsc.module4.Model.ScheduledFlight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirlineDatabaseTest
{
    @Test
    void givenNewDatabaseThenGetterReturnsEmptyDatabase()
    {
        AirlineDatabase db = new AirlineDatabase();
        assertEquals(0,db.getScheduledFlights().size());
    }

    @Test
    void givenDatabaseWithScheduledFlightsThenGetterReturnsScheduledFlights()
    {
        ScheduledFlight sf1 = new ScheduledFlight();
        ScheduledFlight sf2 = new ScheduledFlight();

        AirlineDatabase db = new AirlineDatabase();
        db.addScheduledFlight(sf1);
        db.addScheduledFlight(sf2);

        assertEquals(2, db.getScheduledFlights().size());
    }

    @Test
    void givenDatabaseWithScheduledFlightsWhenFlightRemovedThenSizeIsOneLess()
    {
        ScheduledFlight sf1 = new ScheduledFlight();
        ScheduledFlight sf2 = new ScheduledFlight();

        AirlineDatabase db = new AirlineDatabase();
        db.addScheduledFlight(sf1);
        db.addScheduledFlight(sf2);
        db.removeScheduledFlight(sf1);

        assertEquals(1,db.getScheduledFlights().size());
    }
}