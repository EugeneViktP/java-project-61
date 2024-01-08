package hexlet.code.games;
import hexlet.code.Cli;
import hexlet.code.Engine;
import java.util.Scanner;

public class GCD {
    private static final int BOUND_FOR_RANDOM = 20;
    public static int gcdEuclids(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdEuclids(n2, n1 % n2);
    }

    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        String userName = Cli.greetings();
        System.out.println(Engine.gcdRules);
        int[] firstNumber = Engine.generateIntArray(BOUND_FOR_RANDOM);
        int[] secondNumber = Engine.generateIntArray(BOUND_FOR_RANDOM);
        int[] correctAnswer = new int[Engine.maxRounds];
        for (int i = 0; i < Engine.maxRounds; i++) {
            correctAnswer[i] = gcdEuclids(firstNumber[i], secondNumber[i]);
        }
        int streak = 0;
        for (var i = 0; i < Engine.maxRounds; i++) {
            System.out.println("Question: " + firstNumber[i] + " " + secondNumber[i]);
            System.out.println("Your answer is: ");
            String answer = scanner.next();
            if (answer.equals(String.valueOf(correctAnswer[i]))) {
                System.out.println("Correct!");
                streak++;
            } else {
                Engine.sendWarning(answer, String.valueOf(correctAnswer[i]), userName);
            }
        }
        if (streak == 3) {
            System.out.println("Congratulations, " + userName + "!");
        }
        scanner.close();


    }
}

