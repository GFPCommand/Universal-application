package com.GFPCommand.UAFA;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class FlashActivity extends AppCompatActivity {

    private Button flashActivate;
    private TextView status;
    private boolean activate = false;
    private Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);

        flashActivate = findViewById(R.id.flashAct);

        flashActivate.setOnClickListener(v -> onClick());
    }

    public void onClick(){
        if (camera == null) {
            camera = Camera.open();
        }
        Camera.Parameters parameters = camera.getParameters();
        if (!activate) {
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        } else {
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        }
        camera.setParameters(parameters);
        camera.startPreview();
    }
}
