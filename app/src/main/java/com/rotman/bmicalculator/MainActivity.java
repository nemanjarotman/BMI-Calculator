package com.rotman.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import core.Health;

public class MainActivity extends AppCompatActivity {
    NumberPicker heightNumberPicker;
    NumberPicker weightNumberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heightNumberPicker = (NumberPicker) findViewById(R.id.heightNumberPicker);
        weightNumberPicker = (NumberPicker) findViewById(R.id.weightNumberPicker);
        heightNumberPicker.setMaxValue(250);
        heightNumberPicker.setMinValue(120);
        heightNumberPicker.setValue(175);
        heightNumberPicker.setWrapSelectorWheel(false);
        weightNumberPicker.setMaxValue(400);
        weightNumberPicker.setMinValue(20);
        weightNumberPicker.setValue(70);
        weightNumberPicker.setWrapSelectorWheel(false);
    }

    public void calculateBtnClick(View v){
        double height = 0;
        double weight = 0;
        if(heightNumberPicker != null){
            height = heightNumberPicker.getValue();
        }
        if(weightNumberPicker != null){
            weight = weightNumberPicker.getValue();
        }

        Health health = new Health();
        double bmiResult = health.calculateBMI(height, weight);
        TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
        if(bmiResult == -1){
            resultTextView.setText(health.getErrorMessage());
        }else{
            String bmiCat = health.bmiCategory(bmiResult);
            resultTextView.setText("Your BMI index is "+ String.format( "%.2f",bmiResult ) +"\nBMI category: "+ bmiCat);
        }
    }
}

