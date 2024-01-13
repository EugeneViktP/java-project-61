package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final int MAX_ROUNDS = 3;
    public static final int NUMBERS_OF_ANSWERS = 2;


    public static final String PROGRESSION_RULLES = "What number is missing in the progression?";
    public static final String PRIME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static int getRandom(int boundNumber) {
        Random random = new Random();
        return random.nextInt(boundNumber);
    }
    public static int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    public static void sendWarning(String answer, String correctAnswer, String userName) {
        System.out.print("'" + answer + "' is wrong answer ;(. ");
        System.out.println("Correct answer was '" + correctAnswer + "'");
        System.out.println("Let's try again, " + userName + "!");
    }
    public static int[] generateIntArray(int boundForRandom) {
        int[] numberBuffer = new int[Engine.MAX_ROUNDS];
        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            numberBuffer[i] = Engine.getRandom(boundForRandom);
        }
        return numberBuffer;
    }
    public static void startGame(String[][] gamePar, String rules) {
        String userName = Cli.greetings();
        System.out.println(rules);
        for (var i = 0; i < MAX_ROUNDS; i++) {
            System.out.println("Question: " + gamePar[i][0]);
            System.out.print("Your answer: ");
            String answer = SCANNER.next();
            if (answer.equals(gamePar[i][1])) {
                System.out.println("Correct!");
            } else {
                Engine.sendWarning(answer, gamePar[i][1], userName);
                break;
            }
            System.out.println("Congratulations, " + userName + "!");
        }
        SCANNER.close();
    }

}
