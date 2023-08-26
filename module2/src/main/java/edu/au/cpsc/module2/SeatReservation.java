package edu.au.cpsc.module2;

public class SeatReservation
{
	private String flightDesignator;
	private java.time.LocalDate flightDate;
	private String firstName;
	private String lastName;
	private int numberOfBags;
	private boolean flyingWithInfant;


	public SeatReservation()
	{
		flightDesignator = null;
		flightDate = null;
		firstName = null;
		lastName = null;
		numberOfBags = 0;
		flyingWithInfant = false;
	}

	public String getFlightDesignator()
	{
		return flightDesignator;
	}
	public void setFlightDesignator(String fd) throws IllegalArgumentException
	{
		if (fd == null || fd.length() < 4 || fd.length() > 6)
		{
			throw new IllegalArgumentException("Flight Designator length must be 4-6 characters.");
		}
		else flightDesignator = fd;
	}
	public java.time.LocalDate getFlightDate()
	{
		return flightDate;
	}
	public void setFlightDate(java.time.LocalDate date) throws IllegalArgumentException
	{
		if (date == null)
		{
			throw new IllegalArgumentException("Flight Date must be entered.");
		}
		else flightDate = date;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String fn) throws IllegalArgumentException
	{
		if (fn == null || fn.isEmpty()) {throw new IllegalArgumentException("First name cannot be empty.");}
		else firstName = fn;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String ln)
	{
		if (ln == null || ln.isEmpty()) {throw new IllegalArgumentException("Last name cannot be empty.");}
		else lastName = ln;
	}
	public int getNumberOfBags()
	{
		return numberOfBags;
	}
	public void setNumberOfBags(int nb) throws IllegalArgumentException
	{
		if (nb >= 0) {numberOfBags = nb;}
		else throw new IllegalArgumentException("Number of bags cannot be negative.");
	}
	public boolean isFlyingWithInfant() {return flyingWithInfant;}
	public void makeFlyingWithInfant() {flyingWithInfant = true;}
	public void makeNotFlyingWithInfant() {flyingWithInfant = false;}
	public String toString()
	{
		String output = "SeatReservation{flightDesignator=";
		if (flightDesignator == null) output += "null,";
		else output += flightDesignator + ",";
		output += "flightDate=";
		if (flightDesignator == null) output += "null,";
		else output += flightDate.toString() + ",";
		output += "firstName=";
		if (firstName == null) output += "null,";
		else output += firstName + ",";
		output += "lastName=";
		if (lastName == null) output += "null";
		else output += lastName + ",";
		output += "numberOfBags=" + numberOfBags + ",";
		output += "flyingWithInfant=";
		if (flyingWithInfant) output += "true}";
		else output += "false}";
		return output;
	}
}
