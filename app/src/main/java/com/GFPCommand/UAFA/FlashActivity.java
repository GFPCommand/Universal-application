package com.GFPCommand.UAFA;

import android.content.pm.ActivityInfo;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FlashActivity extends AppCompatActivity implements View.OnClickListener {

    private Button flashActivate;
    private TextView status;
    private boolean activate = false;
    private Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        flashActivate = findViewById(R.id.flashAct);
        status = findViewById(R.id.status);

        flashActivate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if (camera != null) {
            camera.release();
        }
        try {
            camera = Camera.open();
            Parameters params = camera.getParameters();
            if (activate){
                params.setFlashMode(Parameters.FLASH_MODE_TORCH);
                camera.setParameters(params);
                camera.startPreview();
                status.setText("Flash on");
            } else {
                params.setFlashMode(Parameters.FLASH_MODE_OFF);
                camera.setParameters(params);
                camera.stopPreview();
                status.setText("Flash off");
            }
        } catch (RuntimeException e) {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
        }
    }
}
