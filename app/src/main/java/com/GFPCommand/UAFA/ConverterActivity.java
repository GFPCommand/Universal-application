package com.GFPCommand.UAFA;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ConverterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button converter, but1, but2, but3, but4;
    private RadioButton numSys, currencies, length;
    private EditText input;
    private float inputData;
    private Boolean num = true, curr = false, len = false, b1 = true, b2 = false, b3 = false, b4 = false;
    private TextView output1, output2, output3, output4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        but1 = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);
        but3 = findViewById(R.id.but3);
        but4 = findViewById(R.id.but4);

        output1 = findViewById(R.id.outputField1);
        output2 = findViewById(R.id.outputField2);
        output3 = findViewById(R.id.outputField3);
        output4 = findViewById(R.id.outputField4);

        converter  = findViewById(R.id.convert);
        input      = findViewById(R.id.inputData);
        numSys     = findViewById(R.id.numericSystems);
        currencies = findViewById(R.id.currencies);
        length     = findViewById(R.id.length);

        converter.setOnClickListener(this);

        but1.setOnClickListener(v -> {
            b1 = true;
            b2 = false;
            b3 = false;
            b4 = false;
        });
        but2.setOnClickListener(v -> {
            b1 = false;
            b2 = true;
            b3 = false;
            b4 = false;
        });
        but3.setOnClickListener(v -> {
            b1 = false;
            b2 = false;
            b3 = true;
            b4 = false;
        });
        but4.setOnClickListener(v -> {
            b1 = false;
            b2 = false;
            b3 = false;
            b4 = true;
        });

        if (numSys.isChecked()){
            but1.setText("bin");
            but2.setText("oct");
            but3.setText("dec");
            but4.setText("hex");
            curr = false;
            len  = false;
            num  = true;
        } else if (currencies.isChecked()){
            but1.setText("USD");
            but2.setText("EUR");
            but3.setText("RUB");
            but4.setText("CNY");
            curr = true;
            len  = false;
            num  = false;
        } else if (length.isChecked()) {
            but1.setText("mm");
            but2.setText("sm");
            but3.setText("m");
            but4.setText("km");
            curr = false;
            len = true;
            num = false;
        }
    }

    @Override
    public void onClick (View view) {

        inputData = Float.parseFloat(input.getText().toString());
        if (input.length() == 0){
            Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_LONG).show();
            return;
        }

        if (num) {

            if (b1 && !b2 && !b3 && !b4) {

            } else if (!b1 && b2 && !b3 && !b4) {

            } else if (!b1 && !b2 && b3 && !b4) {

            } else if (!b1 && !b2 && !b3 && b4) {

            }

        } else if (curr) {

            if (b1 && !b2 && !b3 && !b4) {

            } else if (!b1 && b2 && !b3 && !b4) {

            } else if (!b1 && !b2 && b3 && !b4) {

            } else if (!b1 && !b2 && !b3 && b4) {

            }

        } else if (len) {
            if (b1 && !b2 && !b3 && !b4) {
                output1.setText(String.valueOf(inputData));
                output2.setText(String.valueOf(inputData * 10));
                output3.setText(String.valueOf(inputData * 1_000));
                output4.setText(String.valueOf(inputData * 1_000_000));
            } else if (!b1 && b2 && !b3 && !b4) {
                output1.setText(String.valueOf(inputData / 10));
                output2.setText(String.valueOf(inputData));
                output3.setText(String.valueOf(inputData * 100));
                output4.setText(String.valueOf(inputData * 100_000));
            } else if (!b1 && !b2 && b3 && !b4) {
                output1.setText(String.valueOf(inputData / 1_000));
                output2.setText(String.valueOf(inputData / 100));
                output3.setText(String.valueOf(inputData));
                output4.setText(String.valueOf(inputData * 1_000));
            } else if (!b1 && !b2 && !b3 && b4) {
                output1.setText(String.valueOf(inputData / 1_000_000));
                output2.setText(String.valueOf(inputData / 100_000));
                output3.setText(String.valueOf(inputData / 1_000));
                output4.setText(String.valueOf(inputData));
            }
        }
    }
}
