package com.example.android.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                sendBroadcast(new Intent(CUSTOM_INTENT),
                        android.Manifest.permission.VIBRATE);
            }
        });*/
    }

    protected void onNumberButtonClick(View v) {
        final Button b = (Button) v;
        String buttonText = b.getText().toString();
        int num = Integer.parseInt(buttonText);

        final EditText number1 = (EditText) findViewById(R.id.num_1_field);
        final EditText number2 = (EditText) findViewById(R.id.num_2_field);

        if (number1.hasFocus()) {
            // append number in num1
            int num1 = Integer.parseInt(number1.getText().toString());
            num1 = num1 * 10 + num;
            number1.setText(num1);

        }
        if (number2.hasFocus()) {
            //append number in num2
            int num2 = Integer.parseInt(number2.getText().toString());
            num2 = num2 * 10 + num;
            number2.setText(num2);
        }
    }

    protected void onOperatorButtonClick(View v) {
        final Button b = (Button) v;
        String operator = b.getText().toString();
        char op = operator.charAt(0);


        final EditText number1 = (EditText) findViewById(R.id.num_1_field);
        final EditText number2 = (EditText) findViewById(R.id.num_2_field);
        final TextView answer = (TextView) findViewById(R.id.ans_field);

        int num1 = Integer.parseInt(number1.getText().toString());
        int num2 = Integer.parseInt(number2.getText().toString());
        int ans = 0;

        switch (op) {
            case '+': {
                ans = num1 + num2;
                break;
            }
            case '-': {
                ans = num1 - num2;

                break;
            }
            case '*': {
                ans = num1 * num2;
                break;
            }
            case '/': {
                if (num2 == 0)
                    Toast.makeText(this, " Divide by 0, Num2 cannot be 0 !!!", Toast.LENGTH_LONG).show();
                ans = num1 / num2;
                break;
            }
            case '=': {
                answer.setText(ans);
                break;
            }
            case 'C': {
                number1.setText("0");
                number2.setText("0");
                answer.setText("0");
                break;
            }
            default: {
                Toast.makeText(this, "invalid operator " + op + " entered!!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
