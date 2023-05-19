package app;
import java.text.DecimalFormat;

public interface Loggable {
    // This static variable used for set the format for the number
	// e.g., if the value is 15.5, the result will show in 15.50
	public static final DecimalFormat df = new DecimalFormat("0.00");

	/**
	 *
	 * @return string representing an object to store in the text file
	 */
	public String log();
}