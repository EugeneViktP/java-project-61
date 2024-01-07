package hexlet.code.games;
import hexlet.code.Cli;
import hexlet.code.Engine;
import java.util.Scanner;

public class Even {
    private static final int BOUND_FOR_RANDOM = 100;
    public static boolean numberIsEven(int numberToCheck) {
        return (numberToCheck % 2 == 0);
    }
    public static String getCorrectAnswer(int number) {
        if (numberIsEven(number)) {
            return "yes";
        } else {
            return "no";
        }
    }
    public static void startGame() {
        String ruleEven = "Answer 'yes' if the number is even, otherwise answer 'no'";
        Scanner scanner = new Scanner(System.in);
        String userName = Cli.greetings();
        System.out.println(ruleEven);
        int[] numberBuffer = new int[Engine.maxRounds];
        for (int i = 0; i < Engine.maxRounds; i++) {
            numberBuffer[i] = Engine.getRandom(BOUND_FOR_RANDOM);
        }
        int strake = 0;
        for (var numberPlayed : numberBuffer) {
            System.out.println("Number is: " + numberPlayed);
            System.out.println("Your answer is: ");
            String answer = scanner.next();
            if (answer.equals(getCorrectAnswer(numberPlayed))) {
                System.out.println("Correct!");
                strake++;
            } else {
                Engine.sendWarning(answer, getCorrectAnswer(numberPlayed), userName);
            }
        }
        if (strake == 3) {
            System.out.println("Congratulations, " + userName + "!");
        }
        scanner.close();
    }

}
