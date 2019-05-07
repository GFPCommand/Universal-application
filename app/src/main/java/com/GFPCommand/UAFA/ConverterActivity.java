package com.GFPCommand.UAFA;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConverterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bin, oct, dec, hex;
    private EditText input;
    private TextView output;
    private String data, currentDisplayedInput = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        bin = findViewById(R.id.bin);
        oct = findViewById(R.id.oct);
        dec = findViewById(R.id.dec);
        hex = findViewById(R.id.hex);

        input = findViewById(R.id.inputData);
        output = findViewById(R.id.outputData);

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

        int conversationNumber;

        if (data != null) {
            switch (inpData) {
                case "BIN":
                    conversationNumber = Integer.parseInt(data, 2);
                    currentDisplayedInput += conversationNumber;
                    output.setText(currentDisplayedInput);
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
        } else {
            output.setText("Edit text is null!!!");
        }
    }
}
