public class TicTacToeUC1 {
    public static void main(String[] args) {

        int size = 3;
        char[][] board = new char[size][size];

        // Initialize board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }

        // Print board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}