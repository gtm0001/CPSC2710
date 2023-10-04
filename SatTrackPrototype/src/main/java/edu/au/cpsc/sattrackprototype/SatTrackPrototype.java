package edu.au.cpsc.sattrackprototype;


public class SatTrackPrototype
{
    public static void main(String[] args)
    {
        ElsetPuller ep = new ElsetPuller("25544");
        String elset = ep.toString();
        String lines[] = elset.split("\n");
        TLE tle = new TLE(lines[1], lines[2]);
        System.out.println(lines[0]);
        System.out.println(tle.toString());
    }

}