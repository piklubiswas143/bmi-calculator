package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText height, weight;
    Button cal, reset;
    TextView bmi, bmirange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Casting
        height = (EditText) findViewById(R.id.hight);
        weight = (EditText) findViewById(R.id.weight);
        cal = (Button) findViewById(R.id.calculate);
        bmi = (TextView) findViewById(R.id.bmi);
        bmirange = (TextView) findViewById(R.id.bmirange);
        reset = (Button) findViewById(R.id.reset);


        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bmical();
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height.setText(null);
                weight.setText(null);
                bmi.setText("Your BMI");
            }
        });

    }

    //BMI Calculator Function
    public void bmical() {

        if (height.getText().toString().isEmpty() | weight.getText().toString().isEmpty()) {
            //Displaying Toast with Hello Javatpoint message
            Toast.makeText(getApplicationContext(), "Empty Height or Weight", Toast.LENGTH_SHORT).show();
            Log.d("this", "this is one view");
        } else {

            double tempheight = Double.parseDouble(height.getText().toString());

            double tempweight = Double.parseDouble(weight.getText().toString());



            double meterheight = tempheight / 3.28;
            double meterheigt = meterheight * meterheight;

            //Bmi calculate divided Weight and Height
            double bmii = tempweight / meterheigt;


            //Condition
            if (bmii <= 18.5) {
                bmirange.setText("Underweight");
                bmi.setText(String.valueOf(bmii));
            }
            else if(bmii<=24.9){
                bmirange.setText("Normal");
                bmi.setText(String.valueOf(bmii));
            }
            else if(bmii<=29.9){
                bmirange.setText("Overweight");
                bmi.setText(String.valueOf(bmii));
            }
            else if(bmii>=30){
                bmirange.setText("Obese");
                bmi.setText(String.valueOf(bmii));
            }


        }

    }

}