public class TicTacToeUC9 {

    // UC9: Check winning condition
    public static boolean checkWin(char[][] board, char symbol) {

        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
            (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        // Demo board (test case)
        char[][] board = {
            {'X', 'X', 'X'},
            {'-', 'O', '-'},
            {'O', '-', '-'}
        };

        char symbol = 'X';

        if (checkWin(board, symbol)) {
            System.out.println(symbol + " wins!");
        } else {
            System.out.println("No win yet.");
        }
    }
}