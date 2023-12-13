package hexlet.code;
import java.util.Random;
import java.util.Scanner;

public class Even {
    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("May i have your name?" + " ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'");
        for (var i = 0; i < 3;) {
            Random random = new Random();
            int randomNumber = random.nextInt(100);
            System.out.println("Number is: " + randomNumber);
            System.out.println("Your answer is: ");
            String answer = scanner.next();
            if (randomNumber % 2 == 0) {
                String correctAnswer = "yes";
                if (answer.equals("yes")) {
                    System.out.println("Correct!");
                    i++;
                } else {
                    System.out.print("Answer: '" + answer + "' is wrong answer ;( .");
                    System.out.println("Correct Answer is '" + correctAnswer + "'");
                    i = 0;
                    System.out.println("Let's try again, " + userName);
                }
            }
            if (randomNumber % 2 != 0) {
                String correctAnswer = "no";
                if (answer.equals("no")) {
                    System.out.println("Correct!");
                    i++;
                } else {
                    System.out.print("Answer: '" + answer + "' is wrong answer ;( .");
                    System.out.println("Correct Answer is '" + correctAnswer + "'");
                    i = 0;
                    System.out.println("Let's try again, " + userName);
                }
            }

        }
        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }
}
