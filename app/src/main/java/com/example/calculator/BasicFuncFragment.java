package com.example.calculator;

import org.mariuszgromada.math.mxparser.Expression;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class BasicFuncFragment extends Fragment implements View.OnClickListener{

    public interface FragmentListener {
        void FragmentListener(int id);
    }

    private FragmentListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_basic_func, container, false);
        view.findViewById(R.id.char1).setOnClickListener(this);
        view.findViewById(R.id.char2).setOnClickListener(this);
        view.findViewById(R.id.char3).setOnClickListener(this);
        view.findViewById(R.id.char4).setOnClickListener(this);
        view.findViewById(R.id.char5).setOnClickListener(this);
        view.findViewById(R.id.char6).setOnClickListener(this);
        view.findViewById(R.id.char7).setOnClickListener(this);
        view.findViewById(R.id.char8).setOnClickListener(this);
        view.findViewById(R.id.char9).setOnClickListener(this);
        view.findViewById(R.id.char0).setOnClickListener(this);
        view.findViewById(R.id.charDel).setOnClickListener(this);
        view.findViewById(R.id.charDiv).setOnClickListener(this);
        view.findViewById(R.id.charDot).setOnClickListener(this);
        view.findViewById(R.id.charMul).setOnClickListener(this);
        view.findViewById(R.id.charBracket1).setOnClickListener(this);
        view.findViewById(R.id.charEqual).setOnClickListener(this);
        view.findViewById(R.id.charBracket2).setOnClickListener(this);
        view.findViewById(R.id.charPlus).setOnClickListener(this);
        view.findViewById(R.id.charMinus).setOnClickListener(this);
        view.findViewById(R.id.charClear).setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener) {
            mListener = (FragmentListener) context;
        }
    }

    @Override
    public void onClick(View v)
    {
        TextView tw = getActivity().findViewById(R.id.textView2);
        String str = "";

        switch (v.getId())
        {
            case R.id.char0:
                mListener.FragmentListener(R.id.char0);
                break;
            case R.id.char1:
                mListener.FragmentListener(R.id.char1);
                break;
            case R.id.char2:
                mListener.FragmentListener(R.id.char2);
                break;
            case R.id.char3:
                mListener.FragmentListener(R.id.char3);
                break;
            case R.id.char4:
                tw.setText(str + "4");
                break;
            case R.id.char5:
                tw.setText(str + "5");
                break;
            case R.id.char6:
                tw.setText(str + "6");
                break;
            case R.id.char7:
                tw.setText(str + "7");
                break;
            case R.id.char8:
                tw.setText(str + "8");
                break;
            case R.id.char9:
                tw.setText(str + "9");
                break;
            case R.id.charPlus:
                tw.setText(str + "+");
                break;
            case R.id.charEqual:
                 tw.setText(Double.toString(new Expression(str.toString()).calculate()));
                break;
            case R.id.charDel:
                mListener.FragmentListener(R.id.charDel);
                break;
            case R.id.charMul:
                tw.setText(str+"*");
                break;
            case R.id.charDiv:
                tw.setText(str+"/");
                break;
            case R.id.charBracket1:
                tw.setText(str+"(");
                break;
            case R.id.charBracket2:
                tw.setText(str +")");
                break;
            case R.id.charMinus:
                tw.setText(str + "-");
                break;
            case R.id.charDot:
                tw.setText(str + ".");
                break;
            case R.id.charClear:
                tw.setText("");
                break;

        }

    }

}
