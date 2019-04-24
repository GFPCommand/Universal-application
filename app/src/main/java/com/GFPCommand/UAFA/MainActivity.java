package com.GFPCommand.UAFA;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button flash, calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flash = findViewById(R.id.flash);
        calc = findViewById(R.id.calc);

        flash.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FlashActivity.class)));
        calc.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CalcActivity.class)));
    }
}
