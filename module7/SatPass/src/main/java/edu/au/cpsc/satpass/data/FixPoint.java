package edu.au.cpsc.satpass.data;

import java.util.List;

public class FixPoint
{
    private String time;
    private String azimuth;
    private String elevation;
    private String range;

    public FixPoint(List<String> passPoint)
    {
        time = passPoint.get(0);
        azimuth = passPoint.get(1);
        elevation = passPoint.get(2);
        range = passPoint.get(3);
    }
    public String getTime(){return time;}
    public String getAzimuth(){return azimuth;}
    public String getElevation(){return elevation;}
    public String getRange() {return range;}
}
