package com.GFPCommand.UAFA;

import android.content.pm.ActivityInfo;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class FlashActivity extends AppCompatActivity implements View.OnClickListener {

    private Button flashActivate;
    private TextView status;
    private boolean activate = false;

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

        Camera camera = Camera.open();

        Camera.Parameters parameters = camera.getParameters();
        if (!activate) {
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            status.setText("Off");
        } else {
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_ON);
            status.setText("On");
        }
        camera.setParameters(parameters);
        camera.startPreview();
    }
}
