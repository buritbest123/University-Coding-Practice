import java.util.Scanner;
public class j_Logical_operators {

    public static void main(String[] args) {

        // logical operators = used to connect two or more expressions
        //
        //						&& = (AND) both conditions must be true
        // 						|| = (OR) either condition must be true
        //						! = (NOT) reverses boolean value of condition

// -------------------------------- Example 1 --------------------------------

        System.out.println("What is the weather right now?");
        Scanner scanner = new Scanner(System.in);
        int temp = scanner.nextInt();

		if(temp>30) {
			System.out.println("It is hot outside");
		}
		else if(temp>=20 && temp<=30) {
			System.out.println("It is warm outside");
		}
		else {
			System.out.println("It is cold outside");
		}


// -------------------------------- Example 2 --------------------------------

        scanner.nextLine();
		System.out.println("You are playing a game! Press q or Q to quit");
		String response = scanner.nextLine();

		if(!response.equals("q") && !response.equals("Q")) {
			System.out.println("YOu are still playing the game *pew pew*");
		}
		else {
			System.out.println("You quit the game");
		}

    }
}