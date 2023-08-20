public class SeatReservation
{
	private String flightDesignator;
	private java.time.LocalDate flightDate;
	private String firstName;
	private String lastName;

	public SeatReservation()
	{
		flightDesignator = null;
		flightDate = null;
		firstName = null;
		lastName = null;
	}

	public String getFlightDesignator()
	{
		return flightDesignator;
	}
	public void setFlightDesignator(String fd) throws IllegalArgumentException
	{
		if (fd == null || fd.length() < 4 || fd.length() > 6)
		{
			throw new IllegalArgumentException("Number of characters must be be 4-6.");
		}
		else flightDesignator = fd;
	}
	public java.time.LocalDate getFlightDate()
	{
		return flightDate;
	}
	public void setFlightDate(java.time.LocalDate date)
	{
		flightDate = date;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String fn)
	{
		firstName = fn;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String ln)
	{
		lastName = ln;
	}
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
		if (lastName == null) output += "null}";
		else output += lastName + "}";
		return output;
	}
}
