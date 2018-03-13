package com.example.rhenigan.quizapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by henig on 3/12/2018.
 * ------------------------------
 */

class QuestionLogic {

    private Random random = new Random();
    private static int correctAnswer = 0;
    private static List<Integer> ansArray = new ArrayList<>();

    String setProblem() {
        ansArray.clear();
        int leftAdder = random.nextInt(100) + 1;
        int rightAdder = random.nextInt(100) + 1;

        correctAnswer = leftAdder + rightAdder;

        int firstIncorrectAnswer = random.nextInt(200) + 1;
        int secondIncorrectAnswer = random.nextInt(200) + 1;

        if (firstIncorrectAnswer == correctAnswer) {
            firstIncorrectAnswer = firstIncorrectAnswer + random.nextInt(50) + 1;
        }
        if (secondIncorrectAnswer == correctAnswer) {
            secondIncorrectAnswer = secondIncorrectAnswer + random.nextInt(50) + 1;
        }
        if (firstIncorrectAnswer == secondIncorrectAnswer) {
            firstIncorrectAnswer = firstIncorrectAnswer + random.nextInt(50) + 1;
        }

        ansArray.add(correctAnswer);
        ansArray.add(firstIncorrectAnswer);
        ansArray.add(secondIncorrectAnswer);

        Collections.sort(ansArray);

        return leftAdder + " + " + rightAdder + " = ?";
    }

    boolean isCorrect(int num) {
        return correctAnswer == num;
    }

    List<Integer> getAnsArray() {
        return ansArray;
    }
}
