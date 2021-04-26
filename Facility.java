/* Angel Serrano
 * CS 2012
 * Section 05
 * Description: SplitDate finished using date.Split("-") to determine the split of the date
 * and using Integer.ParseInt to determine which one is year, month, day
 */
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Class to store the data of each Facility from the input .csv file.
 * You must finish the splitDate() method.  Do not alter anything else.
 * Do not remove this comment.  Add your header comment above this.
 * 
 * @author Keenan 
 *
 */
public class Facility {
	private String name;
	private String address;
	private int zipcode;
	private int year;
	private int month;
	private int day;
	private int score;
	private char grade;
	
	
	public Facility(String name, String address, int zipcode, String date, int score, char grade) throws DateFormatException {
		try {
			splitDate(date);
		}
		catch(DateFormatException ex) {
			throw ex; //rethrow the exception.
		}
		
		this.name = name;
		this.address = address;
		this.zipcode = zipcode;
		this.score = score;
		this.grade = grade;
	}
	
	private void splitDate(String date) throws DateFormatException {
		if (isValidDate(date)) {
			String[] dateArray = date.split("-");
			year = Integer.parseInt(dateArray[0]);
			month = Integer.parseInt(dateArray[1]);
			day = Integer.parseInt(dateArray[2]);
		}
		else {
			throw new DateFormatException("Date format not correct for date " + date + ". Correct format is: YYYY-MM-DD");
		}
	}
	
	private boolean isValidDate(String date) {
		//Dates are in the format YYYY-MM-DD (year, month, day with hyphens in between).
		//NOTE: Single digit numbers for month and day should have a leading 0 (so 1 is 01, 2 is 02 and so on...)
		
		//NOTE: The following is a regular expression which can be used to validate the date format.  It will check 
		// the date has the correct number of characters, that the numbers are in the correct ranges, and
		// the hypens are in the correct positions.  Regular Expressions are a very powerful concept to learn.
		// This is a very advanced topic.  If you are interested in learning about this, google "regular expressions" and read about them.
		final String DATE_REGEX = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
		return date.matches(DATE_REGEX);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		String date = String.format("%d-%02d-%02d", year, month, day);
		
		sb.append("Facility Name:\t\t" + this.name + "\n");
		sb.append("Address:\t\t" + this.address + "\n");
		sb.append("\t\t\tLos Angeles, CA " + this.zipcode + "\n");
		sb.append("Date of Inspection:\t" + date + "\n");
		sb.append("Score:\t\t\t" + this.score + "\n");
		sb.append("Grade: \t\t\t" + this.grade + "\n");
		
		return sb.toString();
	}
}
