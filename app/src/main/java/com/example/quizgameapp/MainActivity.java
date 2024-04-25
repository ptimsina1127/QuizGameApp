package com.example.quizgameapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizgameapp.config.Constants;
import com.example.quizgameapp.data.Question;
import com.example.quizgameapp.databinding.ActivityMainBinding;
import com.example.quizgameapp.helper.QuestionGenerator;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;

    private RadioButton[] checkButtons = new RadioButton[4];
    int currentIndex = 0;
    List<Question> questions;
    private CountDownTimer timer;
    private int totalTime = 5*60;
    private int timeLeft = Constants.TOTAL_EXAM_TIME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        initComponents();
        startTimer();
    }

    private void submitTest(){
        Toast.makeText(this, "Test Submitted", Toast.LENGTH_SHORT).show();
        int correctAnswers = 0;

        for (Question question : questions) {
            if (question.getCheckValue() != -1) { // Ensure an option is selected
                // Get the selected option based on the checkValue
                String selectedOption = null;
                int selectedOptionId = question.getCheckValue();
                if (selectedOptionId == R.id.option1) {
                    selectedOption = question.getOption1();
                } else if (selectedOptionId == R.id.option2) {
                    selectedOption = question.getOption2();
                } else if (selectedOptionId == R.id.option3) {
                    selectedOption = question.getOption3();
                } else if (selectedOptionId == R.id.option4) {
                    selectedOption = question.getOption4();
                }
                // Check if the selected option matches the correct answer
                if (selectedOption != null && selectedOption.equals(question.getAnswer())) {
                    correctAnswers++;
                }
            }
        }

        double scorePercentage = (double) correctAnswers / questions.size() * 100;

        // Display the result to the user
        String resultMessage = "You scored " + correctAnswers + " out of " + questions.size() +
                ". Your score: " + scorePercentage + "%";

        //Toast.makeText(this, resultMessage, Toast.LENGTH_LONG).show();

        // Optionally, navigate to ResultActivity and pass the result data
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("correctAnswers", correctAnswers);
        intent.putExtra("totalQuestions", questions.size());
        startActivity(intent);
    }
    // Start Timer Method
    private void startTimer() {
        timer= new CountDownTimer(Constants.TOTAL_EXAM_TIME*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //It runs every seconds or 1000 milliseconds
                int min  = timeLeft/60;
                int sec = timeLeft%60;
                binding.timer.setText(min+" min "+sec+" sec");
                timeLeft--;

                //Update Circular Progress bar
                binding.circularProgressBar.setProgress((float)timeLeft/Constants.TOTAL_EXAM_TIME*100);
            }

            @Override
            public void onFinish() {
                // When the timer is finished this runs
                Toast.makeText(MainActivity.this, "Time is UP.!", Toast.LENGTH_SHORT).show();
                submitTest();
                binding.timer.setText("Finished");
            }
        };
        timer.start();
    }

    private void initComponents() {
        checkButtons[0] = binding.option1;
        checkButtons[1] = binding.option2;
        checkButtons[2] = binding.option3;
        checkButtons[3] = binding.option4;

        for (RadioButton button:checkButtons){
            button.setOnClickListener(this);
        }
        questions = QuestionGenerator.getQuestions();
        Question question = questions.get(currentIndex);
        setQuestionToView(question,currentIndex);

        binding.nextButton.setOnClickListener(e->{
            nextQuestion();
        });

        binding.previousButton.setOnClickListener(e->{
            previousQuestion();
        });
        binding.submitButton.setOnClickListener(e->{
            submitTest();
        });

    }

    private void previousQuestion() {
        currentIndex = currentIndex-1;
        if(currentIndex<0){
            Toast.makeText(this, "Already At First Question", Toast.LENGTH_SHORT).show();
            currentIndex =0;
        }
        else{
            setQuestionToView(questions.get(currentIndex),currentIndex);
        }
    }

    private void nextQuestion() {
        currentIndex = currentIndex+1;

        if (currentIndex> questions.size()-1){
            Toast.makeText(this, "This is the Last Question", Toast.LENGTH_SHORT).show();
            currentIndex = questions.size()-1;
        }else{
            setQuestionToView(questions.get(currentIndex),currentIndex);
        }

    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(this, "Button Clicked", Toast.LENGTH_LONG).show();
        RadioButton buttonClicked = (RadioButton) v;
        for (RadioButton button:checkButtons){
            button.setChecked(button.getId()==buttonClicked.getId());
        }
        questions.get(currentIndex).setCheckValue(buttonClicked.getId());
    }


    private void setQuestionToView(Question question, int index){
        binding.question.setText((currentIndex+1)+". "+question.getQuestion());
        binding.option1.setText(question.getOption1());
        binding.option2.setText(question.getOption2());
        binding.option3.setText(question.getOption3());
        binding.option4.setText(question.getOption4());

        for(RadioButton button:checkButtons){
            if (questions.get(currentIndex).getCheckValue()==button.getId()){
                button.setChecked(true);
            }else{
                button.setChecked(false);
            }
        }
    }
}