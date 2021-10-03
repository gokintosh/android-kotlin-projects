package com.gokul.geoquiz;


import android.os.Bundle;

import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String Tag="QuizActivity";
    private static final String KEY_INDEX="index";


    int mCurrentIndex;
    TextView mQuestionTextView;

    private final Question[] mQuestionBank=new Question[]{
            new Question(R.string.question_australia,true),
            new Question(R.string.question_ocean,true),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_africa,false),
            new Question(R.string.question_asia,true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(Tag,"nocreate(bundle) called"+mCurrentIndex);
        setContentView(R.layout.activity_main);




//        textview
        mQuestionTextView = findViewById(R.id.question_text_view);
        mCurrentIndex = 0;
        int question=mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);

        Button mTrueButton = findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(v -> checkAnswer(true));


        Button mFalseButton = findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(V -> checkAnswer(false));

        ImageButton mNextButton= findViewById(R.id.next_button);
        mNextButton.setOnClickListener(v -> {
            mCurrentIndex=(mCurrentIndex+1)%mQuestionBank.length;
            updateQuestion();

        });

        updateQuestion();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(Tag,"onrestoreInstancestate() called");
        if(savedInstanceState!=null){
            mCurrentIndex=savedInstanceState.getInt(KEY_INDEX,0);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Tag,"onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Tag,"onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Tag,"onPause() called");
    }



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        super.onSaveInstanceState(outState);
        Log.d(Tag,"onsaveInstance() called "+mCurrentIndex);
        outState.putInt(KEY_INDEX,mCurrentIndex);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Tag,"onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Tag,"onDestroy() called");
    }

    private void updateQuestion(){
        int question=mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue=mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId;

        if(userPressedTrue==answerIsTrue){
            messageResId=R.string.correct_toast;
        }else{
            messageResId=R.string.wrong_toast;
        }

        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();
    }
}