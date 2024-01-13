package hexlet.code.games;
import hexlet.code.Engine;

public class Calc {
    private static final int BOUND_FOR_RANDOM = 10;
    public static final String CALC_RULES = "What is the result of the expression?";
    public static int calcTheResult(int firstNumber, int secondNumber, char operators) {
        return switch (operators) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            default -> throw new IllegalStateException("Unexpected value: " + operators);
        };
    }
    public static void startGame() {
        String[][] gamePar = new String[Engine.MAX_ROUNDS][Engine.NUMBERS_OF_ANSWERS];
        for (var i = 0; i < Engine.MAX_ROUNDS; i++) {
            int firstNum = Engine.getRandom(BOUND_FOR_RANDOM);
            int secondNum = Engine.getRandom(BOUND_FOR_RANDOM);
            char[] operators = {'+', '-', '*'};
            char[] operatorUsed = new char[Engine.MAX_ROUNDS];
            operatorUsed[i] = operators[Engine.getRandom(operators.length)];
            int calcResult = calcTheResult(firstNum, secondNum, operatorUsed[i]);
            String question = (firstNum + " " + operatorUsed[i] + " " + secondNum);
            String correctAnswer = String.valueOf(calcResult);
            gamePar[i][0] = question;
            gamePar[i][1] = correctAnswer;
        }
        Engine.startGame(gamePar, CALC_RULES);

    }
}
