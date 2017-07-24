package com.example.sandwind.onedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SectionActivity", "Task id is" + getTaskId());
        setContentView(R.layout.activity_second);
        Button btn3 = (Button) findViewById(R.id.button_3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            /*注意方法名称的大小写*/
            public void onClick(View v) {
//                Intent intent = getIntent();
//                String data = intent.getStringExtra("extra_data");
//                Toast.makeText(SecondActivity.this, data, Toast.LENGTH_SHORT).show();
//
//                Log.d("SecondActivity", data);
//                Intent intent = new Intent(SecondActivity.this,FourActivity.class);
//                intent.putExtra("param1","data1");
//                intent.putExtra("param2","data2");
//                startActivity(intent);

                ThirdActivity.actionStart(SecondActivity.this,"data1","data2");
            }
        });
    }
}
