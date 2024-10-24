public class GameBoard {

    public void gameBoard() {
        char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' }, // Create Basic gameBoard 9x9
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' } };
        printGameBoard(gameBoard); // Called Method printGameBoard put gameBoard as an argument
    }

    // Method printGameBoard
    public void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}