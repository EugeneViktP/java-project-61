package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final int BOUND_FOR_RANDOM = 100;
    public static final String PRIME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGame() {
        String[][] gamePar = new String[Engine.MAX_ROUNDS][Engine.NUMBERS_OF_ANSWERS];
        for (var i = 0; i < Engine.MAX_ROUNDS; i++) {
            int numBuffer = Utils.getRandom(BOUND_FOR_RANDOM);
            String question = String.valueOf(numBuffer);
            String correctAnswer = isPrime(numBuffer) ? "yes" : "no";
            gamePar[i][0] = question;
            gamePar[i][1] = correctAnswer;
        }
        Engine.startGame(gamePar, PRIME_RULES);
    }

    private static boolean isPrime(int number) {
        if (number <= 2) {
            return false;
        } else {
            for (var i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
