//Name:Supawit Phimonjit
//ID:6388129
//Section:2

import java.util.ArrayList;
import java.util.List;

public class Table {
	//********************** DO NOT MODIFY *****************************//
	public static final int MAX_SEATS = 4;	//Max number of customers for one table
	private static int countTables = 0;	//A static variable to assign a unique table ID
	
	private int tableID = -1;	//table ID
	private List<Customer> seatedCustomers = new ArrayList<Customer>();	//List of seated customers
	//*****************************************************************//
	public List<Customer> seatedCustomersnext = new ArrayList<Customer>();// new seatedCustomers array is use to modify and try to not modify in the main array
	public void postprocess() { //set seatedCustomersnext array equal seatedCustomers array to modify
		this.seatedCustomers=this.seatedCustomersnext;
	}

	
	//************************************ DO NOT MODIFY ****************************************//
	/**
	 * Constructor
	 */
	public Table()
	{
		countTables++;
		tableID = countTables;
	}
	
	public int getID()
	{
		return this.tableID;
	}
	
	public List<Customer> getSeatedCustomers()
	{
		return this.seatedCustomers;
	}
	
	/**
	 * Returns true if the table is currently fully occupied 
	 * @return
	 */
	public boolean isFull()
	{	if(seatedCustomers == null) return true;
	
		return this.seatedCustomers.size() >= MAX_SEATS;
	}
	//*******************************************************************************************//
	
}
