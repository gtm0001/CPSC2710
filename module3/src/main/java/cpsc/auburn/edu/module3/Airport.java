package cpsc.auburn.edu.module3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Airport
{
    //Instance Variables
    private String airportCode;
    private String type;
    private String name;
    private Integer elevationInFeet;
    private String continent;
    private String country;
    private String region;
    private String municipality;
    private String gpsCode;
    private String iataCode;
    private String localCode;
    private Double coordinatesLongitude;
    private Double coordinatesLatitude;

    public Airport()
    {
        airportCode = "";
        type = "";
        name = "";
        elevationInFeet = Integer.MIN_VALUE;
        continent = "";
        country = "";
        region = "";
        municipality = "";
        gpsCode = "";
        iataCode = "";
        localCode = "";
        coordinatesLatitude = Double.MIN_VALUE;
        coordinatesLongitude = Double.MIN_VALUE;
    }

    public Airport(String s)
    {
        initialize(s);
    }

    public void initialize(String s) throws IllegalArgumentException
    {
        String[] columns = s.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        if (columns.length != 12)
        {
            for (String e : columns)
            {
                System.out.println(e);
            }
            throw new IllegalArgumentException("File not formatted correctly.");
        }
        setAirportCode(columns[0]);
        setType(columns[1]);
        setName(columns[2]);
        if(columns[3].isEmpty())
        {
            setElevationInFeet(0);
        }
        else
        {
            setElevationInFeet(Integer.valueOf(columns[3]));
        }
        setContinent(columns[4]);
        setCountry(columns[5]);
        setRegion(columns[6]);
        setMunicipality(columns[7]);
        setGpsCode(columns[8]);
        setIataCode(columns[9]);
        setLocalCode(columns[10]);
        //Remove unwanted quotes from Latitude and Longitude
        columns[11] = columns[11].substring(1,columns[11].length() - 2);
        String[] coordinates = columns[11].split(",");
        setCoordinatesLongitude(Double.valueOf(coordinates[0]));
        setCoordinatesLatitude(Double.valueOf(coordinates[1]));

    }

    //Getters and Setters
    public String getAirportCode() {
        return airportCode;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Integer getElevationInFeet() {
        return elevationInFeet;
    }

    public String getContinent() {
        return continent;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getGpsCode() {
        return gpsCode;
    }

    public String getIataCode() {
        return iataCode;
    }

    public String getLocalCode() {
        return localCode;
    }

    public Double getCoordinatesLongitude() {
        return coordinatesLongitude;
    }

    public Double getCoordinatesLatitude() {
        return coordinatesLatitude;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setElevationInFeet(Integer elevationInFeet) {
        this.elevationInFeet = elevationInFeet;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public void setGpsCode(String gpsCode) {
        this.gpsCode = gpsCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public void setLocalCode(String localCode) {
        this.localCode = localCode;
    }

    public void setCoordinatesLongitude(Double coordinatesLongitude) {
        this.coordinatesLongitude = coordinatesLongitude;
    }

    public void setCoordinatesLatitude(Double coordinatesLatitude) {
        this.coordinatesLatitude = coordinatesLatitude;
    }

    public static List<Airport> readAll() throws IOException
    {
        List<Airport> airports = new ArrayList<>();
        try
        {
            File file = new File("src/main/resources/airport_codes.csv");
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\n");
            scanner.nextLine();
            int i = 2;
            while (scanner.hasNext())
            {
                String s = scanner.next();
                airports.add(new Airport(s));
            }
        }
        catch (IOException e)
        {
            System.out.println("Cannot find file.");
        }
        return airports;
    }

}