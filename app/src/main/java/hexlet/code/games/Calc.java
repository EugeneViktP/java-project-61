package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class Calc {
    public static int calcTheResult(int firstNumber, int secondNumber, char operators) {
        return switch (operators) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            default -> throw new IllegalStateException("Unexpected value: " + operators);
        };
    }
    public static void startGame() {
        String ruleCalc = "What is the result of the expression?";
        Scanner scanner = new Scanner(System.in);
        String userName = Cli.greetings();
        System.out.println(ruleCalc);
        int[] firstNumber = new int[Engine.maxRounds];
        int[] secondNumber = new int[Engine.maxRounds];
        char[] operators = {'+', '-', '*'};
        char[] operatorUsed = new char[Engine.maxRounds];
        int[] correctAnswer = new int[Engine.maxRounds];
        for (int i = 0; i < Engine.maxRounds; i++) {
            firstNumber[i] = Engine.getRandom(10);
            secondNumber[i] = Engine.getRandom(10);
            operatorUsed[i] = operators[Engine.getRandom(3)];
            correctAnswer[i] = calcTheResult(firstNumber[i], secondNumber[i], operatorUsed[i]);
        }
        int strake = 0;
        for (var i = 0; i < Engine.maxRounds; i++) {
            System.out.println("Question: " + firstNumber[i] + operatorUsed[i] + secondNumber[i]);
            System.out.println("Your answer is: ");
            String answer = scanner.next();
            if (answer.equals(String.valueOf(calcTheResult(firstNumber[i], secondNumber[i], operatorUsed[i])))) {
                System.out.println("Correct!");
                strake++;
            } else {
                Engine.sendWarning(answer, String.valueOf(correctAnswer[i]), userName);
            }
        }
        if (strake == 3) {
            System.out.println("Congratulations, " + userName + "!");
        }
        scanner.close();
    }
}
