package hexlet.code;

import java.util.Random;

public class Engine {

    public static int maxRounds = 3;
    public static String gcdRules = "Find the greatest common divisor of given numbers";
    public static String evenRules = "Answer 'yes' if the number is even, otherwise answer 'no'";
    public static String calcRules = "What is the result of the expression?";
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