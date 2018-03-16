package com.example.rhenigan.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private QuestionLogic mLogic = new QuestionLogic();

    private TextView mQuestion;
    private RadioGroup mAnswers;
    private RadioButton mAns1;
    private RadioButton mAns2;
    private RadioButton mAns3;
    private int answerChecked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestion = findViewById(R.id.question);
        mAnswers = findViewById(R.id.answers);
        mAns1 = findViewById(R.id.answer1);
        mAns2 = findViewById(R.id.answer2);
        mAns3 = findViewById(R.id.answer3);
        Button mSubmit = findViewById(R.id.submit);

        newProblem();

        mAnswers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                Log.d(TAG, "radiogroup clicked");

                switch (checkedId) {
                    case R.id.answer1:
                        answerChecked = 1;
                        break;
                    case R.id.answer2:
                        answerChecked = 2;
                        break;
                    case R.id.answer3:
                        answerChecked = 3;
                        break;
                }
                Log.d(TAG, "answer " + answerChecked + " selected");
            }
        });

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean ans;
                switch (answerChecked) {
                    case 1:
                        ans = mLogic.isCorrect(mLogic.getAnsArray().get(0));
                        result(ans);
                        break;
                    case 2:
                        ans = mLogic.isCorrect(mLogic.getAnsArray().get(1));
                        result(ans);
                        break;
                    case 3:
                        ans = mLogic.isCorrect(mLogic.getAnsArray().get(2));
                        result(ans);
                        break;
                    default:
                        break;
                }
                mAnswers.clearCheck();
                answerChecked = 0;
            }
        });
    }

    private void result(boolean ans) {
        if(ans) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }

        newProblem();
    }

    private void newProblem() {
        mQuestion.setText(mLogic.setProblem());

        mAns1.setText(mLogic.getAnsArray().get(0) + "");
        mAns2.setText(mLogic.getAnsArray().get(1) + "");
        mAns3.setText(mLogic.getAnsArray().get(2) + "");
    }
}

