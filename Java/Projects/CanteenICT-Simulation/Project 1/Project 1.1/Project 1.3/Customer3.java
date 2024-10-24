//Name: Kanyanut Bosuwan
//ID: 6388008
//Section: 3

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	//*********************** DO NOT MODIFY ****************************//
	public static enum CustomerType{DEFAULT, STUDENT, PROFESSOR, ATHLETE, ICTSTUDENT};	//Different types of customers 
	private static int customerRunningNumber = 1;	//static variable for assigning a unique ID to a customer
	private CanteenICT canteen = null;	//reference to the CanteenICT object
	private int customerID = -1;		//this customer's ID
	protected CustomerType customerType = CustomerType.DEFAULT;	//the type of this customer, initialized with a DEFAULT customer.
	protected List<FoodStall.Menu> requiredDishes = new ArrayList<FoodStall.Menu> ();	//List of required dishes
	//*****************************************************************//
	private int sumTime=0;
	
	public boolean check_eatdone(){
		if(this.sumTime<-1) {
			return true; //eating done
		}
		else {
			return false; //still not done 
		}
	}
	
	Customer(CanteenICT _canteen) //customers start to enter to ICTCanteen 
	{
		//******************* YOUR CODE HERE **********************
		this.canteen = _canteen; //Change null to have new input value
		this.customerID =customerRunningNumber++; //-1=1 2 3 4...
		for (FoodStall.Menu food:FoodStall.Menu.values()) { //.values()used with enum //making "food" = value of Menu in FoodStall Class
			this.requiredDishes.add(food); //add food that consumers require
			this.sumTime = sumTime+FoodStall.EAT_TIME[food.ordinal()];
		}
		
		//*****************************************************
	}
	
	public void reduce_eattime(){
		this.sumTime--; //reduce time of consumers' eating 
	}
	
	public void takeAction()
	{
		//************************** YOUR CODE HERE **********************//
		this.canteen.QueueMove(this);
		this.canteen.TakeFood(this);
		if(this instanceof ICTStudent) { //this is from ICT student class?
			//this thing is in ....... class ==true 
			this.canteen.ICTstudent(this); //use method ICT student
		}
		this.canteen.FindTable(this);
		this.canteen.Eating(this);
		
		
		//**************************************************************//
		
	}

	//***************For hashing, equality checking, and general purposes. DO NOT MODIFY **************************//	
	
	public CustomerType getCustomerType()
	{
		return this.customerType;
	}
	
	public int getCustomerID()
	{
		return this.customerID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerID != other.customerID)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerType=" + customerType +"]";
	}

	public String getCode()
	{
		return this.customerType.toString().charAt(0)+""+this.customerID;
	}
	
	/**
	 * print something out if VERBOSE is true 
	 * @param str
	 */
	public void jot(String str)
	{
		if(CanteenICT.VERBOSE) System.out.println(str);
		
		if(CanteenICT.WRITELOG) CanteenICT.append(str, canteen.name+"_state.log");
	}
	
	//*************************************************************************************************//
	
}

