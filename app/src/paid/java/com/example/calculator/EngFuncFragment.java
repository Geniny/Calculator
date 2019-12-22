package com.example.calculator;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

public class EngFuncFragment extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_eng_func, container, false);
        view.findViewById(R.id.cos).setOnClickListener(this);
        view.findViewById(R.id.sin).setOnClickListener(this);
        view.findViewById(R.id.tan).setOnClickListener(this);
        view.findViewById(R.id.ctan).setOnClickListener(this);
        view.findViewById(R.id.acos).setOnClickListener(this);
        view.findViewById(R.id.asin).setOnClickListener(this);
        view.findViewById(R.id.atan).setOnClickListener(this);
        view.findViewById(R.id.actan).setOnClickListener(this);
        view.findViewById(R.id.fact).setOnClickListener(this);
        view.findViewById(R.id.xcube).setOnClickListener(this);
        view.findViewById(R.id.logxy).setOnClickListener(this);
        view.findViewById(R.id.xreverse).setOnClickListener(this);
        view.findViewById(R.id.xsqrt).setOnClickListener(this);
        view.findViewById(R.id.xsquare).setOnClickListener(this);
        view.findViewById(R.id.xiny).setOnClickListener(this);
        view.findViewById(R.id.teninx).setOnClickListener(this);
        view.findViewById(R.id.pi).setOnClickListener(this);
        view.findViewById(R.id.exp).setOnClickListener(this);
        view.findViewById(R.id.log).setOnClickListener(this);
        view.findViewById(R.id.ln).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        TextView tw = getActivity().findViewById(R.id.textView2);
        StringBuilder str = new StringBuilder(tw.getText().toString());

        switch (v.getId())
        {
            case R.id.cos:
                tw.setText(str + "cos(");
                break;
            case R.id.sin:
                tw.setText(str + "sin(");
                break;
            case R.id.tan:
                tw.setText(str + "tan(");
                break;
            case R.id.ctan:
                tw.setText(str + "ctan(");
                break;
            case R.id.asin:
                tw.setText(str + "asin(");
                break;
            case R.id.acos:
                tw.setText(str + "acos(");
                break;
            case R.id.atan:
                tw.setText(str + "atan(");
                break;
            case R.id.actan:
                tw.setText(str + "actan(");
                break;
            case R.id.pi:
                tw.setText(str + "pi");
                break;
            case R.id.exp:
                tw.setText(str + "exp(");
                break;
            case R.id.teninx:
                tw.setText(str + "10^(");
                break;
            case R.id.xsqrt:
                tw.setText(Double.toString(new Expression(str.toString()+"^1/2").calculate()));
                break;
            case R.id.log:
                tw.setText(str + "log(10,");
                break;
            case R.id.ln:
                tw.setText(str + "ln(");
                break;
            case R.id.logxy:
                tw.setText("log("+ str + ",");
                break;
            case R.id.fact:
                tw.setText(Double.toString(new Expression("("+str.toString()+")!").calculate()));
                break;
            case R.id.xreverse:
                tw.setText(Double.toString(new Expression("1/("+str.toString()+")").calculate()));
                break;
            case R.id.xsquare:
                tw.setText(Double.toString(new Expression("("+str.toString()+")^2").calculate()));
                break;
            case R.id.xcube:
                tw.setText(Double.toString(new Expression("("+str.toString()+")^3").calculate()));
                break;
            case R.id.xiny:
                tw.setText("("+str+")^");
                break;

        }

    }


}
