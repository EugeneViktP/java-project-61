package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class Prime {
    private static final int BOUND_FOR_RANDOM = 100;
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        } else {
            for (var i = 2; i < number; i++) {
                if (number % i == 0) {
                    return  false;
                }
            }
            return true;
        }
    }
    public static String getCorrectAnswer(int number) {
        if (isPrime(number)) {
            return "yes";
        }
        return "no";
    }
    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        String userName = Cli.greetings();
        System.out.println(Engine.PRIME_RULES);
        int[] numBuffer = Engine.generateIntArray(BOUND_FOR_RANDOM);
        int streak = 0;
        for (var numPlayed : numBuffer) {
            System.out.println("Question: " + numPlayed);
            System.out.println("Your answer: ");
            String answer = scanner.next();
            if (answer.equals(getCorrectAnswer(numPlayed))) {
                System.out.println("Correct!");
                streak++;
            } else {
                Engine.sendWarning(answer, getCorrectAnswer(numPlayed), userName);
            }
        }
        if (streak == 3) {
            System.out.println("Congratulations, " + userName + "!");
        }
        scanner.close();
    }
}
