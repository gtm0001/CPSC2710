package edu.au.cpsc.satpass.model;

import org.orekit.bodies.BodyShape;
import org.orekit.bodies.GeodeticPoint;
import org.orekit.bodies.OneAxisEllipsoid;
import org.orekit.frames.Frame;
import org.orekit.frames.FramesFactory;
import org.orekit.frames.TopocentricFrame;
import org.orekit.propagation.Propagator;
import org.orekit.propagation.SpacecraftState;
import org.orekit.propagation.analytical.tle.TLE;
import org.orekit.propagation.analytical.tle.TLEPropagator;
import org.orekit.time.AbsoluteDate;
import org.orekit.time.TimeScalesFactory;
import org.orekit.utils.Constants;
import org.orekit.utils.IERSConventions;
import org.hipparchus.util.FastMath;




import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VisibilityGenerator
{    private TLE tle;
    private String satelliteName;
    private GeodeticPoint groundStation;
    private AbsoluteDate fromDate;
    private AbsoluteDate toDate;
    private boolean retrievedValidTLE;
    private Propagator tlePropagator;
    private Frame earthFrame;
    private BodyShape earth;
    private TopocentricFrame groundStationFrame;

    public VisibilityGenerator(String catalogNumber, Double latitude, Double longitude, Double altitude, LocalDate start, LocalDate finish) throws Exception
    {
        //Initialize user input variables
        tle = retrieveTle(catalogNumber);

        if (tle == null)
        {
            retrievedValidTLE = false;
        }
        else retrievedValidTLE = true;

        fromDate = new AbsoluteDate(start.getYear(), start.getMonthValue(), start.getDayOfMonth(), 0, 0, 0., TimeScalesFactory.getUTC());
        toDate = new AbsoluteDate(finish.getYear(), finish.getMonthValue(), finish.getDayOfMonth(), 23, 59, 0., TimeScalesFactory.getUTC());

        //Generate propagator, earth reference/shape, and groundStation-earth binding
        if(retrievedValidTLE)
        {
            tlePropagator = TLEPropagator.selectExtrapolator(tle);
            earthFrame = FramesFactory.getITRF(IERSConventions.IERS_2010, true);
            earth = new OneAxisEllipsoid(Constants.WGS84_EARTH_EQUATORIAL_RADIUS,
                    Constants.WGS84_EARTH_FLATTENING, earthFrame);
            setGroundStation(latitude, longitude, altitude);
        }

    }

    private TLE retrieveTle(String catalogNumber) throws Exception
    {
        ElsetPuller ep = new ElsetPuller(catalogNumber);
        String[] lines = ep.toString().split("\n");
        if (lines.length != 4) return null;
        satelliteName = lines[0];
        String line1 = lines[1].substring(1);
        String line2 = lines[2].substring(1);
        if (TLE.isFormatOK(line1, line2))
        {
            return new TLE(line1, line2);
        }
        return null;
    }
    public TLE getTle()
    {
        return tle;
    }
    public String getSatelliteName(){return satelliteName;}


    public void setGroundStation(Double latitude, Double longitude, Double altitude)
    {
        groundStation = new GeodeticPoint(FastMath.toRadians(latitude), FastMath.toRadians(longitude), altitude);
        groundStationFrame = new TopocentricFrame(earth, groundStation, "Ground Station");
    }

    public boolean isValid()
    {
        return retrievedValidTLE;
    }
    public List<List<String>> getVisibility()
    {
        //Each List<String> in format: DateTimeGroup, Az, El, Range
        List<List<String>> visList = new ArrayList<>();
        double maxCheck = 1;
        double threshold = 0.001;
        double elevation = FastMath.toRadians(0.);
        AbsoluteDate stepper = fromDate.getDate();
        while (stepper.isBefore(toDate))
        {
            SpacecraftState state = tlePropagator.propagate(stepper);
            ArrayList<String> tempList = new ArrayList<>();
            tempList.add(state.getDate().toString());
            tempList.add(String.valueOf(FastMath.toDegrees(groundStationFrame.getAzimuth
                    (state.getPVCoordinates().getPosition(), state.getFrame(), stepper.getDate()))));
            tempList.add(String.valueOf(FastMath.toDegrees(groundStationFrame.getElevation
                    (state.getPVCoordinates().getPosition(), state.getFrame(), stepper.getDate()))));
            tempList.add(String.valueOf(groundStationFrame.getRange
                    (state.getPVCoordinates().getPosition(), state.getFrame(), stepper.getDate()) / 1000)); //convert to km
            visList.add(tempList);
            stepper = new AbsoluteDate(stepper, 1);
        }
        return visList;
    }

}
