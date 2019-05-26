package com.GFPCommand.UAFA;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import static android.content.pm.PackageManager.FEATURE_CAMERA_FLASH;

public class FlashActivity extends AppCompatActivity {

    private Button backButton;
    private TextView status;
    private ToggleButton activate;
    private boolean hasFlash, light;

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        activate = findViewById(R.id.flashAct);
        status   = findViewById(R.id.status);
        backButton =findViewById(R.id.backBut);

        backButton.setOnClickListener(v -> startActivity(new Intent(FlashActivity.this, MainActivity.class)));

        final CameraManager cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);

        hasFlash = getPackageManager().hasSystemFeature(FEATURE_CAMERA_FLASH);
        light = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 60);

        if (hasFlash && light) {
            activate.setOnClickListener(v -> {
                try {
                    String cameraID = cameraManager.getCameraIdList()[0];

                    if (activate.isChecked()) {
                        cameraManager.setTorchMode(cameraID, true);
                        status.setText("Flash on");
                    } else {
                        cameraManager.setTorchMode(cameraID, false);
                        status.setText("Flash off");
                    }
                } catch (CameraAccessException e) {
                    Toast.makeText(getApplicationContext(), "Camera access error", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "Your device don't have flash", Toast.LENGTH_LONG).show();
        }
    }
}
