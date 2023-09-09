package edu.au.cpsc.module4;

import edu.au.cpsc.module4.Data.AirlineDatabase;
import edu.au.cpsc.module4.Data.AirlineDatabaseIO;
import edu.au.cpsc.module4.Model.ScheduledFlight;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class AirlineDatabaseIOTest implements Serializable
{
    @Test
    void givenDatabaseWithScheduledFlightsWhenSavedAndLoadedThenTheDatabasesAreTheSame() throws IOException, ClassNotFoundException
    {
        ScheduledFlight sf1 = new ScheduledFlight();
        ScheduledFlight sf2 = new ScheduledFlight();

        sf1.setArrivalTime(LocalTime.now());
        sf1.setDepartureTime(LocalTime.of(3,0));
        sf1.setFlightDesignator("DELTA 987");
        HashSet<DayOfWeek> dow1 = new HashSet<>();
        dow1.add(DayOfWeek.MONDAY);
        dow1.add(DayOfWeek.WEDNESDAY);
        dow1.add(DayOfWeek.FRIDAY);
        sf1.setDaysOfWeek(dow1);
        sf1.setDepartureAirportIdent("ABC");
        sf1.setArrivalAirportIdent("DEF");

        sf2.setArrivalTime(LocalTime.of(5,45));
        sf2.setDepartureTime(LocalTime.of(9,15));
        sf2.setFlightDesignator("AA 487");
        HashSet<DayOfWeek> dow2 = new HashSet<>();
        dow2.add(DayOfWeek.TUESDAY);
        dow2.add(DayOfWeek.THURSDAY);
        dow2.add(DayOfWeek.SATURDAY);
        sf2.setDaysOfWeek(dow2);
        sf2.setDepartureAirportIdent("GHI");
        sf2.setArrivalAirportIdent("JKL");

        AirlineDatabase db1 = new AirlineDatabase();
        db1.addScheduledFlight(sf1);
        db1.addScheduledFlight(sf2);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        AirlineDatabaseIO.save(db1, out);

        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        AirlineDatabase db2 = AirlineDatabaseIO.load(in);

        assertEquals(2,db2.getScheduledFlights().size());
    }
}