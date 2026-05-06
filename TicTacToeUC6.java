import java.util.Random;
import java.util.Scanner;

public class TicTacToeUC6 {

    // UC3: Get user input
    public static int getUserInput() {
        Scanner sc = new Scanner(System.in);
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

    // UC6: Place move
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Print board
    public static void printBoard(char[][] board) {
        System.out.println("\nTic-Tac-Toe Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
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

        // UC3: Input
        int slot = getUserInput();

        // UC4: Convert
        int[] pos = convertSlotToIndex(slot);
        int row = pos[0];
        int col = pos[1];

        // UC5: Validate
        if (isValidMove(board, row, col)) {
            System.out.println("Valid move!");

            // UC6: Place move
            char symbol = (currentPlayer == 1) ? player1Symbol : player2Symbol;
            placeMove(board, row, col, symbol);

        } else {
            System.out.println("Invalid move! Try again.");
        }

        // Final board
        printBoard(board);
    }
}