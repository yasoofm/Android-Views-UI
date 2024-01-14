package com.example.androidviewsui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> questionsList = new ArrayList<String>(Arrays.asList("2 + 2 = 4", "1 + 1 = 11", "2 + 3 = 5"));
    private ArrayList<Boolean> answersList = new ArrayList<Boolean>(Arrays.asList(true, false, true));

    private TextView questionText, answerText, scoreText;
    private FrameLayout circle;
    private Drawable greenCircle, redCircle;

    private Button nextButton, trueButton, falseButton;
    private int index = 0;
    private static int score = 0;

    public void initialize(){
        greenCircle = ResourcesCompat.getDrawable(getResources(), R.drawable.green_circle, null);
        redCircle = ResourcesCompat.getDrawable(getResources(), R.drawable.red_circle, null);

        questionText = findViewById(R.id.questionTextView);
        scoreText = findViewById(R.id.scoreText);
        circle = findViewById(R.id.frameLayout);
        answerText = findViewById(R.id.answerText);
        nextButton = findViewById(R.id.nextButton);
        falseButton = findViewById(R.id.falseButton);
        trueButton = findViewById(R.id.trueButton);
    }

    public void correctAnswer(){
        score++;
        scoreText.setText("Score: " + score);
        index++;
        circle.setBackground(greenCircle);
        circle.setVisibility(View.VISIBLE);
        answerText.setVisibility(View.VISIBLE);
        answerText.setText("Correct");
        trueButton.setVisibility(View.INVISIBLE);
        falseButton.setVisibility(View.INVISIBLE);
        nextButton.setVisibility(View.VISIBLE);
    }

    public void incorrectAnswer(){
        circle.setBackground(redCircle);
        circle.setVisibility(View.VISIBLE);
        answerText.setVisibility(View.VISIBLE);
        answerText.setText("Incorrect");
        trueButton.setVisibility(View.INVISIBLE);
        falseButton.setVisibility(View.INVISIBLE);
        nextButton.setText("Try Again");
        nextButton.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        questionText.setText(questionsList.get(index));
        scoreText.setText("Score: " + score);

        falseButton.setOnClickListener(v -> {
            if(!answersList.get(index)){
                correctAnswer();
            } else {
                incorrectAnswer();
            }
        });

        trueButton.setOnClickListener(v ->{
            if(answersList.get(index)){
                correctAnswer();
            } else {
                incorrectAnswer();
            }
        });

        nextButton.setOnClickListener(v -> {
            if(index == answersList.size()){
                index = 0;
                score = 0;
                scoreText.setText("Score: " + score);
                answerText.setVisibility(View.INVISIBLE);
                circle.setVisibility(View.INVISIBLE);
                nextButton.setVisibility(View.INVISIBLE);
                trueButton.setVisibility(View.VISIBLE);
                falseButton.setVisibility(View.VISIBLE);
                questionText.setText(questionsList.get(index));
            } else if (index == answersList.size() - 1) {
                nextButton.setText("Reset");
                answerText.setVisibility(View.INVISIBLE);
                circle.setVisibility(View.INVISIBLE);
                nextButton.setVisibility(View.INVISIBLE);
                trueButton.setVisibility(View.VISIBLE);
                falseButton.setVisibility(View.VISIBLE);
                questionText.setText(questionsList.get(index));
            } else {
                nextButton.setText("Next Question");
                answerText.setVisibility(View.INVISIBLE);
                circle.setVisibility(View.INVISIBLE);
                nextButton.setVisibility(View.INVISIBLE);
                trueButton.setVisibility(View.VISIBLE);
                falseButton.setVisibility(View.VISIBLE);
                questionText.setText(questionsList.get(index));
            }

        });
    }
}