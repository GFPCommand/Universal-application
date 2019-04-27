package com.GFPCommand.UAFA;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.camera2.*;
import android.widget.Button;

public class FlashActivity extends AppCompatActivity {

    private Button flashActivate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);

        flashActivate = findViewById(R.id.flashAct);

        flashActivate.setOnClickListener(v -> onClick());
    }

    public void onClick(){

    }
}
