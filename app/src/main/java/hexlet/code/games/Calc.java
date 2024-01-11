package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class Calc {
    private static final int BOUND_FOR_RANDOM = 10;
    public static int calcTheResult(int firstNumber, int secondNumber, char operators) {
        return switch (operators) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            default -> throw new IllegalStateException("Unexpected value: " + operators);
        };
    }
    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        String userName = Cli.greetings();
        System.out.println(Engine.CALC_RULES);
        int[] firstNum = Engine.generateIntArray(BOUND_FOR_RANDOM);
        int[] secondNum = Engine.generateIntArray(BOUND_FOR_RANDOM);
        char[] operators = {'+', '-', '*'};
        char[] operatorUsed = new char[Engine.MAX_ROUNDS];
        int[] correctAnswer = new int[Engine.MAX_ROUNDS];
        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            operatorUsed[i] = operators[Engine.getRandom(operators.length)];
            correctAnswer[i] = calcTheResult(firstNum[i], secondNum[i], operatorUsed[i]);
        }
        int streak = 0;
        for (var i = 0; i < Engine.MAX_ROUNDS; i++) {
            System.out.println("Question: " + firstNum[i] + operatorUsed[i] + secondNum[i]);
            System.out.println("Your answer: ");
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
