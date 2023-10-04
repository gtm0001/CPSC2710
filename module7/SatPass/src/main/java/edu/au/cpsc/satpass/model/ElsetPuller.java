package edu.au.cpsc.satpass.model;

import java.net.*;
import java.io.*;

public class ElsetPuller
{
   private String tle = "";
   private String catalogNumber = "";

   public ElsetPuller(String numberIn) throws Exception
   {
      catalogNumber = numberIn;
      tle = getUrlContents("https://celestrak.org/NORAD/elements/gp.php?CATNR="
                          + catalogNumber + "&FORMAT=TLE");
      if (tle.contains("No GP data found")) throw new Exception("No element set data found for that satellite number. ");
   }
   
   private static String getUrlContents(String theUrl) throws Exception
   {
      StringBuilder content = new StringBuilder();

      URL url = new URL(theUrl);
      URLConnection urlConnection = url.openConnection();

      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
      String line;
      while ((line = bufferedReader.readLine()) != null)
      {
         content.append(line + "\n:");
      }
      bufferedReader.close();

      return content.toString();
   }   
  
   public String toString()
   {
      return tle;
   }  
   

}



