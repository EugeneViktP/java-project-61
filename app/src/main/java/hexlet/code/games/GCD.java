package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    private static final int BOUND_FOR_RANDOM = 20;
    public static final String GCD_RULES = "Find the greatest common divisor of given numbers.";


    public static void startGame() {
        String[][] gamePar = new String[Engine.MAX_ROUNDS][Engine.NUMBERS_OF_ANSWERS];
        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            int firstNum = Utils.getRandom(BOUND_FOR_RANDOM);
            int secondNum = Utils.getRandom(BOUND_FOR_RANDOM);
            int answer = gcdEuclides(firstNum, secondNum);
            String question = firstNum + " " + secondNum;
            String correctAnswer = String.valueOf(answer);
            gamePar[i][0] = question;
            gamePar[i][1] = correctAnswer;
        }
        Engine.startGame(gamePar, GCD_RULES);
    }

    private static int gcdEuclides(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdEuclides(n2, n1 % n2);
    }
}
