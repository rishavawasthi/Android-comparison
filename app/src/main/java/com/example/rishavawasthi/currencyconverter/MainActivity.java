package com.example.rishavawasthi.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText toconvert;
    private EditText result;
    private RadioButton Euro,Pound,AUD,USD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toconvert=(EditText)findViewById(R.id.etToConvert);
        result=(EditText)findViewById(R.id.etResult);
        Button btncalc=(Button)findViewById(R.id.btnCalc);
                btncalc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        USD=(RadioButton)findViewById(R.id.rbUSD);
                        AUD=(RadioButton)findViewById(R.id.rbAUD);
                        Euro=(RadioButton)findViewById(R.id.rbEuro);
                        Pound=(RadioButton)findViewById(R.id.rbPound);

                        if(toconvert.getText().length()==0)
                        {
                            Toast.makeText(MainActivity.this,"enter a valid value",Toast.LENGTH_LONG).show();
                            return;
                        }
                        float inputvalue=Float.parseFloat(toconvert.getText().toString());
                        float resultvalue;
                        if (USD.isChecked())

                            resultvalue=inputvalue/50;


                      else if (AUD.isChecked())

                            resultvalue=inputvalue/60;


                      else  if (Euro.isChecked())

                            resultvalue=inputvalue/70;


                      else  if (Pound.isChecked())

                            resultvalue=inputvalue/80;
                      else
                            resultvalue=0;
                        result.setText(String.valueOf(resultvalue));
                    }
                });
    }
}
