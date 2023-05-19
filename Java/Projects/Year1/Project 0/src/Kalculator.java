//Name: Burit Sihabut
//ID: 6488079
//Section: 1

import java.util.Collections;
import java.util.ArrayList; // To inserting and removing elements | import array list

public class Kalculator {
	//******INSERT YOUR CODE HERE***********
	//Class attributes go here
	ArrayList<Double> data_array = new ArrayList<>(); // Cannot use primitive type as type parameters | But, there are ArrayList<Integer> and ArrayList<Double> | name: data_array
	//**************************************
	/**
	 * Constructor is the fist method to be call at instantiation of a Kalculator object.
	 * If you need to initialize your object, do so here.
	 */
	Kalculator()
	{
		//******INSERT YOUR CODE HERE***********

		//**************************************
	}

	/**
	 * Add number to the list of numbers.
	 * @param number
	 */
	public void addNumber(double number)
	{	//******INSERT YOUR CODE HERE***********
		data_array.add(number); // It is used to insert the specified element at the specified position (data_array) in a list
		//**************************************
	}

	/**
	 * Remove the least recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteFirstNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if (!data_array.isEmpty()){ // Check if the list is not empty, do remove first_number
			data_array.remove(0);
		}
		//**************************************
	}

	/**
	 * Remove the most recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteLastNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if (!data_array.isEmpty()){ // Check if the list is not empty, do remove last_number
			data_array.remove(data_array.size()-1);
		}
		//**************************************
	}

	/**
	 * Calculate the summation of all the numbers in the list, then returns the sum.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getSum()
	{
		//******INSERT YOUR CODE HERE***********
		double sum = 0; // Set sum = 0
			for (double i : data_array){ // For-each loop (another array traversing technique like for loop, while loop, do-while | for (double i=0; i<data_array.length; i++)
			sum += i;
		}
		if(data_array.isEmpty()){ // If the list is empty, return 0
			return 0;
		}
		return sum; // Calculate the summation of all the numbers in the list, then returns the sum
		//**************************************
	}

	/**
	 * Calculate and return the average of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getAvg()
	{
		//******INSERT YOUR CODE HERE***********
		if(data_array.isEmpty()){ // If the list is empty, return 0.
			return 0;
		}
		return getSum() / data_array.size(); // Calculate and return the average of all the numbers in the list.
		//**************************************
	}

	/**
	 * Calculate and return the sample standard deviation of all the numbers in the list.
	 * If the list has fewer than 2 numbers, return 0.
	 * @return
	 */
	public double getStd()
	{
		//******INSERT YOUR CODE HERE***********
		double sum = 0; // Set sum = 0
		double n = data_array.size()-1; // Sample standard deviation | n-1
		if(data_array.size() > 2){ // If the list has more than 2 numbers, Calculate and return the sample standard deviation of all the numbers in the list.
			for (double i : data_array){ // is equivalent to for (double i=0; i<data_array.length;i++)
				sum += Math.pow(i-getAvg(),2); // Sigma(i-Sample Mean)²
			}
			return Math.sqrt(sum / n); // Should have n because we need to double / double
		}else{ // If the list has fewer than 2 numbers, return 0.
			return 0;
		}
		//**************************************
	}

	/**
	 * Find and return the maximum of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getMax()
	{
		//******INSERT YOUR CODE HERE***********
		double max = Double.MIN_VALUE; // Set max holding the minimum value a double can have -2³¹ | To check in Line 124
		if(!data_array.isEmpty()){ // If the list is not empty, do For-each
			for (double i : data_array){ // is equivalent to for (double i=0; i<data_array.length;i++)
				if (i>=max){ // When a larger value is found, that becomes the new maximum
					max = i;
				}
			}
		}else{ // If the list is empty, return 0.
			return 0;
		}
		return max;
		//**************************************
	}

	/**
	 * Find and return the minimum of all the numbers in the list.
	 * If the list is empty, return 0.
	 */
	public double getMin()
	{
		//******INSERT YOUR CODE HERE***********
		double min = Double.MAX_VALUE; // Set min holding the maximum value a double can have 2³¹-1 | To check in Line 148
		if(!data_array.isEmpty()){ // If the list is not empty, do For-each
			for (double i : data_array){ // is equivalent to for (double i=0; i<data_array.length;i++)
				if (i<=min){ // When a smaller value is found, that becomes the new minimum
					min = i;
				}
			}
		}else{ // If the list is empty, return 0.
			return 0;
		}
		return min;
		//**************************************
	}

	/**
	 * Find and return the maximum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the max k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMaxK(int k) {
		//******INSERT YOUR CODE HERE***********
		if (data_array.size() >= k) {  // If the list has more than k numbers, do line code 167-172
			ArrayList<Double> clone_data = new ArrayList<>(data_array); //name: clone_data
			Collections.sort(clone_data); // It is used to sort the elements of clone_data
			double[] max_array = new double[k]; // Construct Array of length 'k' | Assign Reference of Array to data variable | name: max_array
			for (int i = 0; i < k; i++)
				max_array[i] = clone_data.get(clone_data.size() - 1 - i); // Get the max k elements
			return max_array; // return the maximum k numbers of all the numbers in the list as an array of k double number.
		}
		return null;
		//**************************************
	}

	/**
	 * Find and return the minimum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the min k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMinK(int k)
	{
		//******INSERT YOUR CODE HERE***********
		if (data_array.size() >= k){ // If the list has more than k numbers, do line code 187-193
			ArrayList<Double> clone_data = new ArrayList<>(data_array); //name: clone_data
			Collections.sort(clone_data); // It is used to sort the elements of clone_data
			double[] min_array = new double[k]; // Construct Array of length 'k' | Assign Reference of Array to data variable | name: min_array
			for (int i = 0; i < k; i++)
				min_array[i] = clone_data.get(i); // // Get the min k elements
				return min_array; // return the minimum k numbers of all the numbers in the list as an array of k double number.
		}
		return null;
		//**************************************
	}

	/**
	 * Print (via System.out.println()) the numbers in the list in format of:
	 * DATA[<N>]:[<n1>, <n2>, <n3>, ...]
	 * Where N is the size of the list. <ni> is the ith number in the list.
	 * E.g., "DATA[4]:[1.0, 2.0, 3.0, 4.0]"
	 */
	public void printData()
	{
		//******INSERT YOUR CODE HERE***********
		System.out.print("DATA[" + data_array.size() + "]:["); // // Print the format
		for (int i = 0; i < data_array.size(); i++){
			if (i != data_array.size() - 1){
				System.out.print(data_array.get(i)+ ", ");
			}else{
				System.out.print(data_array.get(i));
			}
		}
		System.out.println("]");
		//**************************************
	}
}