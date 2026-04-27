import java.util.Random;
import java.util.Scanner;

public class TicTacToeUC5 {

    static Scanner sc = new Scanner(System.in);

    // UC3: Get user input
    public static int getUserInput() {
        System.out.print("Enter a slot number (1-9): ");
        return sc.nextInt();
    }

    // UC4: Convert slot to row and column
    public static int[] convertSlotToIndex(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    // UC5: Validate move
    public static boolean isValidMove(char[][] board, int row, int col) {

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        // UC1: Initialize board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // UC2: Toss
        Random rand = new Random();
        int toss = rand.nextInt(2);

        char player1Symbol, player2Symbol;
        int currentPlayer;

        if (toss == 0) {
            System.out.println("Player 1 starts first!");
            player1Symbol = 'X';
            player2Symbol = 'O';
            currentPlayer = 1;
        } else {
            System.out.println("Player 2 starts first!");
            player1Symbol = 'O';
            player2Symbol = 'X';
            currentPlayer = 2;
        }

        System.out.println("Player 1 Symbol: " + player1Symbol);
        System.out.println("Player 2 Symbol: " + player2Symbol);

        int row, col;

        // ✅ LOOP until valid move
        while (true) {

            int slot = getUserInput();

            // Validate slot range first
            if (slot < 1 || slot > 9) {
                System.out.println("Invalid slot! Enter between 1-9.");
                continue;
            }

            int[] pos = convertSlotToIndex(slot);
            row = pos[0];
            col = pos[1];

            if (isValidMove(board, row, col)) {
                System.out.println("Valid move!");
                break;
            } else {
                System.out.println("Cell already occupied! Try again.");
            }
        }

        // Place symbol (based on current player)
        if (currentPlayer == 1) {
            board[row][col] = player1Symbol;
        } else {
            board[row][col] = player2Symbol;
        }

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