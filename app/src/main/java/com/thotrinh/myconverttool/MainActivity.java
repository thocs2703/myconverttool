package com.thotrinh.myconverttool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout distanceConvert;
    private LinearLayout weightConvert;
    private LinearLayout temperatureConvert;
    private LinearLayout speedConvert;

    public static final int DISTANCE_CONVERT = 1;
    public static final int WEIGHT_CONVERT = 2;
    public static final int TEMPERATURE_CONVERT = 3;
    public static final int SPEED_CONVERT = 4;

    private static int activityConvert = DISTANCE_CONVERT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        distanceConvert = findViewById(R.id.distance_convert);
        weightConvert = findViewById(R.id.weight_convert);
        temperatureConvert = findViewById(R.id.temperature_convert);
        speedConvert = findViewById(R.id.speed_convert);

        distanceConvert.setOnClickListener(this);
        weightConvert.setOnClickListener(this);
        temperatureConvert.setOnClickListener(this);
        speedConvert.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.distance_convert){
            activityConvert = DISTANCE_CONVERT;
        }
        else if (id == R.id.weight_convert){
            activityConvert = WEIGHT_CONVERT;
        }
        else if (id == R.id.temperature_convert){
            activityConvert = TEMPERATURE_CONVERT;
        }
        else {
            activityConvert = SPEED_CONVERT;
        }

        Intent intent = new Intent(this, ConvertActivity.class);
        intent.putExtra("convert", activityConvert);
        startActivity(intent);
    }
}
