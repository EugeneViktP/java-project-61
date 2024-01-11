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
        }
        return "no";
    }
    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        String userName = Cli.greetings();
        System.out.println(Engine.EVEN_RULES);
        int[] numBuffer = Engine.generateIntArray(BOUND_FOR_RANDOM);
        int streak = 0;
        for (var numPlayed : numBuffer) {
            System.out.println("Question: " + numPlayed);
            System.out.print("Your answer: ");
            String answer = scanner.next();
            if (answer.equals(getCorrectAnswer(numPlayed))) {
                System.out.println("Correct!");
                streak++;
            } else {
                Engine.sendWarning(answer, getCorrectAnswer(numPlayed), userName);
                break;
            }
            if (streak == 3) {
                System.out.println("Congratulations, " + userName + "!");
            }
        }
        scanner.close();
    }

}
