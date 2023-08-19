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
	public void setFlightDesignator(String fd)
	{
		flightDesignator = fd;
	}
	public java.time.LocalDate getFlightDate()
	{
		return flightDate;
	}
	public setFlightDate(java.time.LocalDate date)
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
	}
}
