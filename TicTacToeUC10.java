import java.util.Random;
import java.util.Scanner;

public class TicTacToeUC10 {

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    // UC3: Input
    public static int getUserInput() {
        System.out.print("Enter a slot number (1-9): ");
        return sc.nextInt();
    }

    // UC4: Convert
    public static int[] convertSlotToIndex(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    // UC5: Validate
    public static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row <= 2 && col >= 0 && col <= 2 && board[row][col] == '-';
    }

    // UC6: Place move
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC7: Computer move
    public static void computerMove(char[][] board, char symbol) {
        while (true) {
            int slot = rand.nextInt(9) + 1;
            int[] pos = convertSlotToIndex(slot);

            if (isValidMove(board, pos[0], pos[1])) {
                System.out.println("Computer chose slot: " + slot);
                placeMove(board, pos[0], pos[1], symbol);
                break;
            }
        }
    }

    // UC9: Check win
    public static boolean checkWin(char[][] board, char symbol) {

        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }

        if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
            (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }

        return false;
    }

    // UC10: Check draw
    public static boolean isDraw(char[][] board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == '-')
                    return false;

        return true;
    }

    // Print board
    public static void printBoard(char[][] board) {
        System.out.println("\nTic-Tac-Toe Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        // UC1: Initialize
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = '-';

        // UC2: Toss
        char playerSymbol, computerSymbol;
        boolean playerTurn = rand.nextInt(2) == 0;

        if (playerTurn) {
            System.out.println("You start first!");
            playerSymbol = 'X';
            computerSymbol = 'O';
        } else {
            System.out.println("Computer starts first!");
            playerSymbol = 'O';
            computerSymbol = 'X';
        }

        printBoard(board);

        // UC8 Loop + UC10 Draw
        while (true) {

            if (playerTurn) {

                int slot = getUserInput();
                int[] pos = convertSlotToIndex(slot);

                if (isValidMove(board, pos[0], pos[1])) {
                    placeMove(board, pos[0], pos[1], playerSymbol);
                } else {
                    System.out.println("Invalid move! Try again.");
                    continue;
                }

                if (checkWin(board, playerSymbol)) {
                    printBoard(board);
                    System.out.println("You win!");
                    break;
                }

            } else {

                computerMove(board, computerSymbol);

                if (checkWin(board, computerSymbol)) {
                    printBoard(board);
                    System.out.println("Computer wins!");
                    break;
                }
            }

            printBoard(board);

            // UC10: Draw check
            if (isDraw(board)) {
                System.out.println("It's a draw!");
                break;
            }

            // Switch turn
            playerTurn = !playerTurn;
        }
    }
}