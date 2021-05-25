package com.example.a36_calc_fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class InputFragment extends Fragment implements View.OnClickListener{
    EditText firstNum;
    EditText secondNum;
    String message;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button1 = (Button) getView().findViewById(R.id.plusButton);
        button1.setOnClickListener(this);

        Button button2 = (Button) getView().findViewById(R.id.minusButton);
        button2.setOnClickListener(this);

        Button button3 = (Button) getView().findViewById(R.id.umnButton);
        button3.setOnClickListener(this);

        Button button4 = (Button) getView().findViewById(R.id.delButton);
        button4.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        firstNum = (EditText) getView().findViewById(R.id.first);
        secondNum = (EditText) getView().findViewById(R.id.second);
        if (firstNum.getText().length()>0 && secondNum.getText().length()>0){

        //String nameValue = firstNum.getText().toString();
        double a = Double.parseDouble(String.valueOf(firstNum.getText()));
        double b = Double.parseDouble(String.valueOf(secondNum.getText()));

        String buttonNum = "";
        switch (v.getId()){
            case R.id.plusButton:
                a+=b;
                break;
            case R.id.minusButton:
                a-=b;
                break;
            case R.id.umnButton:
                a*=b;
                break;
            case R.id.delButton:
                a/=b;
                break;

        }
        message = "Answer: " + a;


        } else message = "Enter the number(s)!";
        MessageFragment fragment = (MessageFragment)getFragmentManager().findFragmentById(R.id.fragment_answer);
        fragment.setMessage(message);
    }
}
