package edu.au.cpsc.module4.Data;

import edu.au.cpsc.module4.Data.AirlineDatabase;
import edu.au.cpsc.module4.Data.AirlineDatabaseIO;

import java.io.*;

public class DB
{
    public static final File DEFAULT_FILE = new File("flights.dat");

    public static AirlineDatabase airlineDatabase = null;

    public static AirlineDatabase getDatabase()
    {
        if (airlineDatabase == null)
        {
            airlineDatabase = loadDatabase();
        }
        return airlineDatabase;
    }

    public static AirlineDatabase loadDatabase()
    {
        try (InputStream is = new FileInputStream(DEFAULT_FILE))
        {
            return AirlineDatabaseIO.load(is);
        }
        catch (IOException | ClassNotFoundException e)
        {
            return new AirlineDatabase();
        }
    }

    public static void saveDatabase()
    {
        try (OutputStream os = new FileOutputStream(DEFAULT_FILE))
        {
            AirlineDatabaseIO.save(getDatabase(), os);
        }
        catch (IOException e)
        {
            System.err.println("Error saving database: " + DEFAULT_FILE);
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
