import java.util.Random;
import java.util.Scanner;
public class TicTacToeUC3 { 

    // UC3: Method to take user input
    public static int getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a slot number (1-9): ");
        int slot = sc.nextInt();
        return slot;
    }

    public static void main(String[] args) {

        // UC1: Create and initialize board
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // UC2: Toss
        Random rand = new Random();
        int toss = rand.nextInt(2); // ONLY ONE TIME

        char player1Symbol, player2Symbol;
        int currentPlayer;

        if (toss == 0) {
            player1Symbol = 'X';
            player2Symbol = 'O';
            currentPlayer = 1;
        } else {
            player1Symbol = 'O';
            player2Symbol = 'X';
            currentPlayer = 2;
        }

        System.out.println("Player 1 Symbol: " + player1Symbol);
        System.out.println("Player 2 Symbol: " + player2Symbol);
        System.out.println("Player " + currentPlayer + " starts first");

        // UC3: Take input
        int slot = getUserInput();
        System.out.println("You selected slot: " + slot);

        // Print board (UC1)
        System.out.println("\nTic-Tac-Toe Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
