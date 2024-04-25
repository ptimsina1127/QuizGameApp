package com.example.quizgameapp;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Extract score data from Intent extras
        int correctAnswers = getIntent().getIntExtra("correctAnswers", 0);
        int totalQuestions = getIntent().getIntExtra("totalQuestions", 0);

        // Calculate score percentage
        double scorePercentage = (double) correctAnswers / totalQuestions * 100;

        // Display score in TextView
        TextView scoreTextView = findViewById(R.id.scoreTextView);
        scoreTextView.setText("You scored " + correctAnswers + " out of " + totalQuestions +
                ". Your score: " + scorePercentage + "%");

        // runs the animation drawable
        ImageView img = (ImageView)findViewById(R.id.imageViewAnimation);
        img.setBackgroundResource(R.drawable.animation);

        // Get the AnimationDrawable object.
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();

        // Start the animation (looped playback by default).
        frameAnimation.start();
    }
}

