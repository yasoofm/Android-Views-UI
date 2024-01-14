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
    ArrayList<String> questionsList = new ArrayList<String>(Arrays.asList("2 + 2 = 4", "1 + 1 = 11", "2 + 3 = 5"));
    ArrayList<Boolean> answersList = new ArrayList<Boolean>(Arrays.asList(true, false, true));

    TextView questionText, answerText, scoreText;
    FrameLayout circle;
    Drawable greenCircle;
    Drawable redCircle;

    Button nextButton, trueButton, falseButton;
    int index = 0;
    static int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greenCircle = ResourcesCompat.getDrawable(getResources(), R.drawable.green_circle, null);
        redCircle = ResourcesCompat.getDrawable(getResources(), R.drawable.red_circle, null);

        questionText = findViewById(R.id.questionTextView);
        questionText.setText(questionsList.get(index));

        scoreText = findViewById(R.id.scoreText);
        scoreText.setText("Score: " + score);

        circle = findViewById(R.id.frameLayout);
        answerText = findViewById(R.id.answerText);
        nextButton = findViewById(R.id.nextButton);
        falseButton = findViewById(R.id.falseButton);
        trueButton = findViewById(R.id.trueButton);

        falseButton.setOnClickListener(v -> {
            if(answersList.get(index) == false){
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
            } else {
                circle.setBackground(redCircle);
                circle.setVisibility(View.VISIBLE);
                answerText.setVisibility(View.VISIBLE);
                answerText.setText("Incorrect");
                trueButton.setVisibility(View.INVISIBLE);
                falseButton.setVisibility(View.INVISIBLE);
                nextButton.setVisibility(View.VISIBLE);
            }
        });

        trueButton.setOnClickListener(v ->{
            if(answersList.get(index) == true){
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
            } else {
                circle.setBackground(redCircle);
                circle.setVisibility(View.VISIBLE);
                answerText.setVisibility(View.VISIBLE);
                answerText.setText("Incorrect");
                trueButton.setVisibility(View.INVISIBLE);
                falseButton.setVisibility(View.INVISIBLE);
                nextButton.setVisibility(View.VISIBLE);
            }
        });

        nextButton.setOnClickListener(v -> {
            if(index == answersList.size()){
                index = 0;
                score = 0;
                scoreText.setText("Score: " + score);
            }

            answerText.setVisibility(View.INVISIBLE);
            circle.setVisibility(View.INVISIBLE);
            nextButton.setVisibility(View.INVISIBLE);
            trueButton.setVisibility(View.VISIBLE);
            falseButton.setVisibility(View.VISIBLE);
            questionText.setText(questionsList.get(index));
        });
    }
}