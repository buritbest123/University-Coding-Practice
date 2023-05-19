//********************************** DO NOT MODIFY THIS FILE ******************************
import java.util.ArrayList;
import java.util.List;

public class ProductTester {
	
	public static void testWine()
	{
		List<Product> basket = new ArrayList<Product>();
		basket.add(new Wine(500,0,1000));
		basket.add(new Wine(1000,12,950));
		basket.add(new Wine(8999,36,900));
		System.out.println("@@ Wine ==> Original Prices:");
		for(int i = 0; i < basket.size(); i++)
		{
			System.out.printf("Bottle "+i+": %.2f baht\n",basket.get(i).getPrice());
		}
		
		System.out.println("@@ Customers decided to taste some of the wine.");
		((Wine)basket.get(0)).consume(100);
		((Wine)basket.get(2)).consume(66);
		
		System.out.println("@@ Wine ==> After Prices:");
		for(int i = 0; i < basket.size(); i++)
		{
			System.out.printf("Bottle "+i+": %.2f baht\n",basket.get(i).getPrice());
		}
	}
	
	public static void testApp()
	{
		List<App> basket = new ArrayList<App>();
		basket.add(new App(99, 3, "Clubhouse"));
		basket.add(new App(499, 6, "Angry Bird"));
		basket.add(new App(99, 0, "Doctor Wins"));
		System.out.println("@@ App ==> Original Prices:");
		for(App app: basket) System.out.printf(app.getAppTitle()+": %.2f baht\n", app.getPrice());
		
		System.out.println("@@ Let's update all the apps...");
		for(App app: basket) app.update();
		
		System.out.println("@@ App ==> Prices after updating.");
		for(App app: basket) System.out.printf(app.getAppTitle()+": %.2f baht\n", app.getPrice());
		
	}
	
	public static void testSmartPhone()
	{
		App a1 = new App(229, 12, "Discord");
		App a2 = new App(499, 2, "Genshin Impact");
		
		App[] apps = new App[4];
		apps[0] = new App(699, 24, "PokemonGO");
		apps[1] = new App(499, 0, "The Battle Cats");
		apps[2] = new App(19, 3, "Netflix");
		apps[3] = new App(599, 0, "GarageBand");
		
		SmartPhone iPhone = new SmartPhone(25900, 12, "iPhone", false);
		SmartPhone oppo = new SmartPhone(19990, 6, "Oppo", true);
		
		System.out.println("@@ SmartPhone prices before installing apps.");
		System.out.printf(iPhone.getModel()+": %.2f baht\n", iPhone.getPrice());
		System.out.printf(oppo.getModel()+": %.2f baht\n", oppo.getPrice());
		
		System.out.println("@@ SmartPhone prices after installing apps.");
		iPhone.install(a1);
		iPhone.install(a2);
		oppo.install(apps);
		System.out.printf(iPhone.getModel()+": %.2f baht\n", iPhone.getPrice());
		System.out.printf(oppo.getModel()+": %.2f baht\n", oppo.getPrice());
		
		System.out.println("@@ SmartPhone prices after updating apps.");
		iPhone.updateApp("Genshin Impact");
		oppo.updateApp();
		System.out.printf(iPhone.getModel()+": %.2f baht\n", iPhone.getPrice());
		System.out.printf(oppo.getModel()+": %.2f baht\n", oppo.getPrice());
	}
	
	public static void main(String[] args)
	{
		//********** Uncomment the testcase you want to run ******
		//testWine();
		//testApp();
		testSmartPhone();
	}

}
