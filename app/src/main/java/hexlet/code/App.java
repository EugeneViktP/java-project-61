package hexlet.code;
import java.util.Scanner;
// import java.util.Random;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("Please enter the game number and press Enter");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        Scanner scanner = new Scanner(System.in);
        int gameNumber = scanner.nextInt();
        switch (gameNumber) {
            case 0:
                System.out.println("Exit");
                break;
            case 1:
                Greet.startGame();
                break;
            case 2:
                Even.startGame();
                break;

            default:
                break;
        }
        scanner.close();
    }
}
