package com.GFPCommand.UAFA;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.GFPCommand.UAFA.Calculator.Calculator;
import com.GFPCommand.UAFA.Calculator.Helper;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView outputResult;
    private TextView shiftDisplay;
    private TextView degreeRad;
    private boolean isDegree = false;
    private boolean isInverse = false;
    private String lastResult = "";
    private String currentDisplayedInput = "";
    private String inputToBeParsed = "";
    private Calculator mCalculator;
    private static String PREFS_NAME = "memory";
    private Button button0, button1, button2,button3,button4,button5,button6,button7,
            button8,button9,buttonClear, buttonDivide,buttonMultiply,buttonSubtract,
            buttonAdd, buttonPercentage, buttonEqual, buttonDecimal, closeParenthesis, openParenthesis, buttonAnswer, backButton,
            buttonSingleDelete, buttonExp;
    private TextView labelFactorial, labelCombination, labelPermutation, labelPi, labelE, labelComma, labelCubeRoot, labelCube,
            labelInverseX, labelInverseSin, labelInverseCos, labelInverseTan, labelExponential, labelTenPowerX, labelRCL,
            labelSTO, labelMMinus, labelFloat;
    private Button buttonSin, buttonLn,buttonCos, buttonLog, buttonTan, buttonSquareRoot,  buttonXSquare, buttonYPowerX,
            buttonRnd;
    private Button buttonShift, buttonRad, buttonAbs, buttonMr, buttonMs, buttonMPlus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();

        mCalculator = new Calculator();
        outputResult = findViewById(R.id.display);
        outputResult.setText("");
        shiftDisplay = findViewById(R.id.shift_display);
        degreeRad = findViewById(R.id.degree);
        button0 = findViewById(R.id.zero_button);
        button1 = findViewById(R.id.one_button);
        button2 = findViewById(R.id.two_button);
        button3 = findViewById(R.id.three_button);
        button4 = findViewById(R.id.four_button);
        button5 = findViewById(R.id.five_button);
        button6 = findViewById(R.id.six_button);
        button7 = findViewById(R.id.seven_button);
        button8 = findViewById(R.id.eight_button);
        button9 = findViewById(R.id.nine_button);
        buttonDivide = findViewById(R.id.division);
        buttonMultiply = findViewById(R.id.multiplication);
        buttonSubtract = findViewById(R.id.subtraction);
        buttonAdd = findViewById(R.id.addition);
        buttonPercentage = findViewById(R.id.percent);
        buttonDecimal = findViewById(R.id.dot);
        closeParenthesis = findViewById(R.id.close_bracket);
        openParenthesis = findViewById(R.id.open_bracket);
        buttonExp = findViewById(R.id.exp);
        buttonSquareRoot = findViewById(R.id.square_root);
        buttonXSquare = findViewById(R.id.x_square);
        buttonYPowerX = findViewById(R.id.x_power_y);
        buttonSin = findViewById(R.id.sin_sign);
        buttonCos = findViewById(R.id.cos_sign);
        buttonTan = findViewById(R.id.tan_sign);
        buttonLn = findViewById(R.id.natural_log);
        buttonLog = findViewById(R.id.log);
        buttonRnd = findViewById(R.id.hys);
        backButton = findViewById(R.id.backBut);

        buttonShift = findViewById(R.id.shift);
        buttonRad = findViewById(R.id.rad);
        buttonAbs = findViewById(R.id.abs);
        buttonMr = findViewById(R.id.mr);
        buttonMs = findViewById(R.id.ms);
        buttonMPlus = findViewById(R.id.m_plus);
        buttonClear = findViewById(R.id.clear);
        buttonSingleDelete = findViewById(R.id.single_delete);
        buttonEqual = findViewById(R.id.equal_sign);
        buttonAnswer = findViewById(R.id.ans);
        labelFactorial = findViewById(R.id.factorial);
        labelCombination = findViewById(R.id.combination);
        labelPermutation = findViewById(R.id.permutation);
        labelPi = findViewById(R.id.pi);
        labelE = findViewById(R.id.e);
        labelComma = findViewById(R.id.comma);
        labelCubeRoot = findViewById(R.id.cube_root);
        labelCube = findViewById(R.id.cube);
        labelInverseX = findViewById(R.id.one_over_x);
        labelInverseSin = findViewById(R.id.inverse_sin);
        labelInverseCos = findViewById(R.id.inverse_cos);
        labelInverseTan = findViewById(R.id.inverse_tan);
        labelExponential = findViewById(R.id.expo);
        labelTenPowerX = findViewById(R.id.ten_power_x);
        labelRCL = findViewById(R.id.rcl);
        labelSTO = findViewById(R.id.sto);
        labelMMinus = findViewById(R.id.m_minus);
        labelFloat = findViewById(R.id.float_number);

        buttonDivide.setText("/");
        buttonSquareRoot.setText(Html.fromHtml(Helper.squareRoot));
        buttonXSquare.setText(Html.fromHtml(Helper.xSquare));
        buttonYPowerX.setText(Html.fromHtml(Helper.yPowerX));
        labelInverseSin.setText(Html.fromHtml(Helper.inverseSin));
        labelInverseCos.setText(Html.fromHtml(Helper.inverseCos));
        labelInverseTan.setText(Html.fromHtml(Helper.inverseTan));
        labelExponential.setText(Html.fromHtml(Helper.exponential));
        labelTenPowerX.setText(Html.fromHtml(Helper.tenPowerX));
        labelCubeRoot.setText(Html.fromHtml(Helper.cubeSquare));
        labelCube.setText(Html.fromHtml(Helper.cubeRoot));
        labelPi.setText(Html.fromHtml(Helper.pi));

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonPercentage.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonDecimal.setOnClickListener(this);
        closeParenthesis.setOnClickListener(this);
        openParenthesis.setOnClickListener(this);
        buttonSingleDelete.setOnClickListener(this);
        buttonExp.setOnClickListener(this);
        buttonSquareRoot.setOnClickListener(this);
        buttonXSquare.setOnClickListener(this);
        buttonYPowerX.setOnClickListener(this);
        buttonSin.setOnClickListener(this);
        buttonCos.setOnClickListener(this);
        buttonTan.setOnClickListener(this);
        buttonLn.setOnClickListener(this);
        buttonLog.setOnClickListener(this);
        buttonRnd.setOnClickListener(this);
        buttonShift.setOnClickListener(this);
        buttonRad.setOnClickListener(this);
        buttonAbs.setOnClickListener(this);
        buttonMr.setOnClickListener(this);
        buttonMs.setOnClickListener(this);
        buttonMPlus.setOnClickListener(this);
        backButton.setOnClickListener(v -> startActivity(new Intent(CalcActivity.this, MainActivity.class)));
    }

    private void InputValues(String input){
        switch (input){
            case "0":
                currentDisplayedInput += "0";
                inputToBeParsed += "0";
                break;
            case "1":
                if(isInverse){
                    currentDisplayedInput += "&pi";
                    inputToBeParsed += "pi";
                }else{
                    currentDisplayedInput += "1";
                    inputToBeParsed += "1";
                }
                inverse();
                ShiftButton();
                break;
            case "2":
                if(isInverse){
                    currentDisplayedInput += "e";
                    inputToBeParsed += "e";
                }else{
                    currentDisplayedInput += "2";
                    inputToBeParsed += "2";
                }
                inverse();
                ShiftButton();
                break;
            case "3":
                if(isInverse){
                    currentDisplayedInput += ",";
                    inputToBeParsed += ",";
                }else{
                    currentDisplayedInput += "3";
                    inputToBeParsed += "3";
                }
                inverse();
                ShiftButton();
                break;
            case "4":
                if(isInverse){
                    currentDisplayedInput += "!(";
                    inputToBeParsed += "!(";
                }else{
                    currentDisplayedInput += "4";
                    inputToBeParsed += "4";
                }
                inverse();
                ShiftButton();
                break;
            case "5":
                if(isInverse){
                    currentDisplayedInput += "comb(";
                    inputToBeParsed += "comb(";
                }else{
                    currentDisplayedInput += "5";
                    inputToBeParsed += "5";
                }
                inverse();
                ShiftButton();
                break;
            case "6":
                if(isInverse){
                    currentDisplayedInput += "permu(";
                    inputToBeParsed += "permu(";
                }else{
                    currentDisplayedInput += "6";
                    inputToBeParsed += "6";
                }
                inverse();
                ShiftButton();
                break;
            case "7":
                currentDisplayedInput += "7";
                inputToBeParsed += "7";
                break;
            case "8":
                currentDisplayedInput += "8";
                inputToBeParsed += "8";
                break;
            case "9":
                currentDisplayedInput += "9";
                inputToBeParsed += "9";
                break;
            case ".":
                currentDisplayedInput += ".";
                inputToBeParsed += ".";
                break;
            case "+":
                currentDisplayedInput += "+";
                inputToBeParsed += "+";
                break;
            case "-":
                currentDisplayedInput += "-";
                inputToBeParsed += "-";
                break;
            case "/":
                currentDisplayedInput += "/";
                inputToBeParsed += "/";
                break;
            case "x":
                currentDisplayedInput += "*";
                inputToBeParsed += "*";
                break;
            case "(":
                currentDisplayedInput += "(";
                inputToBeParsed += "(";
                break;
            case ")":
                currentDisplayedInput += ")";
                inputToBeParsed += ")";
                break;
            case "%":
                if(isInverse){
                    currentDisplayedInput += "1/";
                    inputToBeParsed += "1/";
                }else{
                    currentDisplayedInput += "%";
                    inputToBeParsed += "%";
                }
                inverse();
                ShiftButton();
                break;
            case "ln":
                if(isInverse){
                    currentDisplayedInput += "e^";
                    inputToBeParsed += "e^";
                }else{
                    currentDisplayedInput += "ln(";
                    inputToBeParsed += "ln(";
                }
                inverse();
                ShiftButton();
                break;
            case "log":
                if(isInverse){
                    currentDisplayedInput += "10^";
                    inputToBeParsed += "10^";
                }else{
                    currentDisplayedInput += "log(";
                    inputToBeParsed += "log(";
                }
                inverse();
                ShiftButton();
                break;
            case "√":
                if(isInverse){
                    currentDisplayedInput += "3√(";
                    inputToBeParsed += "crt(";
                }else{
                    currentDisplayedInput += "√(";
                    inputToBeParsed += "sqrt(";
                }
                inverse();
                ShiftButton();
                break;
            case "Yx":
                currentDisplayedInput += "^";
                inputToBeParsed += "^";
                break;
            case "sin":
                if(isInverse){
                    currentDisplayedInput += "asin(";
                    inputToBeParsed += "asin(";
                }else{
                    currentDisplayedInput += "sin(";
                    inputToBeParsed += "sin(";
                }
                inverse();
                ShiftButton();
                break;
            case "cos":
                if(isInverse){
                    currentDisplayedInput += "acos(";
                    inputToBeParsed += "acos(";
                }else{
                    currentDisplayedInput += "cos(";
                    inputToBeParsed += "cos(";
                }
                inverse();
                ShiftButton();
                break;
            case "tan":
                if(isInverse){
                    currentDisplayedInput += "atan(";
                    inputToBeParsed += "atan(";
                }else{
                    currentDisplayedInput += "tan(";
                    inputToBeParsed += "tan(";
                }
                inverse();
                ShiftButton();
                break;
            case "exp":
                currentDisplayedInput += "E";
                inputToBeParsed += "E0";
                break;
            case "x2":
                if(isInverse){
                    currentDisplayedInput += "^3";
                    inputToBeParsed += "^3";
                }else{
                    currentDisplayedInput += "^2";
                    inputToBeParsed += "^2";
                }
                inverse();
                ShiftButton();
                break;
            case "rnd":
                double ran = Math.random();
                currentDisplayedInput += String.valueOf(ran);
                inputToBeParsed += String.valueOf(ran);
                break;
            case "ABS":
                currentDisplayedInput += "abs(";
                inputToBeParsed += "abs(";
                break;
            case "MR":
                String mValue = getStoredPreferenceValue(CalcActivity.this);
                String result = removeTrailingZero(mValue);
                if(!result.equals("0")){
                    currentDisplayedInput += result;
                    inputToBeParsed += result;
                }
                break;
            case "MS":
                clearMemoryStorage(CalcActivity.this);
                break;
            case "M+":
                if (isInverse){
                    double inputValueMinus  = isNumber(outputResult.getText().toString());
                    if(!Double.isNaN(inputValueMinus)){
                        subtractMemory(CalcActivity.this, inputValueMinus);
                    }
                }else{
                    double inputValue  = isNumber(outputResult.getText().toString());
                    if(!Double.isNaN(inputValue)){
                        addToMemory(CalcActivity.this, inputValue);
                    }
                }
                inverse();
                ShiftButton();
                break;
        }
        outputResult.setText(currentDisplayedInput);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "AC":
                outputResult.setText("");
                currentDisplayedInput = "";
                inputToBeParsed = "";
                break;
            case "del": {
                String enteredInput = outputResult.getText().toString();
                if (enteredInput.length() > 0) {
                    enteredInput = enteredInput.substring(0, enteredInput.length() - 1);
                    currentDisplayedInput = enteredInput;
                    inputToBeParsed = enteredInput;
                    outputResult.setText(currentDisplayedInput);
                }
                break;
            }
            case "=": {
                String enteredInput = outputResult.getText().toString();
                String resultObject = mCalculator.getResult(currentDisplayedInput, inputToBeParsed);
                outputResult.setText(removeTrailingZero(resultObject));
                break;
            }
            case "Ans": {
                String enteredInput = outputResult.getText().toString();
                enteredInput += lastResult;
                outputResult.setText(enteredInput);
                break;
            }
            case "SHIFT":
                if (!isInverse) {
                    isInverse = true;
                } else {
                    isInverse = false;
                }
                ShiftButton();
                break;
            case "RAD":
                buttonRad.setText("DEG");
                degreeRad.setText("RAD");
                break;
            case "DEG":
                buttonRad.setText("RAD");
                degreeRad.setText("DEG");
                break;
            default:
                InputValues(data);
                break;
        }
    }

    private String removeTrailingZero(String formattingInput){
        if(!formattingInput.contains(".")){
            return formattingInput;
        }
        int dotPosition = formattingInput.indexOf(".");
        String newValue = formattingInput.substring(dotPosition, formattingInput.length());
        if(newValue.equals(".0")){
            return formattingInput.substring(0, dotPosition);
        }
        return formattingInput;
    }

    private void inverse(){
        if(isInverse){
            isInverse = false;
        }
    }

    private void ShiftButton() {
        if (isInverse) {
            shiftDisplay.setText("SHIFT");
        } else {
            shiftDisplay.setText("");
        }
    }

    private double isNumber(String numberInput){
        double result = Double.NaN;
        try{
            result = Double.parseDouble(numberInput);
        }catch(NumberFormatException e){
        }
        return result;
    }

    private void addToMemory(Context context, double inputToStore){
        float PrefValue = getPreference(context);
        float newValue = PrefValue + (float)inputToStore;
        setPreference(context, newValue);
    }
    private void subtractMemory(Context context, double inputToStore){
        float returnPrefValue = getPreference(context);
        float newValue = returnPrefValue - (float)inputToStore;
        setPreference(context, newValue);
    }
    private void clearMemoryStorage(Context context){
        setPreference(context, 0);
    }

    private String getStoredPreferenceValue(Context context){
        float returnedValue = getPreference(context);
        return String.valueOf(returnedValue);
    }

    static public boolean setPreference(Context c, float value) {
        SharedPreferences settings = c.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat("key", value);
        return editor.commit();
    }

    static public float getPreference(Context c) {
        SharedPreferences settings = c.getSharedPreferences(PREFS_NAME, 0);
        float value = settings.getFloat("key", 0);
        return value;
    }
}