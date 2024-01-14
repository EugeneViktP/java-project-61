package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int MAX_ROUNDS = 3;
    public static final int NUMBERS_OF_ANSWERS = 2;

    public static void startGame(String[][] gamePar, String rules) {
        Scanner scanner = new Scanner(System.in);
        String userName = Cli.greetings();
        System.out.println(rules);
        for (var i = 0; i < MAX_ROUNDS; i++) {
            System.out.println("Question: " + gamePar[i][0]);
            System.out.print("Your answer: ");
            String answer = scanner.next();
            if (answer.equals(gamePar[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.print("'" + answer + "' is wrong answer ;(. ");
                System.out.println("Correct answer was '" + gamePar[i][1] + "'");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
            System.out.println("Congratulations, " + userName + "!");
        }
        scanner.close();
    }
}
