//Kanyanut Bosuwan 6388008 Sec.3
import java.util.Arrays;
import java.util.List;

public class Student extends Customer{
	private final List<FoodStall.Menu> student = Arrays.asList(new FoodStall.Menu[] {FoodStall.Menu.DESSERT,
																					FoodStall.Menu.DESSERT,
																					FoodStall.Menu.DESSERT,
																					FoodStall.Menu.DESSERT,
																					FoodStall.Menu.DESSERT});
	
	private int sumTime=0;
	
	public Student(CanteenICT _canteen) //customers start to enter to ICTCanteen 
	{
		super(_canteen);
		this.requiredDishes=student; //new menu
		this.customerType=CustomerType.STUDENT;
		for (FoodStall.Menu food:requiredDishes) { 
			this.sumTime = sumTime+FoodStall.EAT_TIME[food.ordinal()];
		}
	}
	
	
	
	
	
	
	
	
}
