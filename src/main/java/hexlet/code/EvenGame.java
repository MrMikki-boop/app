package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
    private static final int MAX_ATTEMPTS = 3;

    public static void play() {


        Scanner scanner = new Scanner(System.in);
        String playerName = Cli.greetUser();
        int correctAnswers = 0;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        while (correctAnswers < MAX_ATTEMPTS) {
            int number = generateRandomNumber();
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (isEven(number) && userAnswer.equalsIgnoreCase("yes")
                    || !isEven(number) && userAnswer.equalsIgnoreCase("no")) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + getCorrectAnswer(number) + "'.");
                System.out.println("Let's try again, " + playerName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + playerName + "!");
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1; // Генерация случайного числа от 1 до 100
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static String getCorrectAnswer(int number) {
        return isEven(number) ? "yes" : "no";
    }
}
