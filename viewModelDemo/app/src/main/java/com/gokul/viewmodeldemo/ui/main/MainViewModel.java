package com.gokul.viewmodeldemo.ui.main;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private static final float rate=0.74F;
    private String dollarText="";
    private Float result=0F;


    public void setAmount(String value){
        this.dollarText=value;
        result=Float.parseFloat(dollarText)*rate;
    }


    public Float getResult(){
        return result;
    }
}