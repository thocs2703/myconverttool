package com.thotrinh.myconverttool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ConvertActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText edtNumber;
    private Spinner spnUnit;
    private TextView txtResult;
    private int currentUnit = 0;
    private String disUnits[];

    private double[][] arrDistanceConvertRate = {{1, 100, 39.370078740157, 1.0936132983377},        // meter
                                                {0.01, 1, 0.39370078740157, 0.010936132983377},     // centurmeter
                                                {0.0254, 2.54, 1, 0.027777777777778},               // inch
                                                {0.9144, 91.44, 36, 1}};                            // yard

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convert_layout);

        edtNumber = findViewById(R.id.edt_number);
        spnUnit = findViewById(R.id.spn_convert);
        txtResult = findViewById(R.id.txt_result);

        disUnits = getResources().getStringArray(R.array.distance_unit);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.distance_unit, R.layout.support_simple_spinner_dropdown_item);
        spnUnit.setAdapter(arrayAdapter);

        edtNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                convert(currentUnit, arrDistanceConvertRate);
            }
        });

        spnUnit.setOnItemSelectedListener(this);
    }

    public void convert(int currentUnit, double[][] arrDistanceConvertRate){
        String input = edtNumber.getText().toString();

        if(input.trim().length() == 0){
            txtResult.setText("No available input!");
            return;
        }
        else{
            double number = Float.parseFloat(input);
            String res = "";
            for (int i = 0; i < disUnits.length; i ++){
                if (currentUnit != i){
                    res += disUnits[i];
                    res += ": ";
                    res += number*arrDistanceConvertRate[currentUnit][i];
                    res += "\n";
                }
            }
            txtResult.setText(res);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        convert(position, arrDistanceConvertRate);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
