package hexlet.code;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Greet;
import hexlet.code.games.Progression;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("Please enter the game number and press Enter");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("0 - Exit");
        Scanner scanner = new Scanner(System.in);
        int gameNumber = scanner.nextInt();
        switch (gameNumber) {
            case 0 -> System.out.println("Exit");
            case 1 -> Greet.startGame();
            case 2 -> Even.startGame();
            case 3 -> Calc.startGame();
            case 4 -> GCD.startGame();
            case 5 -> Progression.startGame();
            default -> System.out.println("Wrong number");
        }
        scanner.close();
    }
}
