import java.util.Random;
import java.util.Scanner;

public class TicTacToeUC7 {

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

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
        return row >= 0 && row <= 2 && col >= 0 && col <= 2 && board[row][col] == '-';
    }

    // UC6: Place move
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC7: Computer random move
    public static void computerMove(char[][] board, char symbol) {
        int slot, row, col;

        while (true) {
            slot = rand.nextInt(9) + 1; // 1–9
            int[] pos = convertSlotToIndex(slot);
            row = pos[0];
            col = pos[1];

            if (isValidMove(board, row, col)) {
                System.out.println("Computer chose slot: " + slot);
                placeMove(board, row, col, symbol);
                break;
            }
        }
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
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = '-';

        // UC2: Toss
        int toss = rand.nextInt(2);

        char playerSymbol, computerSymbol;

        if (toss == 0) {
            System.out.println("You start first!");
            playerSymbol = 'X';
            computerSymbol = 'O';
        } else {
            System.out.println("Computer starts first!");
            playerSymbol = 'O';
            computerSymbol = 'X';
        }

        System.out.println("Your Symbol: " + playerSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);

        printBoard(board);

        // Player move
        int slot = getUserInput();
        int[] pos = convertSlotToIndex(slot);

        if (isValidMove(board, pos[0], pos[1])) {
            placeMove(board, pos[0], pos[1], playerSymbol);
        } else {
            System.out.println("Invalid move!");
        }

        printBoard(board);

        // Computer move
        computerMove(board, computerSymbol);

        printBoard(board);
    }
}