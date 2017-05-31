package com.zacadams.zac_work.testcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import bsh.EvalError;
import bsh.Interpreter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String temp2 = "";
    int counter = 0;
    char c = 'a';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button plus = (Button) findViewById(R.id.button12); //the button listeners declaration here to make life easier when accessing
        Button multiply = (Button) findViewById(R.id.button14);
        Button divide = (Button) findViewById(R.id.button15);
        Button equals = (Button) findViewById(R.id.button16);
        Button subtract = (Button) findViewById(R.id.button13);
        Button clear = (Button) findViewById(R.id.button19);
        plus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        equals.setOnClickListener(this);
        subtract.setOnClickListener(this);
        clear.setOnClickListener(this);

    }

    public void onClick(View view) { //Button listeners access here
        TextView dialogue = (TextView) findViewById(R.id.dialogue);
        EditText edit = (EditText) findViewById(R.id.editText);
        Interpreter i = new Interpreter(); //Interpreter is an imported class from the BeanShell Java library. Documentation at www.beanshell.org

        if(counter < 4){
            switch (view.getId()){
                case R.id.button12:
                    c = '+';
                    temp2 = String.valueOf(edit.getText()) + c;
                    dialogue.setText(temp2);
                    edit.setText("");
                    break;
                case R.id.button13:
                    c = '-';
                    temp2 = String.valueOf(edit.getText()) + c;
                    dialogue.setText(temp2);
                    edit.setText("");
                    break;
                case R.id.button14:
                    c = '*';
                    temp2 = String.valueOf(edit.getText()) + c;
                    dialogue.setText(temp2);
                    edit.setText("");
                    break;
                case R.id.button15:
                    c = '/';
                    temp2 = String.valueOf(edit.getText()) + c;
                    dialogue.setText(temp2);
                    edit.setText("");
                    break;
                case R.id.button16:
                    System.out.println("EQUALS HAS BEEN HIT");
                    System.out.println("temp2: "+temp2);
                    temp2 = temp2 + String.valueOf(edit.getText());
                    System.out.println("temp2: "+temp2);
                    try {
                        Object result = i.eval(temp2); //object can be formed to int, double, and string; eval simply evaluates string as mathematical expression
                        System.out.println(result);
                        edit.setText(String.valueOf(result));
                        dialogue.setText(temp2+"="+String.valueOf(result));
                    } catch (EvalError evalError) {
                        evalError.printStackTrace();
                    }
                    break;
                case R.id.button19:
                    dialogue.setText("Enter your equation below");
                    edit.setText("");
                    temp2="";
                    c = 'a';
                    counter = -1;
            }
        }
    }
}
