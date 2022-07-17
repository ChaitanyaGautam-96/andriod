package com.example.makeitrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.ColorStateList;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button makeItRain;
    private Button showInfo;
    private TextView moneyValue;
    private int moneyCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeItRain = findViewById(R.id.buttonmakeitrain);
        moneyValue = findViewById(R.id.moneyValue);
        moneyValue.setText(R.string.text);

//        makeItRain.setOnClickListener(view -> Log.d("MainActivity", "onClick: Make it rain!"));

    }

    public void showMoney(View view){
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        moneyCounter += 1000;
        moneyValue.setText(String.valueOf(numberFormat.format(moneyCounter)));
        if(moneyCounter >= 20000){
            moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.red));
        }

        Log.d("MainActivity","onClick: Make it rain!"+moneyCounter);

    }

    public void showInformation(View view) {
        Toast.makeText(MainActivity.this,R.string.app_info,Toast.LENGTH_SHORT).show();

        Snackbar.make(moneyValue,R.string.app_info,Snackbar.LENGTH_LONG).setAction("more",view1 -> {
            Log.d("Snack","showInfo: New Snack");
        }).show();
    }
}