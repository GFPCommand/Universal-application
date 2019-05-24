package com.GFPCommand.UAFA;

import android.Manifest;
import android.annotation.TargetApi;
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
import android.widget.ToggleButton;

public class FlashActivity extends AppCompatActivity {

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
        final CameraManager cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);

        hasFlash = getPackageManager().hasSystemFeature(getPackageManager().FEATURE_CAMERA_FLASH);
        light = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 60);

        activate.setOnClickListener(v -> {
            try {
                String cameraID = cameraManager.getCameraIdList()[0];

                if (activate.isChecked()){
                    cameraManager.setTorchMode(cameraID, true);
                } else {
                    cameraManager.setTorchMode(cameraID, false);
                }
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
47