package com.example.hmand312calc;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import android.widget.Switch;
import android.widget.TextView;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnZero;
    Button btnPoint;
    Button btnC;
    Button btnSing;
    Button btnPer;
    Button btnDiv;
    Button btnMul;
    Button btnMin;
    Button btnPlus;
    Button btnEqual;
    TextView txtResult;
    Switch mSwitch;
    Switch nSwitch;
    String result;
    View standardLayout;
    View ingLayout;
    Calculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnZero = findViewById(R.id.zero);
        btnPoint = findViewById(R.id.btnPoint);
        txtResult = findViewById(R.id.txtResult);
        btnC = findViewById(R.id.btnC);
        btnSing = findViewById(R.id.btnSign);
        btnDiv = findViewById(R.id.btnDivision);
        btnPer = findViewById(R.id.btnPercent);
        btnMul = findViewById(R.id.btnMultiplication);
        btnMin = findViewById(R.id.btnMin);
        btnPlus = findViewById(R.id.btnPlus);
        btnEqual = findViewById(R.id.btnEqually);
        mSwitch = findViewById(R.id.switch1);
        nSwitch = findViewById(R.id.switch2);

        txtResult.setText("0");

        btnOne.setOnClickListener(onClick);
        btnTwo.setOnClickListener(onClick);
        btnThree.setOnClickListener(onClick);
        btnFour.setOnClickListener(onClick);
        btnFive.setOnClickListener(onClick);
        btnSix.setOnClickListener(onClick);
        btnSeven.setOnClickListener(onClick);
        btnEight.setOnClickListener(onClick);
        btnNine.setOnClickListener(onClick);
        btnZero.setOnClickListener(onClick);
        btnPoint.setOnClickListener(onClick);
        btnC.setOnClickListener(onClick);
        btnSing.setOnClickListener(onClick);
        btnPer.setOnClickListener(onClick);
        btnDiv.setOnClickListener(onClick);
        btnMul.setOnClickListener(onClick);
        btnMin.setOnClickListener(onClick);
        btnPlus.setOnClickListener(onClick);
        btnEqual.setOnClickListener(onClick);

        standardLayout = findViewById(R.id.linearLayoutStandard);
        ingLayout = findViewById(R.id.ingLayout);
        mSwitch.setOnCheckedChangeListener(switchCheck);
        nSwitch.setOnCheckedChangeListener(switchCheck);


    }


    Button.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.zero:
                    result = calculator.getDigit('0');
                    break;
                case R.id.btnOne:
                    result = calculator.getDigit('1');
                    break;
                case R.id.btnTwo:
                    result = calculator.getDigit('2');
                    break;
                case R.id.btnThree:
                    result = calculator.getDigit('3');
                    break;
                case R.id.btnFour:
                    result = calculator.getDigit('4');
                    break;
                case R.id.btnFive:
                    result = calculator.getDigit('5');
                    break;
                case R.id.btnSix:
                    result = calculator.getDigit('6');
                    break;
                case R.id.btnSeven:
                    result = calculator.getDigit('7');
                    break;
                case R.id.btnEight:
                    result = calculator.getDigit('8');
                    break;
                case R.id.btnNine:
                    result = calculator.getDigit('9');
                    break;
                case R.id.btnPoint:
                    result = calculator.getDigit('.');
                    break;
                case R.id.btnC:
                    result = calculator.getAction(Action.C);
                    break;
                case R.id.btnDivision:
                    result = calculator.getAction(Action.DIV);
                    break;
                case R.id.btnMultiplication:
                    result = calculator.getAction(Action.MUL);
                    break;
                case R.id.btnPercent:
                    result = calculator.getAction(Action.PER);
                    break;
                case R.id.btnPlus:
                    result = calculator.getAction(Action.PLUS);
                    break;
                case R.id.btnMin:
                    result = calculator.getAction(Action.MIN);
                    break;
                case R.id.btnSign:
                    result = calculator.getAction(Action.SING);
                    break;
                case R.id.btnEqually:
                    result = calculator.getAction(Action.EQUAL);
                    break;


            }
            txtResult.setText(result);

        }
    };
    final Switch.OnCheckedChangeListener switchCheck = new Switch.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                standardLayout.setVisibility(View.INVISIBLE);
                ingLayout.setVisibility(VISIBLE);
            } else {
                standardLayout.setVisibility(VISIBLE);
                ingLayout.setVisibility(View.INVISIBLE);
            }
        }
    };


}







