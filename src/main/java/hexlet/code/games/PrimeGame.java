package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class PrimeGame {
    private static final int MAX_QUESTIONS = 3;
    private static final int MAX_NUMBER = 100;

    public static void startGame() {
        Engine.playGame("Answer 'yes' if given number is prime. Otherwise answer 'no'.", MAX_QUESTIONS, PrimeGame::generateQuestionAndAnswer);
    }

    private static String generateQuestionAndAnswer() {
        Random random = new Random();
        int number = random.nextInt(MAX_NUMBER) + 1;

        String question = String.valueOf(number);
        String answer = isPrime(number) ? "yes" : "no";
        return question + "\n" + answer;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
