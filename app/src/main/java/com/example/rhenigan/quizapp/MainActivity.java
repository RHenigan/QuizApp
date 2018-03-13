package com.example.rhenigan.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private QuestionLogic mLogic = new QuestionLogic();

    private TextView mQuestion;
    private Button mAns1;
    private Button mAns2;
    private Button mAns3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestion = findViewById(R.id.question);
        mAns1 = findViewById(R.id.answer1);
        mAns2 = findViewById(R.id.answer2);
        mAns3 = findViewById(R.id.answer3);
        Button mSubmit = findViewById(R.id.submit);

        newProblem();

        mAns1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAns1.setActivated(true);
                mAns2.setActivated(false);
                mAns3.setActivated(false);
            }
        });

        mAns2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAns1.setActivated(false);
                mAns2.setActivated(true);
                mAns3.setActivated(false);
            }
        });

        mAns3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAns1.setActivated(false);
                mAns2.setActivated(false);
                mAns3.setActivated(true);
            }
        });

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean ans;
                if (mAns1.isActivated()) {
                    ans = mLogic.isCorrect(mLogic.getAnsArray().get(0));
                    result(ans);
                } else if(mAns2.isActivated()) {
                    ans = mLogic.isCorrect(mLogic.getAnsArray().get(1));
                    result(ans);
                } else if(mAns3.isActivated()) {
                    ans = mLogic.isCorrect(mLogic.getAnsArray().get(2));
                    result(ans);
                }
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

