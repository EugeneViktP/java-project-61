package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class Progression {
    private static final int MIN_BOUNDARY_MINNUM = 2;
    private static final int MAX_BOUNDARY_MINNUM = 7;
    private static final int MIN_BOUNDARY_LENGTH = 10;
    private static final int MAX_BOUNDARY_LENGTH = 15;
    private static final int MIN_BOUNDARY_STEP = 2;
    private static final int MAX_BOUNDARY_STEP = 8;
    public static int[] generateProgression() {
        int minNum = Engine.getRandom(MIN_BOUNDARY_MINNUM, MAX_BOUNDARY_MINNUM);
        int length = Engine.getRandom(MIN_BOUNDARY_LENGTH, MAX_BOUNDARY_LENGTH);
        int step = Engine.getRandom(MIN_BOUNDARY_STEP, MAX_BOUNDARY_STEP);
        int[] result = new int[length];

        for (var i = 0; i < result.length; i++) {
            result[i] = minNum;
            minNum = minNum + step;
        }
        return result;
    }
    public static String printProgression(int[] progression, int numHidden) {
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
    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        String userName = Cli.greetings();
        System.out.println(Engine.PROGRESSION_RULLES);
        int streak = 0;
        for (var i = 0; i < Engine.MAX_ROUNDS; i++) {
            int[] progressionPlayed = generateProgression();
            int hiddenNum = Engine.getRandom(10);
            System.out.println("Question: " + printProgression(progressionPlayed, hiddenNum));
            System.out.print("Your answer: ");
            String answer = scanner.next();
            if (answer.equals(String.valueOf(progressionPlayed[hiddenNum]))) {
                System.out.println("Correct!");
                streak++;
            } else {
                Engine.sendWarning(answer, String.valueOf(progressionPlayed[hiddenNum]), userName);
                break;
            }
            if (streak == Engine.MAX_ROUNDS) {
                System.out.println("Congratulations, " + userName + "!");
            }
        }
        scanner.close();
    }
}
