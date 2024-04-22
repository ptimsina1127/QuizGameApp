package com.example.quizgameapp;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizgameapp.data.Question;
import com.example.quizgameapp.databinding.ActivityMainBinding;
import com.example.quizgameapp.helper.QuestionGenerator;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;

    private RadioButton[] checkButtons = new RadioButton[4];
    int currentIndex = 0;
    List<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        initComponents();
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