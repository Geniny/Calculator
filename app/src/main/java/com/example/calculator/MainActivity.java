package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity implements BasicFuncFragment.FragmentListener {



    static final String tag_engin = "engin";
    static final String tag_basic = "basic";
    BasicFuncFragment basicFragment;
    EngFuncFragment engFragment;
    FragmentManager fm;
    TextView tw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tw = findViewById(R.id.textView2);
        tw.setOnClickListener(twListener);
        getSupportActionBar().hide();



        int orientation = this.getResources().getConfiguration().orientation;
        if (orientation != Configuration.ORIENTATION_LANDSCAPE) {
            fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            basicFragment = new BasicFuncFragment();

            if(fm.findFragmentByTag(tag_basic) == null) {
                ft.add(R.id.frame, basicFragment, tag_basic);
            }
            else
            {
                ft.replace(R.id.frame, basicFragment, tag_basic);
            }
            ft.commit();

            if (savedInstanceState != null)
                tw.setText(savedInstanceState.getString("textView2"));
        }
        else
        {
            tw.setOnClickListener(null);
            if (savedInstanceState != null)
                tw.setText(savedInstanceState.getString("textView2"));
        }

    }

    @Override
    public void onSaveInstanceState(Bundle saveInstance)
    {
        saveInstance.putString("textView2", tw.getText().toString());
        super.onSaveInstanceState(saveInstance);
    }

    private View.OnClickListener twListener = new View.OnClickListener()
    {

        public void onClick(View v)
        {


            FrameLayout frame = findViewById(R.id.frame);
            if(fm.findFragmentByTag(tag_engin) == null)
            {
                FragmentTransaction ft = fm.beginTransaction();
                engFragment = new EngFuncFragment();
                ft.replace(R.id.frame, engFragment, tag_engin);
                frame.setScaleY(0.7f);
                ft.commit();
            }
            else
            {
                frame.setScaleY(1f);
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame, basicFragment, tag_basic);
                ft.commit();
            }
        }
    };

    @Override
    public void FragmentListener(int id) {
        Clicked(id);
    }

    public void Clicked(int id)
    {
        TextView tw = findViewById(R.id.textView2);
        StringBuilder str = new StringBuilder(tw.getText().toString());

        switch (id)
        {
            case R.id.char0:
                tw.setText(str + "0");
                break;
            case R.id.char1:
                tw.setText(str + "1");
                break;
            case R.id.char2:
                tw.setText(str + "2");
                break;
            case R.id.char3:
                tw.setText(str+"3");
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
                if (str != null && str.length() != 0) {
                    char[] arr = str.toString().toCharArray();
                    int countToDelete = 1;
                    for (int i = str.length() - 2; i > 0; i--){
                        if (arr[i] >= 'a' && arr[i] <= 'z'){
                            countToDelete++;
                        } else{
                            break;
                        }
                    }
                    if (countToDelete + 1 == str.length()){
                        tw.setText("");
                        break;
                    }
                    tw.setText(str.substring(0, str.length() - countToDelete));
                    return;
                }

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
