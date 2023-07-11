package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class CalcGame {
    private static final int MAX_QUESTIONS = 3;
    private static final int MAX_NUMBER = 20;
    private static final char[] OPERATIONS = {'+', '-', '*'};

    public static void startGame() {
        Engine.playGame("What is the result of the expression?", MAX_QUESTIONS, CalcGame::generateQuestionAndAnswer);
    }

    private static String generateQuestionAndAnswer() {
        Random random = new Random();
        int number1 = random.nextInt(MAX_NUMBER) + 1;
        int number2 = random.nextInt(MAX_NUMBER) + 1;
        char operation = OPERATIONS[random.nextInt(OPERATIONS.length)];

        int result;
        switch (operation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            default:
                throw new IllegalStateException("Invalid operation: " + operation);
        }

        String question = number1 + " " + operation + " " + number2;
        String answer = String.valueOf(result);
        return question + "\n" + answer;
    }
}
