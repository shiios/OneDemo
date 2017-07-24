package com.example.sandwind.onedemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FourActivity extends BaseActivity {

    public static void actionStart(Context context,String data1,String data2){
        Intent intent = new Intent(context,SecondActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FourActivity","Task id is " + getTaskId());
        setContentView(R.layout.four_layout);

        Button btn6 = (Button)findViewById(R.id.Button_6);
        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ActivityCollector.finishAll();

            }
        });

    }




}
