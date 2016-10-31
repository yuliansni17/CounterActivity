package com.example.yuliansari.counteractivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class activity_counter extends AppCompatActivity implements View.OnClickListener {

    private static final String LOG_TAG = activity_counter.class.getSimpleName();
    private int number;
    private TextView counterNumber;
    private Button plus, minus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        counterNumber = (TextView) findViewById(R.id.angka);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        number = Integer.parseInt(String.valueOf(counterNumber.getText()));
        Log.v(LOG_TAG, "Angka sekarang nilainya : "+number);
        Toast.makeText(this, "Angka sekarang nilainya : "+number, Toast.LENGTH_SHORT).show();
    }

    public void increment(){
        number++;
        counterNumber.setText(number+"");
    }

    public void decrement(){
        number--;
        counterNumber.setText(number+"");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.plus:
                increment();
                break;
            case R.id.minus:
                if(number < 1){
                    return;
                }
                decrement();
                break;
        }
    }
}
