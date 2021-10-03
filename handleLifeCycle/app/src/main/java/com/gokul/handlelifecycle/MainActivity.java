package com.gokul.handlelifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.gokul.handlelifecycle.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        MainActivityPresenter mainActivityPresenter=new MainActivityPresenter(this,getApplicationContext());

        StudentData studentData=new StudentData("Student grade","10");

        binding.setGrader(studentData);
        binding.setPresenter(mainActivityPresenter);


    }

    @Override
    public void showData(StudentData studentData) {
        String grade=studentData.getGrade();

    }
}