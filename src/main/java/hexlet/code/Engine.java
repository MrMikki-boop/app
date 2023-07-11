package hexlet.code;

import java.util.Scanner;
import java.util.function.Supplier;

import hexlet.code.Cli;

public class Engine {
    private static final int MAX_ATTEMPTS = 3;

    public static void playGame(String question, int maxQuestions, Supplier<String> questionAndAnswerSupplier) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");


        System.out.println(question);

        for (int i = 0; i < maxQuestions; i++) {
            String questionAndAnswer = questionAndAnswerSupplier.get();
            String[] parts = questionAndAnswer.split("\n");
            String questionText = parts[0];
            String correctAnswer = parts[1];

            System.out.println("Question: " + questionText);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + name + "!");
    }
}
