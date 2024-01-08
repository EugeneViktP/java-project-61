package hexlet.code;
import hexlet.code.games.Even;
import hexlet.code.games.Greet;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("Please enter the game number and press Enter");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
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
            case 3:
                Calc.startGame();
                break;
            case 4:
                GCD.startGame();
                break;
            default:
                break;
        }
        scanner.close();
    }
}
