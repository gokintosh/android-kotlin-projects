package com.gokul.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        SocreViewModel model=new ViewModelProvider(this).get(SocreViewModel.class);

        DisplayPoints(model);
    }

    private void DisplayPoints(SocreViewModel model) {

        Toast.makeText(this,"Points of A is "+model.scoreA,Toast.LENGTH_SHORT).show();
    }
}