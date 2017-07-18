package com.example.sandwind.onedemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

/*
    //重写onCreateOptionsMenu方法
*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

/*
        //获取menuinflater对象,创建菜单
*/
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

/*
    //重写onOptionsItemSelected方法
*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "add_item", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
                break;
            case R.id.remove_item:
                Toast.makeText(this, "remove_item", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
/*
        //获取布局文件定义元素吧，得到按钮实例
*/
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(FirstActivity.this,"hello world",Toast.LENGTH_SHORT).show();
                /*//销毁当前活动，退出程序
                //finish();
                //系统的方式实现网而言跳转*/
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });


        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               /*// Toast.makeText(FirstActivity.this,"Hi,Bob",Toast.LENGTH_SHORT).show();
                //parma1:表示上下文   parma2：表示目标活动
                //显示intent
               Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                //隐式intent*/
//                Intent intent = new Intent("com.example.sandwind.onedemo.JUMP");
//                intent.addCategory("com.example.sandwind.onedemo.MY_CATEGORY");
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                String data = "zhangsanfeng";
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }

        });

        Button button3 = (Button)findViewById(R.id.button_3);
        button3.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(FirstActivity.this,ThirdActivity.class);
                /*sstartActivityForResult:在活动销毁的时候返回一个结果给上一个活动*/
                startActivityForResult(intent,1);
            }
        });

    }


    /*重写onActivityResult方法来解析使用startActivityForResult方法获取目标活动销毁后传递的数据*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
/*重写父类方法，不需要先super（）*/
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String returnData = data.getStringExtra("data_return");
                    Toast.makeText(FirstActivity.this,returnData,Toast.LENGTH_SHORT).show();
                    Log.d("FirstActivity",returnData);
                }
                break;
            default:
        }
    }
}
