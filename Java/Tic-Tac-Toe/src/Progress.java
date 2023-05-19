import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Progress extends GameBoard implements PlayerAndCheckConDiction
{
    static ArrayList<Integer> player1Positions = new ArrayList<>();
    static ArrayList<Integer> player2Positions = new ArrayList<>();

    public void GameStart()
    {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '}, // Create Basic gameBoard 9x9
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        Scanner user = new Scanner(System.in);
        System.out.println("Press 1, player1 will go first | Press 2, player2 will go first");
        int number = user.nextInt();

        while (true) // Always Loop this block
        {
            Scanner scan_position = new Scanner(System.in); // use Scanner named scan_position
            // Player 1 Turn
            if (number == 1)
            {
                int players1 = getPlayers("Player 1 Enter your placement (1-9): ", scan_position);
                placePiece(gameBoard, players1, "player1"); // called method placePiece
                    printGameBoard(gameBoard); // called method printGameBoard

                    String result = checkWinner(); // Create String called result
                if (result.length() > 0) // If result length more than 0, then print the result
                {
                    System.out.println(result);
                    break;
                }
                int players2 = getPlayers("Player 2 Enter your placement (1-9): ", scan_position);
                placePiece(gameBoard, players2, "player2"); // called method placePiece
                    printGameBoard(gameBoard);    // called method printGameBoard
                    result = checkWinner(); // Create String called result
                if (result.length() > 0) // If result length more than 0, then print the result
                {
                    System.out.println(result);
                    break;
                }
            }
            else // Player 2 will come first
            {
                    System.out.println("Player 2 Enter your placement (1-9): ");
                    int players2 = scan_position.nextInt();

                // To check that Does it have symbols already in that position?
                while (player1Positions.contains(players2) || player2Positions.contains(players2) || !(players2 >= 1 && players2 <=9))
                {
                    System.out.println("Position Taken! or Invalid Input! Enter a correct Position");
                    players2 = scan_position.nextInt();
                }
                    System.out.println(players2); // print position that players1 that choose
                    placePiece(gameBoard, players2, "2"); // called method placePiece
                    printGameBoard(gameBoard);    // called method printGameBoard
                    String result = checkWinner(); // Create String called result
                if (result.length() > 0) // If result length more than 0, then print the result
                {
                    System.out.println(result);
                    break;
                }
                int players1 = getPlayers("Player 1 Enter your placement (1-9): ", scan_position);
                placePiece(gameBoard, players1, "1"); // called method placePiece
                    printGameBoard(gameBoard); // called method printGameBoard

                    result = checkWinner(); // Create String called result
                if (result.length() > 0) // If result length more than 0, then print the result
                {
                    System.out.println(result);
                    break;
                }
            }
        }
    }

    // Method placePiece
    private void placePiece(char[][] gameBoard, int pos, String user)
    {
        char symbol = 'X'; // create symbol 'X'
        switch (user)
        {
            case "player1" -> player1Positions.add(pos);
            case "player2" -> {
                symbol = 'O';
                player2Positions.add(pos);
            }
            case "2" -> player2Positions.add(pos);
            case "1" -> {
                symbol = 'O';
                player1Positions.add(pos);
            }
        }
        switch (pos)
        {
            case 1 -> gameBoard[0][0] = symbol;
            case 2 -> gameBoard[0][2] = symbol;
            case 3 -> gameBoard[0][4] = symbol;
            case 4 -> gameBoard[2][0] = symbol;
            case 5 -> gameBoard[2][2] = symbol;
            case 6 -> gameBoard[2][4] = symbol;
            case 7 -> gameBoard[4][0] = symbol;
            case 8 -> gameBoard[4][2] = symbol;
            case 9 -> gameBoard[4][4] = symbol;
        }
    }
    
    @Override // Method getPlayers
    public int getPlayers(String x, Scanner scan_position) {
        System.out.println(x);
        int players1 = scan_position.nextInt();
        // To check that Does it have symbols already in that position?
        while (player1Positions.contains(players1) || player2Positions.contains(players1) || !(players1 >= 1 && players1 <=9))
        {
            System.out.println("Position Taken! or Invalid Input (Not 1-9)! Enter a correct Position");
            players1 = scan_position.nextInt();
        }

        System.out.println(players1); // print position that players1 that choose
        return players1;
    }

    @Override // Method checkWinner
    public String checkWinner()
    {
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);
        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        List<Integer> cross1 = Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(7, 5, 3);

        List<List> winningConditions = new ArrayList<>();
        winningConditions.add(topRow);
        winningConditions.add(midRow);
        winningConditions.add(botRow);
        winningConditions.add(leftCol);
        winningConditions.add(midCol);
        winningConditions.add(rightCol);
        winningConditions.add(cross1);
        winningConditions.add(cross2);

        for (List l : winningConditions)
        {
            if (player1Positions.containsAll(l))
            {
                return "Congratulations player1 won";
            } else if (player2Positions.containsAll(l))
            {
                return "Congratulations player2 won";
            } else if (player1Positions.size() + player2Positions.size() == 9)
            {
                return "DRAW";
            }
        }
        return "";
    }
}