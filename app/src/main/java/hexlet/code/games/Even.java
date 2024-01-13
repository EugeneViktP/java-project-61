package hexlet.code.games;
import hexlet.code.Engine;

public class Even {
    private static final int BOUND_FOR_RANDOM = 100;
    public static final String EVEN_RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static boolean numberIsEven(int numberToCheck) {

        return (numberToCheck % 2 == 0);
    }

    public static String getCorrectAnswer(int number) {
        if (numberIsEven(number)) {
            return "yes";
        }
        return "no";
    }
    public static void startGame() {
        String[][] gamePar = new String[Engine.MAX_ROUNDS][Engine.NUMBERS_OF_ANSWERS];
        for (var i = 0; i < Engine.MAX_ROUNDS; i++) {
            int numBuffer = Engine.getRandom(BOUND_FOR_RANDOM);
            String correctAnswer = getCorrectAnswer(numBuffer);
            gamePar[i][0] = String.valueOf(numBuffer);
            gamePar[i][1] = correctAnswer;
        }
        Engine.startGame(gamePar, EVEN_RULES);
    }

}
