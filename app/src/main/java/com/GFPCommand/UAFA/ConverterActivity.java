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
    private TextView output1, output2, output3, output4, out1, out2, out3, out4, warning;
    private String warn = "This function is beta";

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

        out1 = findViewById(R.id.out1);
        out2 = findViewById(R.id.out2);
        out3 = findViewById(R.id.out3);
        out4 = findViewById(R.id.out4);

        output1 = findViewById(R.id.outputField1);
        output2 = findViewById(R.id.outputField2);
        output3 = findViewById(R.id.outputField3);
        output4 = findViewById(R.id.outputField4);
        warning = findViewById(R.id.textView);

        converter = findViewById(R.id.convert);
        input     = findViewById(R.id.inputData);

        numSys     = findViewById(R.id.numericSystems);
        currencies = findViewById(R.id.currencies);
        length     = findViewById(R.id.length);

        converter.setOnClickListener(this);

        but1.setOnClickListener(v -> {
            b1 = true;
            b2 = false;
            b3 = false;
            b4 = false;
            Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
        });
        but2.setOnClickListener(v -> {
            b1 = false;
            b2 = true;
            b3 = false;
            b4 = false;
            Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
        });
        but3.setOnClickListener(v -> {
            b1 = false;
            b2 = false;
            b3 = true;
            b4 = false;
            Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
        });
        but4.setOnClickListener(v -> {
            b1 = false;
            b2 = false;
            b3 = false;
            b4 = true;
            Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
        });

        numSys.setOnClickListener(v -> {
            but1.setText("bin");
            but2.setText("oct");
            but3.setText("dec");
            but4.setText("hex");
            out1.setText("BIN");
            out2.setText("OCT");
            out3.setText("DEC");
            out4.setText("HEX");
            input.setText("");
            warning.setText(warn);
            curr = false;
            len  = false;
            num  = true;
        });

        currencies.setOnClickListener(v -> {
            but1.setText("RUB");
            but2.setText("USD");
            but3.setText("EUR");
            but4.setText("CNY");
            out1.setText("RUB");
            out2.setText("USD");
            out3.setText("EUR");
            out4.setText("CNY");
            input.setText("");
            warning.setText(warn);
            curr = true;
            len  = false;
            num  = false;
        });

        length.setOnClickListener(v -> {
            but1.setText("mm");
            but2.setText("cm");
            but3.setText("m");
            but4.setText("km");
            out1.setText("mm");
            out2.setText("cm");
            out3.setText("m");
            out4.setText("km");
            input.setText("");
            warning.setText("");
            curr = false;
            len = true;
            num = false;
        });
    }

    public void ToBinary(float data){
        int []d = new int[input.length()];

        for (int i = 0; i < d.length; i++) {

        }
    }

    @Override
    public void onClick (View view) {

        inputData = Float.parseFloat(input.getText().toString());
        if (input.length() == 0){
            Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_LONG).show();
            return;
        }

        if (num) {//конвертер для систем счисления (сс) будет готов в скором времени, так как за короткий срок не удается правильно сделать конвертирование и получение данных в некоторых сс.

            if (b1 && !b2 && !b3 && !b4) {
                //TODO
            } else if (!b1 && b2 && !b3 && !b4) {
                //TODO
            } else if (!b1 && !b2 && b3 && !b4) {
                int inpData = (int) inputData;
                output1.setText(Integer.toBinaryString(Integer.parseInt(String.valueOf(inpData))));
                output2.setText(Integer.toOctalString(Integer.parseInt(String.valueOf(inpData))));
                output3.setText(String.valueOf(inpData));
                output4.setText(Integer.toHexString(Integer.parseInt(String.valueOf(inpData))));
            } else if (!b1 && !b2 && !b3 && b4) {
                //TODO
            }

        } else if (curr) {//конвертер валют будет готов в скором времени, так как за короткий срок не удается правильно подключаться к API. В данный момент используются примерные величины

            if (b1 && !b2 && !b3 && !b4) {
                output1.setText(String.valueOf(inputData));
                output2.setText(String.valueOf(inputData * 0.015));
                output3.setText(String.valueOf(inputData * 0.014));
                output4.setText(String.valueOf(inputData * 0.11));
            } else if (!b1 && b2 && !b3 && !b4) {
                output1.setText(String.valueOf(inputData * 64.54));
                output2.setText(String.valueOf(inputData));
                output3.setText(String.valueOf(inputData * 0.9));
                output4.setText(String.valueOf(inputData * 6.92));
            } else if (!b1 && !b2 && b3 && !b4) {
                output1.setText(String.valueOf(inputData * 71.97));
                output2.setText(String.valueOf(inputData * 1.12));
                output3.setText(String.valueOf(inputData));
                output4.setText(String.valueOf(inputData * 7.71));
            } else if (!b1 && !b2 && !b3 && b4) {
                output1.setText(String.valueOf(inputData * 9.33));
                output2.setText(String.valueOf(inputData * 0.14));
                output2.setText(String.valueOf(inputData * 0.13));
                output4.setText(String.valueOf(inputData));
            }

        } else if (len) {
            if (b1 && !b2 && !b3 && !b4) {
                output1.setText(String.valueOf(inputData));
                output2.setText(String.valueOf(inputData / 10));
                output3.setText(String.valueOf(inputData / 1_000));
                output4.setText(String.valueOf(inputData / 1_000_000));
            } else if (!b1 && b2 && !b3 && !b4) {
                output1.setText(String.valueOf(inputData * 10));
                output2.setText(String.valueOf(inputData));
                output3.setText(String.valueOf(inputData / 100));
                output4.setText(String.valueOf(inputData / 100_000));
            } else if (!b1 && !b2 && b3 && !b4) {
                output1.setText(String.valueOf(inputData * 1_000));
                output2.setText(String.valueOf(inputData * 100));
                output3.setText(String.valueOf(inputData));
                output4.setText(String.valueOf(inputData / 1_000));
            } else if (!b1 && !b2 && !b3 && b4) {
                output1.setText(String.valueOf(inputData * 1_000_000));
                output2.setText(String.valueOf(inputData * 100_000));
                output3.setText(String.valueOf(inputData * 1_000));
                output4.setText(String.valueOf(inputData));
            }
        }
    }
}
