package edu.au.cpsc.satpass.data;

import org.orekit.time.AbsoluteDate;

import java.util.ArrayList;
import java.util.List;

public class Pass
{
    private String riseTime;
    private String setTime;
    private Double riseAz;
    private Double setAz;
    private Double maxEl;
    private List<List<String>> fullVisList;
    private List<FixPoint> fixPoints;

    public Pass(List<List<String>> visList)
    {
        maxEl = Double.MIN_VALUE;
        fullVisList = visList;
        fixPoints = new ArrayList<>();
        init();
    }
    private void init()
    {
        riseTime = fullVisList.get(0).get(0);
        riseAz = Double.valueOf(fullVisList.get(0).get(1));
        setTime = fullVisList.get(fullVisList.size()-1).get(0);
        setAz = Double.valueOf(fullVisList.get(fullVisList.size()-1).get(1));
        for (int i = 0; i < fullVisList.size(); i++)
        {
            fixPoints.add(new FixPoint(fullVisList.get(i)));
            maxEl = Double.max(Double.parseDouble(fullVisList.get(i).get(2)), maxEl);
        }
    }
    public String getRiseTime()
    {
        return riseTime;
    }

    public String getSetTime()
    {
        return setTime;
    }

    public String getRiseAz()
    {
        return String.valueOf(riseAz);
    }

    public String getSetAz()
    {
        return String.valueOf(setAz);
    }

    public String getMaxEl()
    {
        return String.valueOf(maxEl);
    }

    public List<List<String>> getFullVisList()
    {
        return fullVisList;
    }

    public List<FixPoint> getFixPoints() {return fixPoints;}

    public String toString()
    {
        String s = getRiseTime() + " " + getRiseAz() + " " +
                   getSetTime() + " " + getSetAz() + "\n";
        return s;
    }

}
