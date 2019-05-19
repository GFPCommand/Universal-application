package com.GFPCommand.UAFA;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button flash, calc, protractor, converter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        flash     = findViewById(R.id.flash);
        calc      = findViewById(R.id.calc);
        protractor      = findViewById(R.id.protractor);
        converter = findViewById(R.id.convert);

        flash.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FlashActivity.class)));
        calc.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CalcActivity.class)));
        protractor.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ProtractorActivity.class)));
        converter.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ConverterActivity.class)));
    }
}
