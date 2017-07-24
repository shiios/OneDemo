package com.example.sandwind.onedemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends BaseActivity {


    public static void actionStart(Context context, String data1, String data2){
        Intent intent = new Intent(context,SecondActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.third_layout);

        Button btn5 = (Button)findViewById(R.id.Button_5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("data_return","hello FirstActivity");
                /*setResult:此方法专门用于向上一个活动返回数据的，有两个参数：param1:返回处理结果，param2：将带有数据的intent传递回去*/
                setResult(RESULT_OK,intent);
                String data = intent.getStringExtra("data_return");
                Toast.makeText(ThirdActivity.this,data,Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
