package hw07;

/**
 * Custom exception class for project. Made By Professor Keenan
 *
 */
public class DateFormatException extends Exception {
	private static final long serialVersionUID = 1L;
	private String date;
	
	public DateFormatException(String msg) {
		super(msg);
	}

}
