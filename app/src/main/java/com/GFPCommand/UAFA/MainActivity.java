package com.GFPCommand.UAFA;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button flash, calc, game, converter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flash     = findViewById(R.id.flash);
        calc      = findViewById(R.id.calc);
        game      = findViewById(R.id.game);
        converter = findViewById(R.id.conv);

        flash.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FlashActivity.class)));
        calc.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CalcActivity.class)));
        game.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, GameActivity.class)));
        converter.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ConverterActivity.class)));
    }
}
