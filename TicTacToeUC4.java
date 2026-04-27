import java.util.Random;
import java.util.Scanner;

public class TicTacToeUC4 {

    // UC3: Input method
    public static int getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a slot number (1-9): ");
        return sc.nextInt();
    }

    // UC4: Convert slot to row & column
    public static void convertSlot(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;

        System.out.println("Row index: " + row);
        System.out.println("Column index: " + col);
    }

    public static void main(String[] args) {

        // UC1: Board creation
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // UC2: Toss
        Random rand = new Random();
        int toss = rand.nextInt(2);

        if (toss == 0) {
            System.out.println("Player 1 starts first!");
        } else {
            System.out.println("Player 2 starts first!");
        }

        // UC3: Take input
        int slot = getUserInput();

        // UC4: Convert
        convertSlot(slot);

        // Display board
        System.out.println("\nTic-Tac-Toe Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}