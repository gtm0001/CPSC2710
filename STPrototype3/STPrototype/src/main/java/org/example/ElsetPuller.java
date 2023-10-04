package org.example;

import java.net.*;
import java.io.*;

/** 
 * Description of program. 
 *
 * Enter Assignment Nomenclature.
 * @author G. Taylor McClamroch - CPSC 1210 - A01
 * @version Date
 */
public class ElsetPuller
{
   private String tle = "";
   private String catalogNumber = "";
  /**
   * Description of method.
   * @param args Command line arguments - not used.
   */
   public ElsetPuller(String numberIn)
   {
      catalogNumber = numberIn;
      tle = getUrlContents("https://celestrak.org/NORAD/elements/gp.php?CATNR="
                          + catalogNumber + "&FORMAT=TLE");
   }
   
   private static String getUrlContents(String theUrl)
   {
      StringBuilder content = new StringBuilder();
      try
      {
         URL url = new URL(theUrl);
         URLConnection urlConnection = url.openConnection();
         
         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
         String line;
         while ((line = bufferedReader.readLine()) != null)
         {
            content.append(line + "\n:");
         }
         bufferedReader.close();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      return content.toString();
   }   
  
   public String toString()
   {
      return tle;
   }  
   

}



