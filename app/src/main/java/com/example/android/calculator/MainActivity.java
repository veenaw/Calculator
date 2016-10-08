package com.example.android.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    private static int ans = 0;
    private static int operator=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onNumberButtonClick(View v) {
        final Button b = (Button) v;
        if (b == null) {

            Log.v(TAG, "B is null");
        }
        String buttonText = b.getText().toString();
        int num = Integer.parseInt(buttonText);

        EditText number1 = (EditText) findViewById(R.id.num_1_field);
        EditText number2 = (EditText) findViewById(R.id.num_2_field);
        int num1 = 0, num2 = 0;
        if ((number1 !=null) ||(number1.getText()!=null) || !(number1.getText().toString().equals("")) ){
            num1 = Integer.parseInt(number1.getText().toString());
        }
        if ((number2 !=null) ||(number2.getText() != null) || !(number2.getText().toString().equals(""))) {
            num2 = Integer.parseInt(number2.getText().toString());
        }

        if (number1.hasFocus()) {
            // append number in num1
            num1 = num1 * 10 + num;
            number1.setText(num1 + "");

        }
        if (number2.hasFocus()) {
            //append number in num2
            num2 = num2 * 10 + num;
            number2.setText(num2 + "");
        }
    }

    protected void onOperatorButtonClick(View v) {

        final EditText number1 = (EditText) findViewById(R.id.num_1_field);
        final EditText number2 = (EditText) findViewById(R.id.num_2_field);
        final TextView answer = (TextView) findViewById(R.id.ans_field);

        int num1 = 0, num2 = 0;

        if ((number1 !=null) ||(number1.getText() != null) || !(number1.getText().toString().equals("")) ){
            num1 = Integer.parseInt(number1.getText().toString());
        }

        if( (number2 !=null) ||(number2.getText() != null)  || !(number2.getText().toString().equals(""))){
            num2 = Integer.parseInt(number2.getText().toString());
        }

        operator=v.getId();
        switch (operator) {
            case R.id.add_button: {
                ans = num1 + num2;
                break;
            }
            case R.id.minus_button: {
                ans = num1 - num2;

                break;
            }
            case R.id.multiply_button: {
                ans = num1 * num2;
                break;
            }
            case R.id.divide_button: {
                if (num2 == 0) {
                    Toast.makeText(this, " Divide by 0, Num2 cannot be 0 !!!", Toast.LENGTH_LONG).show();
                } else {
                    ans = num1 / num2;
                }
                break;
            }

            case R.id.equalTo_button: {
                answer.setText(ans + "");
                break;
            }

            case R.id.clear_button: {
                number1.setText("0");
                number2.setText("0");
                ans = 0;
                answer.setText(ans+"");
                operator=0;
                break;
            }

            default: {
                Toast.makeText(this, "invalid operator entered!!", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
