package com.example.sandwind.onedemo;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by sandwind on 2017/7/24.
 */

public class TtileLayout extends LinearLayout {

    public TtileLayout(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
        LayoutInflater.from(context).inflate(R.layout.title,this);

        Button titleBack = (Button)findViewById(R.id.title_back);
        Button rightBtn = (Button)findViewById(R.id.title_right);
        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                /*强制转换类型为活动来调用活动的finish方法*/
                ((Activity)getContext()).finish();
            }
        });

        rightBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Please right",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
