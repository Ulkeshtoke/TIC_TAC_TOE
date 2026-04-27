import java.util.Scanner;

public class TicTacToeUC3 {

    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a slot number (1-9): ");
        int slot = scanner.nextInt();

        return slot;
    }

    public static void main(String[] args) {
        int userSlot = getUserInput();
        System.out.println("User selected slot: " + userSlot);
    }
}