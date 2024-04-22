package com.example.quizgameapp.helper;

import com.example.quizgameapp.data.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionGenerator {
    public static List<Question> getQuestions(){
        List<Question> list = new ArrayList<>();

        //hardcode
        //database
        //api

        Question question = new Question();
        question.setId(1);
        question.setQuestion("What is Java?");
        question.setOption1("Programming Language");
        question.setOption2("Game for Pc");
        question.setOption3("Books for knowledge");
        question.setOption4("None of these");
        question.setAnswer("Programming Language");
        list.add(question);

        Question question1 = new Question();
        question1.setId(2);
        question1.setQuestion("Why is Java Used?");
        question1.setOption1("Create web Apps");
        question1.setOption2("Create Mobile Apps");
        question1.setOption3("Create APIs");
        question1.setOption4("All of Above");
        question1.setAnswer("All of Above");
        list.add(question1);

        Question question2 = new Question();
        question2.setId(2);
        question2.setQuestion("What is Type Casting?");
        question2.setOption1("Conversion Type");
        question2.setOption2("Type Conversion");
        question2.setOption3("Type Changing");
        question2.setOption4("All of Above");
        question2.setAnswer("All of Above");
        list.add(question2);

        Question question3 = new Question();
        question3.setId(3);
        question3.setQuestion("Which of the following is true about Java?");
        question3.setOption1("Java is a purely procedural language.");
        question3.setOption2("Java programs are compiled into machine language for a specific type of computer.");
        question3.setOption3("Java supports operator overloading.");
        question3.setOption4("Java is platform-independent.");
        question3.setAnswer("Java is platform-independent.");
        list.add(question3);

        Question question4 = new Question();
        question4.setId(4);
        question4.setQuestion("What is an Activity in Android?");
        question4.setOption1("A fragment of the user interface in an Android application.");
        question4.setOption2("A Java class that defines the UI and behavior of a single screen.");
        question4.setOption3("A background process that performs long-running operations.");
        question4.setOption4("A data structure used to store application data.");
        question4.setAnswer("A Java class that defines the UI and behavior of a single screen.");
        list.add(question4);

        // Question 5
        Question question5 = new Question();
        question5.setId(5);
        question5.setQuestion("What is the output of the following Java code snippet?\n\n" +
                "int x = 5;\n" +
                "System.out.println(++x);");
        question5.setOption1("5");
        question5.setOption2("6");
        question5.setOption3("7");
        question5.setOption4("Compilation Error");
        question5.setAnswer("6");
        list.add(question5);

        // Question 6
        Question question6 = new Question();
        question6.setId(6);
        question6.setQuestion("Which of the following collections in Java guarantees the insertion order?");
        question6.setOption1("HashSet");
        question6.setOption2("TreeSet");
        question6.setOption3("LinkedHashSet");
        question6.setOption4("ArrayList");
        question6.setAnswer("LinkedHashSet");
        list.add(question6);

        // Question 7
        Question question7 = new Question();
        question7.setId(7);
        question7.setQuestion("What is the purpose of a layout file in Android?");
        question7.setOption1("To store user preferences.");
        question7.setOption2("To define the structure of user interface elements.");
        question7.setOption3("To perform background tasks.");
        question7.setOption4("To store application data.");
        question7.setAnswer("To define the structure of user interface elements.");
        list.add(question7);

        // Question 8
        Question question8 = new Question();
        question8.setId(8);
        question8.setQuestion("Which of the following is NOT a valid layout in Android?");
        question8.setOption1("LinearLayout");
        question8.setOption2("RelativeLayout");
        question8.setOption3("FlowLayout");
        question8.setOption4("ConstraintLayout");
        question8.setAnswer("FlowLayout");
        list.add(question8);

        // Question 9
        Question question9 = new Question();
        question9.setId(9);
        question9.setQuestion("What is the purpose of the 'R.java' file in Android?");
        question9.setOption1("To store resource identifiers.");
        question9.setOption2("To execute Java code.");
        question9.setOption3("To manage app permissions.");
        question9.setOption4("To handle network requests.");
        question9.setAnswer("To store resource identifiers.");
        list.add(question9);

        return list;
    }
}
