package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static final int BOUND_FOR_RANDOM = 10;
    public static final String CALC_RULES = "What is the result of the expression?";

    public static void startGame() {
        String[][] gamePar = new String[Engine.MAX_ROUNDS][Engine.NUMBERS_OF_ANSWERS];
        for (var i = 0; i < Engine.MAX_ROUNDS; i++) {
            int firstNum = Utils.getRandom(BOUND_FOR_RANDOM);
            int secondNum = Utils.getRandom(BOUND_FOR_RANDOM);
            char[] operators = {'+', '-', '*'};
            char operatorUsed = operators[Utils.getRandom(operators.length)];
            int calcResult = calcTheResult(firstNum, secondNum, operatorUsed);
            String question = (firstNum + " " + operatorUsed + " " + secondNum);
            String correctAnswer = String.valueOf(calcResult);
            gamePar[i][0] = question;
            gamePar[i][1] = correctAnswer;
        }
        Engine.startGame(gamePar, CALC_RULES);
    }

    private static int calcTheResult(int firstNumber, int secondNumber, char operators) {
        return switch (operators) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            default -> throw new IllegalStateException("Unexpected value: " + operators);
        };
    }
}
