public class Dressing {

	public static int get_NumAllClothes(String[][] closet) {
		// CODE HERE
		if (closet.length != 4)
			return 0;

		int result = 1;
		for (String[] category : closet) {
			result *= category.length;
		}

		return result;
	}

	public static int get_NumAllCleanClothes(String[][] closet) {
		// CODE HERE
		int result = 0;

		for (String[] category : closet) {
			for (String cloth : category) {
				String cleanedStatus = cloth.split("_")[2];
				if (cleanedStatus.equals("true"))
					result += 1;
			}
		}

		return result;
	}

	public static int get_NumAllClothesByTemp(String[][] closet, int temperature) {
		// CODE HERE
		int result = 0;

		for (String[] category : closet) {
			for (String cloth : category) {

				String name = cloth.split("_")[1];
				if (temperature < 25 && (name.equals("sweater") || name.equals("jacket") || name.equals("jeans")
						|| name.equals("boots") || name.equals("socks")))
					result += 1;
				else if ((temperature >= 25 && temperature <= 65) && (name.equals("tshirt") || name.equals("shirt")
						|| name.equals("trousers") || name.equals("sneakers") || name.equals("shoes")))
					result += 1;
				else if (temperature > 65 && (name.equals("short") || name.equals("sandals")))
					result += 1;

			}
		}

		return result;
	}

}
