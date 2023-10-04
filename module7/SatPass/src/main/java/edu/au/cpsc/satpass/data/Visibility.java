package edu.au.cpsc.satpass.data;

import edu.au.cpsc.satpass.model.VisibilityGenerator;
import org.hipparchus.util.FastMath;
import org.orekit.propagation.analytical.tle.TLE;
import org.orekit.time.AbsoluteDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Visibility
{
    private VisibilityGenerator visGen;
    private List<Pass> passList;
    private Boolean retrieveSuccessful;
    private String satelliteName, satelliteNumber, launchNumber,
            launchYear, inclination, meanMotion, eccentricity, epoch;

    private TLE tle;
    private final String tleLine1 = "1 25544U 98067A   23276.41051990  .00021266  00000+0  38303-3 0  9995";
    private final String tleLine2 = "2 25544  51.6417 152.4854 0005370  65.2174 107.7396 15.49734051418572";

    public Visibility()
    {
        tle = new TLE(tleLine1, tleLine2);
        satelliteName = "";
    }
    public Visibility(String catalogNumber, Double latitude, Double longitude, Double altitude, LocalDate start, LocalDate finish)
            throws Exception
    {
        passList = new ArrayList<>();
        visGen = new VisibilityGenerator(catalogNumber, latitude, longitude, altitude, start, finish);
        retrieveSuccessful = visGen.isValid();
        satelliteName = visGen.getSatelliteName();
        if (retrieveSuccessful)
        {

            tle = visGen.getTle();
            getVisibility();
        }
    }

    public void getVisibility()
    {
        List<List<String>> list = visGen.getVisibility();
        List<List<String>> tempList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++)
        {
            if (Double.parseDouble(list.get(i).get(2)) >= 0.)
            {
                tempList.add(list.get(i));
            }
            else
            {
                if (!tempList.isEmpty())
                {
                    passList.add(new Pass(tempList));
                    tempList = new ArrayList<>();
                }
            }
        }
        if (!tempList.isEmpty()) passList.add(new Pass(tempList));
    }

    public String getSatelliteNumber(){return String.valueOf(tle.getSatelliteNumber());}
    public List<Pass> getPassList()
    {
        return passList;
    }
    public String getSatelliteName()
    {
        return satelliteName;
    }
    public boolean isValid()
    {
        return retrieveSuccessful;
    }
    public String getInclination()
    {
        return String.valueOf(FastMath.toDegrees(tle.getI()));
    }
    public String getMeanMotion()
    {
        return String.valueOf
                (tle.getMeanMotion() * (86400./(2*Math.PI))); // Converts rad/s to revolutions/day
    }
    public String getEccentricity()
    {
        return String.valueOf(tle.getE());
    }
    public String getLaunchYear()
    {
        return String.valueOf(tle.getLaunchYear());
    }
    public String getLaunchNumber()
    {
        return String.valueOf(tle.getLaunchNumber());
    }
    public String getLaunchPiece()
    {
        return tle.getLaunchPiece();
    }
    public String getEpoch()
    {
        return tle.getDate().toString();
    }
}
