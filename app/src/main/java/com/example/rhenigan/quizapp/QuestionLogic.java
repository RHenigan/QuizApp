package com.example.rhenigan.quizapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by henig on 3/12/2018.
 */

public class QuestionLogic {

    private Random random = new Random();
    private static int leftAdder = 0;
    private static int rightAdder = 0;
    private static int correctAnswer = 0;
    private static int firstIncorrectAnswer = 0;
    private static int secondIncorrectAnswer = 0;
    private static List<Integer> ansArray = new ArrayList<>();

    public String setProblem() {
        ansArray.clear();
        leftAdder = random.nextInt(100) + 1;
        rightAdder = random.nextInt(100) + 1;

        correctAnswer = leftAdder + rightAdder;

        firstIncorrectAnswer = random.nextInt(200) + 1;
        secondIncorrectAnswer = random.nextInt(200) + 1;

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

    public boolean isCorrect(int num) {
        return correctAnswer == num;
    }

    public List<Integer> getAnsArray() {
        return ansArray;
    }
}
