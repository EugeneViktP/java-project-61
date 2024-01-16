package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static final String PROGRESSION_RULES = "What number is missing in the progression?";
    private static final int MIN_BOUNDARY_MINNUM = 2;
    private static final int MAX_BOUNDARY_MINNUM = 7;
    private static final int MIN_BOUNDARY_LENGTH = 10;
    private static final int MAX_BOUNDARY_LENGTH = 15;
    private static final int MIN_BOUNDARY_STEP = 2;
    private static final int MAX_BOUNDARY_STEP = 8;

    public static void startGame() {
        String[][] gamePar = new String[Engine.MAX_ROUNDS][Engine.NUMBERS_OF_ANSWERS];

        for (var i = 0; i < Engine.MAX_ROUNDS; i++) {
            int minNum = Utils.getRandom(MIN_BOUNDARY_MINNUM, MAX_BOUNDARY_MINNUM);
            int length = Utils.getRandom(MIN_BOUNDARY_LENGTH, MAX_BOUNDARY_LENGTH);
            int step = Utils.getRandom(MIN_BOUNDARY_STEP, MAX_BOUNDARY_STEP);
            int[] progressionPlayed = generateProgression(minNum, length, step);
            int hiddenNum = Utils.getRandom(MIN_BOUNDARY_LENGTH);
            String question = printProgression(progressionPlayed, hiddenNum);
            int answer = progressionPlayed[hiddenNum];
            String correctAnswer = String.valueOf(answer);
            gamePar[i][0] = question;
            gamePar[i][1] = correctAnswer;
        }
        Engine.startGame(gamePar, PROGRESSION_RULES);
    }

    private static int[] generateProgression(int minNum, int length, int step) {
        int[] result = new int[length];
        for (var i = 0; i < result.length; i++) {
            result[i] = minNum + step * i;
        }
        return result;
    }

    private static String printProgression(int[] progression, int numHidden) {
        StringBuilder result = new StringBuilder();
        for (var i = 0; i < progression.length; i++) {
            if (i == numHidden) {
                result.append(".. ");
            } else {
                result.append(progression[i]);
                result.append(" ");
            }
        }
        return result.toString();
    }
}
