//Name: Kanyanut Bosuwan
//ID: 6388008
//Section: 3

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CanteenICT {

	//*********************** DO NOT MODIFY ****************************//
	public static final int MAX_NUM_FOODSTALLS = 10;	//Max number of food stalls
	public static final int MAX_NUM_TABLES = 10;		//Max number of tables 
	public static final int MAX_BUDGET = 70000;			//Max budget for food stall installation
	
	//logging variables
	public static final boolean VERBOSE = true;		//If set true, things will be printed out on the console
	public static final boolean WRITELOG = true;	//If set true, log files will be generated
	
	
	//state variables
	public String name = null;		//The name of this CanteenICT
	private int timer = 0;			//The timer variable, incremented at the beginning of each iteration
	private	boolean running = false;	//True if the simulation is still running 
	
	//resource variables
	private List<Customer> allCustomers = new ArrayList<Customer>();	//List of all the customers, initialized by setCustomers()
	private List<Customer> waitToEnterQueue = new ArrayList<Customer>();	//List of the customers waiting to enter the canteen
	private List<Customer> waitToSeatQueue = new ArrayList<Customer>();	//List of the customers waiting to take seats at the tables
	private List<Customer> doneQueue =  new ArrayList<Customer>();		//List of the customers who already finish eating
	
	private List<FoodStall> foodStalls = new ArrayList<FoodStall>();	//List of the food stalls
	private List<Table> tables = new ArrayList<Table>();				//List of the tables
	//******************************************************************//
	//add copy for change information //in case preprocess
	private List<Customer> enter = new ArrayList<Customer>(); //waitforenter
	private List<Customer> seat = new ArrayList<Customer>(); //waitforseat

	//================Extra Method for using with Customer Action===================//
	//1.QueueMove 2.TakeFood 3.FindTable 4.Eating 5.*Bonus*
	//Using information in this class is easier
	
	//1//
	public void QueueMove(Customer _customer) { //go to min line
		FoodStall MinLine = this.foodStalls.get(0);//To be first index of ArrayList //find min
		for(int j=0;j<this.foodStalls.size();j++) {
			if(MinLine.Queue().size()>this.foodStalls.get(j).Queue().size() ) { //compare
				if(this.foodStalls.get(j).getMenu().containsAll(_customer.requiredDishes)) { //look that do it contains required food?
					MinLine = this.foodStalls.get(j);
				}
			}
		}
		if(this.enter.indexOf(_customer)==0){ //if this is first customer who will enter to CanteenICT
			if(FoodStall.MAX_QUEUE > MinLine.Queue().size() ) { //the max line is still more than this line
		        this.waitToEnterQueue.remove(_customer);
		        MinLine.getCustomerQueue().add(_customer);
			}
		}
		
	}
	
	//2//
	public void TakeFood(Customer _customer) { //order food 
		FoodStall foodorder = this.foodStalls.get(0);
        for(int i = 0; i < this.foodStalls.size(); i++){ //input menu that customers want 
            if(this.foodStalls.get(i).Queue().contains(_customer)){ 
                foodorder = this.foodStalls.get(i);
            }
        }
        if(foodorder.isWaitingForOrder()!=false && foodorder.Queue().indexOf(_customer)==0){ //!=false =true
        //if first person still waiting for order
       		 foodorder.takeOrder(_customer.requiredDishes); //take order
        }
        else if(foodorder.isReadyToServe()!=false&&foodorder.Queue().indexOf(_customer)==0) { //food ready to serve = true
    		foodorder.serve(); //serve 
       		foodorder.getCustomerQueue().remove(_customer); //remove from line
    		this.waitToSeatQueue.add(_customer); //add to find siting 
    	}
     
      }
	
	
	//3//
	public void FindTable(Customer _customer) {
		for(int i = 0; i < this.tables.size(); i++){ 
            if(Table.MAX_SEATS>this.tables.get(i).seated().size()&&this.seat.indexOf(_customer)==0){ //no more max and first customer
	                this.tables.get(i).getSeatedCustomers().add(_customer); //add customer in table
	                this.waitToSeatQueue.remove(_customer); //remove from queue
	                break; 
            }
        }
	}
	
	//4//
	public void Eating(Customer _customer) {
		for(int j = 0; j < this.tables.size();j++) { //normal citizens
			if(tables.get(j).getSeatedCustomers().contains(_customer)){ //find that customers have sit 
					_customer.reduce_eattime(); //reduce eat time when customer can find table
				if(_customer.check_eatdone()!=false){ //!=false =true //when eat done = change information 
	                this.doneQueue.add(_customer);
	                tables.get(j).getSeatedCustomers().remove(_customer); 
	            }
	        }
		}
	}
	
	//*BONUS*// //ICT Student// 
	//instanceof classICT --> Customer
	public void ICTstudent(Customer _customer) {
	 //System.out.println(this.doneQueue.size());
	if(this.doneQueue.contains(_customer)==false) {
		for(int i = 0; i < this.tables.size(); i++){ //Check table
            if(Table.MAX_SEATS==this.tables.get(i).seated().size()&&this.seat.indexOf(_customer)==0){ //seat =people who wait to seat 
            	//if tables are full, first customer who is ICT student waiting for seat can eat by standing until finish in seat queue
            	_customer.reduce_eattime();
            	if(_customer.check_eatdone()==true) {
            		this.waitToSeatQueue.remove(_customer);
            		this.doneQueue.add(_customer);
            	}//remove from queue
              }
			}
		}
	}
	
	
	//==================================================================//
	/**
	 * Compute the cost of building of all the food stalls. 
	 * The building cost of a food stall is the sum of the installation cost of each food type that it sells.
	 * For example, if foodStalls[0] sells NOODLES and foodStalls[1] sells MEAT and SALAD, then the total
	 * installation cost would be 4000 + 5000 + 3500 = 12500 baht 
	 */
	public int getInstallCost()
	{	
		//************************************** YOUR CODE HERE *********************************//
		int totalcost = 0;
		for(int j = 0; j<foodStalls.size();j++){ 
			for (int k = 0; k<foodStalls.get(j).getMenu().size(); k++){
				for(FoodStall.Menu food: FoodStall.Menu.values()) {
					if(foodStalls.get(j).getMenu().get(k).equals(food)) { //if buy shop 
						totalcost = totalcost+FoodStall.INSTALLATION_COST[food.ordinal()];
					}
				}
			}
		}
		return totalcost;
		//**************************************************************************************//
	}

	/**
	 * Validating the canteen in the following aspects, before the simulation:
	 * - Cost of setting up the food stalls must not exceed the max budget.
	 * - A customer's required food types must be satisfied by at least one food stall.
	 * - There is at least one table.
	 * @return
	 */
	//STUDENT
	public boolean validateCanteen()
	{
		//************************************** YOUR CODE HERE *********************************//
		boolean overbugget_noshop=false; //it is in bugget and it has at least one shop
		boolean abletobuy = false; //able to buy
		if(this.getInstallCost()>MAX_BUDGET&&this.tables.isEmpty()==true) {
			overbugget_noshop = true; //it is over bugget and it has no shop 
		}
			 for(int i = 0; i < this.foodStalls.size(); i++){ //Check that food stalls have all menu that customers want 
                 for(int j = 0; j < this.allCustomers.size(); j++){
                     if(this.foodStalls.get(i).getMenu().containsAll(this.allCustomers.get(j).requiredDishes)){
                    	 abletobuy = true;
                         break;
                     }
                 }
             }
		if(overbugget_noshop==false&&abletobuy==true) {
			return true;
		} else {
			return false;
		}
}
		//**************************************************************************************//
	
	
	
	/**
	 * This method is optional, but it gives you some flexibility to do pre-processing, if any, before processing the customers.
	 */
	private void preprocess()
	{
		//******************************************** YOUR CODE HERE (IF ANY) *******************************//
		this.enter.removeAll(this.enter); //remove customer who is entering 
				
		this.enter.addAll(this.waitToEnterQueue); //go to queue 
		
		//****************************************************************************************************//
	}
	
	/**
	 * This method is optional, but it gives you some flexibility to do post-processing stuff if any, before printing the snapshot.
	 */
	private void postprocess()
	{
		int i =0;
		while( i < foodStalls.size()) {
            this.foodStalls.get(i).Queue().removeAll(this.foodStalls.get(i).Queue());
            this.foodStalls.get(i).Queue().addAll(this.foodStalls.get(i).getCustomerQueue());
        
			i++;
		}
		this.seat.removeAll(this.seat); 
        
        this.seat.addAll(this.waitToSeatQueue);
        
        int j=0;
        while(j < tables.size()){
            this.tables.get(j).seated().removeAll(this.tables.get(j).seated());
            this.tables.get(j).seated().addAll(this.tables.get(j).getSeatedCustomers());
            j++;
        }
			
	}
	
	
	
	/**
	 * If customerConfig is null, print a warning message and do nothing.
	 * 
	 * Remove existing customers in the waiting to enter queue if any.
	 * 
	 * Parse the input customerConfig where each character represent the type of a customer, 
	 * and add the customers to the waitToEnterQueue observing the ordering. 
	 * 
	 * 'D' = DEFAULT, 'S' = STUDENT, 'P' = PROFESSOR, 'A' = ATHLETE, 'I' = ICTSTUDENT (Only implement DEFAULT customer for the main project.
	 * Other types of customers are for the bonus credits.)
	 * 
	 * For example, 'DD' means add two default customers. 'SPS' means add a student, a professor, and another student to waitToEnterQueue.
	 * 
	 * @param customerConfig
	 * @return
	 */
	
	public int setCustomers(String customerConfig)
	{
		if(customerConfig == null)
		{
			System.out.println("Input string cannot be null.");
			return 0;
		}
		
		this.allCustomers.clear();
		
		
		for(int i = 0; i < customerConfig.length(); i++)
		{
			char ch = customerConfig.charAt(i);
			Customer c = null;
			switch(ch)
			{	case 'D': c = new Customer(this); break;
				//******************************** YOUR CODE HERE (BONUS) ***********************************//
				
				case 'S': c = new Student(this);  break; //
				case 'F': c = new Professor(this);  break; //
				case 'A': c = new Athlete(this);  break; //
				case 'I': c = new ICTStudent(this);  break; //
			
				//******************************************************************************************//
			}
			if(c!=null)
			{
				this.allCustomers.add(c);
			}
		}
		
		this.waitToEnterQueue.clear();
		this.waitToEnterQueue.addAll(this.allCustomers);
		
		return this.allCustomers.size();
	}
	
	

	
	//******************************************** DO NOT MODIFY ****************************************//
	

	/**
	 * Initialize your canteen by setting timer to 0, and canteen name
	 * @param name
	 */
	public CanteenICT(String name)
	{
		timer = 0;
		this.name = name;
	}

	public int getCurrentTime()
	{
		return timer;
	}

	public String getName() {
		return this.name;
	}


	public int setFoodStalls(String[][] foodStallConfig)
	{
		if(foodStallConfig == null) return 0;
		for(String[] ss: foodStallConfig)
		{
			String name = ss[0];
			List<FoodStall.Menu> menu = new ArrayList<FoodStall.Menu>();
			for(int i = 0; i < ss[1].length(); i++)
			{
				char ch = ss[1].charAt(i);
				switch(ch)
				{	case 'N': if(!menu.contains(FoodStall.Menu.NOODLES)) menu.add(FoodStall.Menu.NOODLES); break;
				case 'D': if(!menu.contains(FoodStall.Menu.DESSERT)) menu.add(FoodStall.Menu.DESSERT); break;
				case 'M': if(!menu.contains(FoodStall.Menu.MEAT)) menu.add(FoodStall.Menu.MEAT); break;
				case 'S': if(!menu.contains(FoodStall.Menu.SALAD)) menu.add(FoodStall.Menu.SALAD); break;
				case 'B': if(!menu.contains(FoodStall.Menu.BEVERAGE)) menu.add(FoodStall.Menu.BEVERAGE); break;
				}
			}

			FoodStall fs = new FoodStall(name, this, menu);
			this.foodStalls.add(fs);

		}
		return this.foodStalls.size();
	}

	/**
	 * Return true of all the customers are in the done queue (no more simulation needed)
	 * @return
	 */
	public boolean isFinished()
	{
		return this.doneQueue.size() == this.allCustomers.size();
	}
	
	
	/**
	 * 
	 * Remove existing tables in this.tables if any.
	 * Initialize tables by adding numTables tables to this.tables. If numTables > MAX_NUM_TABLES, only add MAX_NUM_TABLES tables.
	 * @param numTables
	 * @return the number of tables added.
	 */
	public int setTables(int numTables)
	{
		if(numTables > MAX_NUM_TABLES)  numTables = MAX_NUM_TABLES;
		for(int i = 0; i < numTables; i++)
		{
			this.tables.add(new Table());
		}
		
		return this.tables.size();
	}
	
	
	/**
	 * Call simulate(-1).
	 */
	public void simulate()
	{
		simulate(-1);
	}


	/**
	 * The main mechanism that simulate the canteen. Starting by validating the canteen and removing all the existing log files.
	 * In each iteration, it increments the timer then loops through each customer to invoke takeAction().
	 * The simulation terminates when the termination criteria is met or maxIteration is reached. 
	 * If maxIteration is < 0, it runs until the simulation ends.
	 * @param maxIteration
	 */
	public void simulate(int maxIteration)
	{


		if(!this.validateCanteen())
		{
			System.out.println("The canteen does not pass the validation. Cannot simulate.");
			return;
		}

		//clear all the existing log files
		removeLogFiles();
		running = true;
		log();	//log initial state
		while(timer < maxIteration || maxIteration < 0)
		{

			//increment timer, required.
			timer++;
			this.preprocess();
			
			for(Customer c: this.allCustomers)
			{
				c.takeAction();
			}

			//synchronize qeueues
			this.postprocess();


			log();

			//if done terminate
			if(this.isFinished())
			{
				System.out.println("@@@ Done simulation. Good bye. :)");
				break;
			}

		}
		running = false;
		log();
	}
		
	/**
	 * This method returns a string representing the snapshot of the canteen.
	 * @return
	 */
	public String printState()
	{
		StringBuilder str = new StringBuilder();
		str.append("======================= T:"+this.timer+"=======================\n");
		
		StringBuilder temp = new StringBuilder();
		for(Customer c: this.waitToEnterQueue)
		{
			temp.append(c.getCustomerType().name().charAt(0)+""+c.getCustomerID()+" ");
		}
		str.append("[Waiting-to-Enter Queue]: "+temp.toString().trim().replace(' ', '-')+"\n");
		
		
		for(FoodStall fs: this.foodStalls)
		{
			str.append("[Food Stall: "+fs.getName()+"]: ");
			temp = new StringBuilder();
			for(Customer c: fs.getCustomerQueue())
			{
				temp.append(c.getCustomerType().name().charAt(0)+""+c.getCustomerID()+" ");
			}
			str.append(temp.toString().trim().replace(' ', '-')+"\n");
		}
		
		temp = new StringBuilder();
		for(Customer c: this.waitToSeatQueue)
		{
			temp.append(c.getCustomerType().name().charAt(0)+""+c.getCustomerID()+" ");
		}
		str.append("[Waiting-to-Seat Queue]: "+temp.toString().trim().replace(' ', '-')+"\n");
		
		for(int i = 0; i < this.tables.size(); i++)
		{	Table t =  this.tables.get(i);
			str.append("[Table "+t.getID()+"]: ");
			temp = new StringBuilder();
			for(Customer c: t.getSeatedCustomers())
			{
				temp.append(c.getCustomerType().name().charAt(0)+""+c.getCustomerID()+" ");
			}
			str.append(temp.toString().trim().replace(' ', '-')+"\n");
		}
		
		//done queue
		temp = new StringBuilder();
		for(Customer c: this.doneQueue)
		{
			temp.append(c.getCustomerType().name().charAt(0)+""+c.getCustomerID()+" ");
		}
		str.append("[Done Queue]: "+temp.toString().trim().replace(' ', '-')+"\n");
		
		return str.toString();
	}
	
	/**
	 * This method appends logs to the log files.
	 */
	private void log()
	{
		String state = this.printState();
		if(VERBOSE) System.out.println(state);
		
		if(WRITELOG)
		{
			if(running)
			{
				int numInFoodQueues = 0;
				int numOnTables = 0;
				for(FoodStall fs: this.foodStalls)
				{
					numInFoodQueues += fs.getCustomerQueue().size();
				}
				for(Table t: this.tables)
				{
					numOnTables += t.getSeatedCustomers().size();
				}
				
				
				String summary = "T="+this.timer+
						"\t"+this.waitToEnterQueue.size()+
						"\t"+numInFoodQueues+
						"\t"+this.waitToSeatQueue.size()+
						"\t"+numOnTables+
						"\t"+this.doneQueue.size();
				
				append(state, this.name+"_state.log");
				append(summary, this.name+"_summary.log");
			}
			else if(timer > 0)
			{
				append("@@ Simulation Done. Great Job!!", this.name+"_state.log");
				append("@@ Simulation Done. Great Job!!", this.name+"_summary.log");
			}
		
		}
	}
	
	/**
	 * Delete existing log files if any
	 */
	private void removeLogFiles()
	{
		
		try {
			File summaryLog = new File(this.name+"_summary.log");
			Files.deleteIfExists(summaryLog.toPath());
			
			File stateLog = new File(this.name+"_state.log");
			Files.deleteIfExists(stateLog.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * A convenient method to append str to the File identified by filename. Only works with newer version of Java.
	 * @param str
	 * @param filename
	 */
	public static void append(String str, String filename)
	{
		try {
			FileWriter fileWriter = new FileWriter(filename, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
		    printWriter.println(str); 
		    printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	}
	
	//**************************************************************************************************//
}
