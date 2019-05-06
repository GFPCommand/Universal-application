package com.GFPCommand.UAFA;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConverterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bin, oct, dec, hex;
    private EditText input;
    private TextView output;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bin = findViewById(R.id.bin);
        oct = findViewById(R.id.oct);
        dec = findViewById(R.id.dec);
        hex = findViewById(R.id.hex);

        input = findViewById(R.id.inputData);
        output = findViewById(R.id.outputData);

        data = input.getText().toString();

        bin.setOnClickListener(this);

        oct.setOnClickListener(this);

        dec.setOnClickListener(this);

        hex.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        Button button = (Button) view;
        data = input.getText().toString();
        String inpData = button.getText().toString();
        switch (inpData) {
            case "BIN":
                output.setText(Integer.parseInt(data, 2));
                break;
            case "OCT":
                output.setText(Integer.parseInt(data, 8));
                break;
            case "DEC":
                output.setText(Integer.parseInt(data, 10));
                break;
            case "HEX":
                output.setText(Integer.parseInt(data, 16));
                break;
        }
    }
}
