package com.example.tempraturecalculatertute2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_temprature;
    RadioButton rd_btn_celcius;
    RadioButton rd_btn_farhenite;
    Button btn_Calculate;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_temprature = findViewById(R.id.et_temp);
        rd_btn_celcius = findViewById(R.id.rd_btn_C);
        rd_btn_farhenite = findViewById(R.id.rd_btn_F);
        btn_Calculate = findViewById(R.id.btn_calculate);
        tv_result = findViewById(R.id.tv_result);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        btn_Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }
    public void calculateAnswer(){
        Calculations cal = new Calculations();
        String value = et_temprature.getText().toString();
        if(TextUtils.isEmpty(value)){
            Toast.makeText(this, "Enter the temperature", Toast.LENGTH_SHORT).show();
        } else{
            float temp = Float.parseFloat(value);
            if(rd_btn_celcius.isChecked()){
                temp = cal.convertCelciusToFarhenheit(temp);
            }else if(rd_btn_farhenite.isChecked()){
                temp = cal.convertCelciusToFarhenheit(temp);
            }else{
                Toast.makeText(this, "Select the radio button", Toast.LENGTH_SHORT).show();
                temp = 0.0f;
            }

            tv_result.setText(new Float(temp).toString()); 
        }

    }
}