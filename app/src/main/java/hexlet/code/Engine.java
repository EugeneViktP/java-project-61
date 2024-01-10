package hexlet.code;

import java.util.Random;

public class Engine {

    public static int maxRounds = 3;
    public static String gcdRules = "Find the greatest common divisor of given numbers";
    public static String evenRules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static String calcRules = "What is the result of the expression?";
    public static String progressionRules = "What number is missing in the progression?";
    public static String primeRules = "Answer 'yes' if given number is prime. Otherwise answer 'no'";
    public static int getRandom(int boundNumber) {
        Random random = new Random();
        return random.nextInt(boundNumber);
    }
    public static int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    public static void sendWarning(String answer, String correctAnswer, String userName) {
        System.out.print("Answer: '" + answer + "' is wrong answer ;( .");
        System.out.println("Correct Answer is '" + correctAnswer + "'");
        System.out.println("Let's try again, " + userName);
    }
    public static int[] generateIntArray(int boundForRandom) {
        int[] numberBuffer = new int[Engine.maxRounds];
        for (int i = 0; i < Engine.maxRounds; i++) {
            numberBuffer[i] = Engine.getRandom(boundForRandom);
        }
        return numberBuffer;
    }




}