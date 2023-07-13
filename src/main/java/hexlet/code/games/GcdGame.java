package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class GcdGame {
    private static final int MAX_QUESTIONS = 3;
    private static final int MAX_NUMBER = 100;

    public static void startGame() {
        Engine.playGame("Find the greatest common divisor of given numbers.", MAX_QUESTIONS, GcdGame::generateQuestionAndAnswer);
    }

    private static String generateQuestionAndAnswer() {
        Random random = new Random();
        int number1 = random.nextInt(MAX_NUMBER) + 1;
        int number2 = random.nextInt(MAX_NUMBER) + 1;

        String question = number1 + " " + number2;
        String answer = String.valueOf(calculateGcd(number1, number2));
        return question + "\n" + answer;
    }

    private static int calculateGcd(int number1, int number2) {
        while (number2 != 0) {
            int temp = number1 % number2;
            number1 = number2;
            number2 = temp;
        }
        return Math.abs(number1);
    }
}
