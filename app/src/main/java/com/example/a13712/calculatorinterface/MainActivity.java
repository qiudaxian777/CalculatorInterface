package com.example.a13712.calculatorinterface;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText tvshow;
    private Button chongxin;
    private Button chu;
    private Button cheng;
    private Button shanchu;
    private Button qi;
    private Button ba;
    private Button jiu;
    private Button jia;
    private Button si;
    private Button wu;
    private Button liu;
    private Button jian;
    private Button yi;
    private Button er;
    private Button san;
    private Button ling;
    private Button dian;
    private Button dengyu;
    private String shuzu="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputMethodManager systemService = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        systemService.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(),0);
        initView();

    }




    private void initView() {
        tvshow = (EditText) findViewById(R.id.tvshow);
        chongxin = (Button) findViewById(R.id.chongxin);
        chu = (Button) findViewById(R.id.chu);
        cheng = (Button) findViewById(R.id.cheng);
        shanchu = (Button) findViewById(R.id.shanchu);
        qi = (Button) findViewById(R.id.qi);
        ba = (Button) findViewById(R.id.ba);
        jiu = (Button) findViewById(R.id.jiu);
        jia = (Button) findViewById(R.id.jia);
        si = (Button) findViewById(R.id.si);
        wu = (Button) findViewById(R.id.wu);
        liu = (Button) findViewById(R.id.liu);
        jian = (Button) findViewById(R.id.jian);
        yi = (Button) findViewById(R.id.yi);
        er = (Button) findViewById(R.id.er);
        san = (Button) findViewById(R.id.san);
        ling = (Button) findViewById(R.id.ling);
        dian = (Button) findViewById(R.id.dian);
        dengyu = (Button) findViewById(R.id.dengyu);

        chongxin.setOnClickListener(this);
        chu.setOnClickListener(this);
        cheng.setOnClickListener(this);
        shanchu.setOnClickListener(this);
        qi.setOnClickListener(this);
        ba.setOnClickListener(this);
        jiu.setOnClickListener(this);
        jia.setOnClickListener(this);
        si.setOnClickListener(this);
        wu.setOnClickListener(this);
        liu.setOnClickListener(this);
        jian.setOnClickListener(this);
        yi.setOnClickListener(this);
        er.setOnClickListener(this);
        san.setOnClickListener(this);
        ling.setOnClickListener(this);
        dian.setOnClickListener(this);
        dengyu.setOnClickListener(this);
        tvshow.setSelection(shuzu.length());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chongxin:
                shuzu="";
                tvshow.setText(0+"");
                break;
            case R.id.chu:
                GetStirin(chu);
                break;
            case R.id.cheng:
                GetStirin(cheng);
                break;
            case R.id.shanchu:

                break;
            case R.id.qi:
                GetStirin(qi);
                break;
            case R.id.ba:
                GetStirin(ba);
                break;
            case R.id.jiu:
                GetStirin(jiu);
                break;
            case R.id.jia:
                GetStirin(jia);
                break;
            case R.id.si:
                GetStirin(si);
                break;
            case R.id.wu:
                GetStirin(wu);
                break;
            case R.id.liu:
                GetStirin(liu);
                break;
            case R.id.jian:
                GetStirin(jian);
                break;
            case R.id.yi:
                GetStirin(yi);
                break;
            case R.id.er:
                GetStirin(er);
                break;
            case R.id.san:
                GetStirin(san);
                break;
            case R.id.ling:
                GetStirin(ling);

                break;
            case R.id.dian:
                GetStirin(dian);
                break;
            case R.id.dengyu:
                GetResult();
                break;
        }
        tvshow.setSelection(shuzu.length());
    }

    public void GetStirin(Button ba){
        String temp= ba.getText()+"";

        shuzu=shuzu+temp;
        tvshow.setText(shuzu);

    }

    public void GetResult(){
        shuzu=tvshow.getText()+"";
        String[] split = shuzu.split("\\+");
        String[] split1 = shuzu.split("\\-");
        String[] split2 = shuzu.split("\\*");
        String[] split3 = shuzu.split("÷");
        double result=0;
        if(split.length==2){
            double   a=  Double.valueOf(split[0]);
            double    b=  Double.valueOf(split[1]);
            result=a+b;
        }else if(split1.length==2){
            double  a=   Double.valueOf(split1[0]);
            double   b=    Double.valueOf(split1[1]);
            result=a-b;

        }else if(split2.length==2){
            double  a=    Double.valueOf(split2[0]);
            double   b=    Double.valueOf(split2[1]);
            result=a*b;

        }else if(split3.length==2){
            double   a=    Double.valueOf(split3[0]);
            double   b=   Double.valueOf(split3[1]);
            result=a/b;

        }
        String rsu=result+"";
        BigDecimal bigDecimal=new BigDecimal(result);
            double aa=bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();

        shuzu="";
        tvshow.setText(aa+"");

    }


}
