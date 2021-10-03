package com.gokul.lifecycle;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.jetbrains.annotations.NotNull;

public class SocreViewModel extends AndroidViewModel {


    public int scoreA=10;
    public int scoreB=0;


    public SocreViewModel(@NonNull @NotNull Application application) {
        super(application);
    }
}
