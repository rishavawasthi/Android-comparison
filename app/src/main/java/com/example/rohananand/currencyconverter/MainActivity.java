package com.example.rohananand.currencyconverter;

import java.util.List;
import java.util.ArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private EditText toConvert;
    private EditText result;
    private RadioButton USD, AUD, Euro, Pound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toConvert = (EditText)findViewById(R.id.etToConvert);
        result = (EditText)findViewById(R.id.etResult);

        Button btnCalc = (Button)findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                USD = (RadioButton)findViewById(R.id.rbUSD);
                AUD = (RadioButton)findViewById(R.id.rbAUD);
                Euro = (RadioButton)findViewById(R.id.rbEuro);
                Pound = (RadioButton)findViewById(R.id.rbPound);

                if(toConvert.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, "Please enter a valid value", Toast.LENGTH_LONG).show();
                    return;
                }

                float inputValue = Float.parseFloat(toConvert.getText().toString());
                float resultValue;

                if(USD.isChecked())
                    resultValue = inputValue / 60;
                else if(AUD.isChecked())
                    resultValue = inputValue / 50;
                else if(Euro.isChecked())
                    resultValue = inputValue / 70;
                else if(Pound.isChecked())
                    resultValue = inputValue / 80;
                else
                    resultValue = 0;

                result.setText(String.valueOf(resultValue));

            }
        });
    }

}
