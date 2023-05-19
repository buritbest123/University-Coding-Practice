import java.io.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ICTCovidReporter {

	//CASE1: Display All Data by date
	public static void showData(String file, String date) {
		//TODO: CODE HERE
		BufferedReader read_bigdata; // Another read file : For many/much information
		String collect_data; // To collect all of data
		try {
			read_bigdata = new BufferedReader(new FileReader(file)); // https://blog.nextzy.me/basicjavaiostream-2c45277618ba
			int i = 0; // Initialization i = 0;
			System.out.println("[Date:" + date + "]");
			while ((collect_data = read_bigdata.readLine()) != null) { // This loop run for runtime by not null and not empty
				String[] array = collect_data.split(","); // When find "," split the information
				if (i > 0) { // For Not print the first row
					if (array[3].compareTo(date) == 0 && !Objects.equals(array[4], "") && (!array[4].isEmpty())) { // The data will not be displayed if new cases is 0 or empty.
						if (Integer.parseInt(array[4]) > 0) { // convert string to int and new_cases is more than 0 cases
							System.out.println("[" + array[2] + "] new case: " + array[4]);
						}
					}
				}
				i++;
			}
			read_bigdata.close(); // scanner named "read_bigdata" close
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//CASE2: Get Total Case from new case by location
	public static long getTotalCases(String file, String location) {
		//TODO: CODE HERE
		BufferedReader read_bigdata; // Another read file : For much information
		String collect_data; // To collect all of data
		long total_case = 0; // Initialization "total_case = 0"
		try {
			read_bigdata = new BufferedReader(new FileReader(file));  // https://blog.nextzy.me/basicjavaiostream-2c45277618ba
			int i = 0;
			while ((collect_data = read_bigdata.readLine()) != null) { // This loop run for runtime by not null and not empty
				String[] array = collect_data.split(","); // When find "," split the information
				if (i > 0) { // For Not print the first row
					if (array[2].compareTo(location) == 0 && !array[4].equals("") && (!array[4].isEmpty())) {
						total_case += Integer.parseInt(array[4]); // convert string to int and sum every cases
					}
					if (location.equals("*") && !Objects.equals(array[4], "") && (!array[4].isEmpty())) {
						total_case += Integer.parseInt(array[4]); // convert string to int and sum every cases
					}
				}
				i++;
			}
			read_bigdata.close(); // scanner named "read_bigdata" close
		} catch (IOException e) {
			e.printStackTrace();
		}
		return total_case;
	}

	//CASE3: Display All incorrect Date Format DD/MM/YYYY
	public static void showIncorrectDate(String file) {
		//TODO: CODE HERE
		BufferedReader read_bigdata; // Another read file : For much information
		String collect_data; // To collect all of data
		try {
			read_bigdata = new BufferedReader(new FileReader(file)); // https://blog.nextzy.me/basicjavaiostream-2c45277618ba
			int i = 0;
			while ((collect_data = read_bigdata.readLine()) != null) { // This loop run for runtime by not null and not empty
				String[] array = collect_data.split(","); // When find "," split the information
				if (i > 0) {
					if (!array[3].contains("/")) {
						System.out.println("[" + array[2] + "] Wrong Format: " + array[3]);
					}
				}
				i++;
			}
			read_bigdata.close(); // scanner named "read_bigdata" close
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		/* Modify absolute path to the file located in your machine*/
		String csvFile = "C:\\Users\\Admin\\IdeaProjects\\Lab 12\\owid-covid-data.csv";


		//CASE1:
		showData(csvFile, "24/02/2020");

		//CASE 2:
		System.out.println(getTotalCases(csvFile, "*") + " cases.");
		System.out.println(getTotalCases(csvFile, "Thailand") + " cases.");

		//CASE3:
		showIncorrectDate(csvFile);
	}
}
