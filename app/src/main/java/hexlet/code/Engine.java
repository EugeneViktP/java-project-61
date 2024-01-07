package hexlet.code;

import java.util.Random;

public class Engine {

    public static int maxRounds = 3;
    public static int getRandom(int boundNumber) {
        Random random = new Random();
        return random.nextInt(boundNumber);
    }
    public static void sendWarning(String answer, String correctAnswer, String userName) {
        System.out.print("Answer: '" + answer + "' is wrong answer ;( .");
        System.out.println("Correct Answer is '" + correctAnswer + "'");
        System.out.println("Let's try again, " + userName);
    }



}
