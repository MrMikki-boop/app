package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class ProgressionGame {
    private static final int MAX_QUESTIONS = 3;
    private static final int PROGRESSION_LENGTH_MIN = 5;
    private static final int PROGRESSION_LENGTH_MAX = 10;
    private static final int PROGRESSION_MIN_STEP = 1;
    private static final int PROGRESSION_MAX_STEP = 10;
    private static final int PROGRESSION_HIDDEN_INDEX_MIN = 0;
    private static final int PROGRESSION_HIDDEN_INDEX_MAX = PROGRESSION_LENGTH_MAX - 1;

    public static void startGame() {
        Engine.playGame("What number is missing in the progression?", MAX_QUESTIONS, ProgressionGame::generateQuestionAndAnswer);
    }

    private static String generateQuestionAndAnswer() {
        Random random = new Random();
        int progressionLength = random.nextInt(PROGRESSION_LENGTH_MAX - PROGRESSION_LENGTH_MIN + 1) + PROGRESSION_LENGTH_MIN;
        int progressionStep = random.nextInt(PROGRESSION_MAX_STEP - PROGRESSION_MIN_STEP + 1) + PROGRESSION_MIN_STEP;
        int hiddenIndex = random.nextInt(PROGRESSION_HIDDEN_INDEX_MAX - PROGRESSION_HIDDEN_INDEX_MIN + 1) + PROGRESSION_HIDDEN_INDEX_MIN;

        int[] progression = generateProgression(progressionLength, progressionStep);
        String question = formatProgression(progression, hiddenIndex);
        String answer = String.valueOf(progression[hiddenIndex]);
        return question + "\n" + answer;
    }

    private static int[] generateProgression(int length, int step) {
        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = i * step;
        }
        return progression;
    }

    private static String formatProgression(int[] progression, int hiddenIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i == hiddenIndex) {
                sb.append(".. ");
            } else {
                sb.append(progression[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
