import java.util.Random;

public class TicTacToeUC2 {
    public static void main(String[] args) {

        Random random = new Random();
        int toss = random.nextInt(2);

        char userSymbol;
        char computerSymbol;
        String currentPlayer;

        if (toss == 0) {
            userSymbol = 'X';
            computerSymbol = 'O';
            currentPlayer = "User";
        } else {
            userSymbol = 'O';
            computerSymbol = 'X';
            currentPlayer = "Computer";
        }

        System.out.println("Toss Result: " + toss);
        System.out.println("User Symbol: " + userSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
        System.out.println("First Turn: " + currentPlayer);
    }
}
