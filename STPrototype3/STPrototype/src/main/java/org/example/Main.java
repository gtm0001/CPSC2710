package org.example;
import org.hipparchus.geometry.euclidean.threed.Vector3D;
import org.hipparchus.ode.events.Action;
import org.hipparchus.util.FastMath;
import org.orekit.bodies.BodyShape;
import org.orekit.bodies.GeodeticPoint;
import org.orekit.bodies.OneAxisEllipsoid;
import org.orekit.data.DataContext;
import org.orekit.data.DataProvidersManager;
import org.orekit.data.DirectoryCrawler;
import org.orekit.frames.Frame;
import org.orekit.frames.FramesFactory;
import org.orekit.frames.TopocentricFrame;
import org.orekit.orbits.KeplerianOrbit;
import org.orekit.orbits.Orbit;
import org.orekit.orbits.PositionAngle;
import org.orekit.propagation.Propagator;
import org.orekit.propagation.SpacecraftState;
import org.orekit.propagation.analytical.KeplerianPropagator;
import org.orekit.propagation.analytical.tle.TLE;
import org.orekit.propagation.analytical.tle.TLEPropagator;
import org.orekit.propagation.conversion.TLEPropagatorBuilder;
import org.orekit.propagation.events.ElevationDetector;
import org.orekit.propagation.events.EventDetector;
import org.orekit.time.AbsoluteDate;
import org.orekit.time.TimeScalesFactory;
import org.orekit.utils.Constants;
import org.orekit.utils.IERSConventions;

import java.io.File;

public class Main {
    public static void main(String[] args) throws RuntimeException
    {
        File orekitData = new File("src/main/resources/orekit-data-master");
        DataProvidersManager manager = DataContext.getDefault().getDataProvidersManager();
        manager.addProvider(new DirectoryCrawler(orekitData));
        ElsetPuller ep = new ElsetPuller("25544");
        String elset = ep.toString();
        String lines[] = elset.split("\n");
        lines[1] = lines[1].substring(1);
        lines[2] = lines[2].substring(1);
        if (!TLE.isFormatOK(lines[1], lines[2]))
        {
            throw new RuntimeException("TLE format incorrect.");
        }
        TLE tle = new TLE(lines[1], lines[2]);
        AbsoluteDate initialDate = new AbsoluteDate
                (2023, 10, 1, 23, 00, 0., TimeScalesFactory.getUTC());
        AbsoluteDate finalDate = new AbsoluteDate
                (2023, 10, 1, 23, 11, 59., TimeScalesFactory.getUTC());
        //Frame inertialFrame = FramesFactory.getEME2000();
        Propagator tlePropagator = TLEPropagator.selectExtrapolator(tle);


        //Ground station ALTAIR
        double longitude = FastMath.toRadians(167.475833);
        double latitude = FastMath.toRadians(9.396111);
        double altitude = 0;
        GeodeticPoint altair = new GeodeticPoint(latitude, longitude, altitude);

        Frame earthFrame = FramesFactory.getITRF(IERSConventions.IERS_2010, true);
        BodyShape earth = new OneAxisEllipsoid(Constants.WGS84_EARTH_EQUATORIAL_RADIUS,
                            Constants.WGS84_EARTH_FLATTENING, earthFrame);
        TopocentricFrame altairFrame = new TopocentricFrame(earth, altair, "ALTAIR");

        double maxCheck = 1;
        double threshold = 0.001;
        double elevation = FastMath.toRadians(0.);
//        EventDetector altairVisibility =
//                new ElevationDetector(maxCheck, threshold, altairFrame).
//                        withConstantElevation(elevation).
//                        withHandler((s, detector, increasing) ->
//                        {
//                            System.out.println("Visibility on " +
//                                    detector.getTopocentricFrame().getName() +
//                                    (increasing ? " begins at: " : " ends at: ")
//                                    + s.getDate() + " at " +
//                                    FastMath.toDegrees(detector.getTopocentricFrame().getAzimuth(s.getPVCoordinates().getPosition(), s.getFrame(), s.getDate()))
//                                    + " degrees Azimuth");
//                            return increasing ? Action.CONTINUE : Action.STOP;
//                        });
//        tlePropagator.addEventDetector(altairVisibility);
        SpacecraftState finalState = tlePropagator.propagate(initialDate, finalDate);
        AbsoluteDate stepper = initialDate.getDate();
        System.out.println("Trace: ");
        while (stepper.isBefore(finalDate))
        {
            SpacecraftState stepState = tlePropagator.propagate(stepper);
            System.out.println("Time: " + stepState.getDate() + "  Az: " +
                    FastMath.toDegrees(altairFrame.getAzimuth(stepState.getPVCoordinates().getPosition(), stepState.getFrame(), stepper.getDate())) +
                    "  El: " +
                    FastMath.toDegrees(altairFrame.getElevation(stepState.getPVCoordinates().getPosition(), stepState.getFrame(), stepper.getDate())));
            stepper = new AbsoluteDate(stepper, 1);
        }
        System.out.println(finalState.getDate().toString());
    }
}