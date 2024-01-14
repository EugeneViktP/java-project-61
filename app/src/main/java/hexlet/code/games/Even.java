package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final int BOUND_FOR_RANDOM = 100;
    public static final String EVEN_RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";


    public static void startGame() {
        String[][] gamePar = new String[Engine.MAX_ROUNDS][Engine.NUMBERS_OF_ANSWERS];
        for (var i = 0; i < Engine.MAX_ROUNDS; i++) {
            int numBuffer = Utils.getRandom(BOUND_FOR_RANDOM);
            String correctAnswer = numberIsEven(numBuffer) ? "yes" : "no";
            gamePar[i][0] = String.valueOf(numBuffer);
            gamePar[i][1] = correctAnswer;
        }
        Engine.startGame(gamePar, EVEN_RULES);
    }

    private static boolean numberIsEven(int numberToCheck) {

        return (numberToCheck % 2 == 0);
    }
}
