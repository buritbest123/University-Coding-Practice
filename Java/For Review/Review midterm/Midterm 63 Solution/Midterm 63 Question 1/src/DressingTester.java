//**************************************//
//*** Please Do Not Modify This File ***//
//**************************************//

public class DressingTester {

	public static void main(String[] args) {

		// Row [0]: tshirt, shirt, sweater, jacket
		// Row [1]: jeans, trousers, short
		// Row [2]: sandals, shoes, sneakers, boots
		// Row [3]: socks
		
		String[][] closet1 = { {"green_tshirt_true", "yellow_jacket_false"},
				  			   {"white_short_false"},
				  			   {"blue_sandals_true", "black_boots_true"},
				  			   {"black_socks_true"}
			   				};
		
		String[][] closet2 = { {"white_tshirt_true", "red_shirt_true", "black_tshirt_false", "navy_sweater_false", "black_jacket_true"},
							  {"blue_jeans_true", "black_jeans_true", "brown_trousers_false", "black_trousers_true","pink_shorts_false"},
							  {"green_sandals_true", "brown_shoes_false", "white_sneakers_true", "black_boots_false"},
							  {"white_socks_true", "black_socks_false", "orange_socks_false", "white_socks_true"}
						   };

		System.out.println("@Test Task1");
		System.out.println("[closet@1] Possible combination of all your clothes is "+Dressing.get_NumAllClothes(closet1)+" styles.");
		System.out.println("[closet@2] Possible combination of all your clothes is "+Dressing.get_NumAllClothes(closet2)+" styles.");

		System.out.println("@Test Task2");
		System.out.println("[closet@1] You have "+Dressing.get_NumAllCleanClothes(closet1)+" clean clothes.");
		System.out.println("[closet@2] You have "+Dressing.get_NumAllCleanClothes(closet2)+" clean clothes.");

		System.out.println("@Test Task3");
		int temperature  = 20;
		System.out.println("[closet@1] Today temperature  is "+temperature +" degree, you have "+Dressing.get_NumAllClothesByTemp(closet1, temperature)+" appropriate clothes to wear.");
		int temperature2  = 45;
		System.out.println("[closet@2]Today temperature  is "+temperature2 +" degree, you have "+Dressing.get_NumAllClothesByTemp(closet2, temperature)+" appropriate clothes to wear.");
	
	}

}
