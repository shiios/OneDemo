package com.example.sandwind.onedemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.preference.DialogPreference;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*此处添加implements View.OnClickListener*/
public class FirstActivity extends BaseActivity implements View.OnClickListener {

    //    private EditText editText;
//    private ImageView imageView;
    //public static final String TAG = "FirstActivity";
    //private List<Fruit> fruitList = new ArrayList<>();
//
//    /*
//        //重写onCreateOptionsMenu方法
//    */
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
///*
//        //获取menuinflater对象,创建菜单
//*/
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    /*
//        //重写onOptionsItemSelected方法
//    */
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.add_item:
//                Toast.makeText(this, "add_item", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
//                startActivity(intent);
//                break;
//            case R.id.remove_item:
//                Toast.makeText(this, "remove_item", Toast.LENGTH_SHORT).show();
//                Intent intent2 = new Intent(FirstActivity.this,FiveActivity.class);
//                startActivity(intent2);
//                //finish();
//                break;
//            default:
//        }
//        return true;
//    }


//    private void initFruits() {
//
//        for (int i = 0; i < 2; i++) {
//            Fruit apple = new Fruit(getRandomLengthName("apple"), R.drawable.image_search);
//            fruitList.add(apple);
//            Fruit banana = new Fruit(getRandomLengthName("apple"), R.drawable.image_load_fail);
//            fruitList.add(banana);
//            Fruit peach = new Fruit(getRandomLengthName("apple"), R.drawable.image_back);
//            fruitList.add(peach);
//            Fruit apple1 = new Fruit(getRandomLengthName("apple"), R.drawable.image_loading);
//            fruitList.add(apple);
//            Fruit apple2 = new Fruit(getRandomLengthName("apple"), R.drawable.baobiao_light);
//            fruitList.add(apple);
//            Fruit apple77 = new Fruit(getRandomLengthName("apple"), R.drawable.image_load_fail);
//            fruitList.add(apple);
//            Fruit banana66 = new Fruit(getRandomLengthName("apple"), R.drawable.image_load_fail);
//            fruitList.add(banana);
//            Fruit peach55 = new Fruit(getRandomLengthName("apple"), R.drawable.image_load_fail);
//            fruitList.add(peach);
//            Fruit apple4 = new Fruit(getRandomLengthName("apple"), R.drawable.image_load_fail);
//            fruitList.add(apple);
//            Fruit apple23 = new Fruit(getRandomLengthName("apple"), R.drawable.image_load_fail);
//            fruitList.add(apple);
//            Fruit apple33 = new Fruit(getRandomLengthName("apple"), R.drawable.image_load_fail);
//            fruitList.add(apple);
//            Fruit banana333 = new Fruit(getRandomLengthName("apple"), R.drawable.image_load_fail);
//            fruitList.add(banana);
//            Fruit peach3333 = new Fruit(getRandomLengthName("apple"), R.drawable.image_load_fail);
//            fruitList.add(peach);
//            Fruit apple1333 = new Fruit(getRandomLengthName("apple"), R.drawable.image_load_fail);
//            fruitList.add(apple);
//            Fruit apple23333 = new Fruit(getRandomLengthName("apple"), R.drawable.image_load_fail);
//            fruitList.add(apple);
//            Fruit apple33333 = new Fruit(getRandomLengthName("apple"), R.drawable.image_load_fail);
//            fruitList.add(apple);
//            Fruit banana444 = new Fruit(getRandomLengthName("apple"), R.drawable.image_load_fail);
//            fruitList.add(banana);
//            Fruit peach44 = new Fruit(getRandomLengthName("apple"), R.drawable.image_load_fail);
//            fruitList.add(peach);
//            Fruit apple155 = new Fruit(getRandomLengthName("apple"), R.drawable.image_load_fail);
//            fruitList.add(apple);
//            Fruit apple266 = new Fruit(getRandomLengthName("apple"), R.drawable.image_load_fail);
//            fruitList.add(apple);
//            Fruit apple707 = new Fruit(getRandomLengthName("apple"), R.drawable.image_load_fail);
//            fruitList.add(apple);
//            Fruit banana88 = new Fruit(getRandomLengthName("apple"), R.drawable.image_load_fail);
//            fruitList.add(banana);
//            Fruit peach67= new Fruit(getRandomLengthName("apple"), R.drawable.image_load_fail);
//            fruitList.add(peach);
//            Fruit apple55 = new Fruit(getRandomLengthName("apple"), R.drawable.baobiao_normal);
//            fruitList.add(apple);
//            Fruit apple255 = new Fruit(getRandomLengthName("apple"), R.drawable.bg_gray1);
//            fruitList.add(apple);
//
//        }
//    }
//
//
//    private String getRandomLengthName(String name){
//        Random random = new Random();
//        int length = random.nextInt(20) + 1;
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0;i < length;i++){
//            builder.append(name);
//        }
//        return builder.toString();
//    }


//
//    private List<Msg> msgList = new ArrayList<>();
//    private EditText inputText;
//    private Button send;
//    private RecyclerView msgRecyclerView;
//    private MsgAdapter msgAdapter;

//    private void initMsgs() {
//        Msg msg1 = new Msg("hello guy", Msg.TYPE_RECEIVED);
//        msgList.add(msg1);
//        Msg msg2 = new Msg("hi boy", Msg.TYPE_SEND);
//        msgList.add(msg2);
//        Msg msg3 = new Msg("This is tom", Msg.TYPE_RECEIVED);
//        msgList.add(msg3);
//
//
//    }


    //HttpURLConnection
    TextView responseText;

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_request) {
            //sendGETResWithUrl();
            sendPOSTResWithUrl();

        }
    }

    //POST方法
    private void sendPOSTResWithUrl() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url("http://172.21.28.26/one.json").build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    //parseSystemJSONWithObject(responseData);
                    parseGSONJSONWithObject(responseData);
                    showResponse(responseData);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    //GSON解析JSON数据：parseGSONJSONWithObject
    private void parseGSONJSONWithObject(String jsonData){
        Gson gson = new Gson();
        List<App> appList = gson.fromJson(jsonData,new TypeToken<List<App>>(){}.getType());
        for (App app :appList){
            Log.d("FirstActivity 123","id is "+app.getId());
            Log.d("FirstActivity 123","id is "+app.getName());
            Log.d("FirstActivity 123","id is "+app.getVersion());
        }
    }

    //系统方式解析json数据
    private void parseSystemJSONWithObject(String jsonData){

        try {

            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length();i++){
                //系统解析方式
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String version = jsonObject.getString("version");
                String name = jsonObject.getString("name");
                Log.d("FirstActivity","id is " + id);
                Log.d("FirstActivity","version is " + version );
                Log.d("FirstActivity","name is " + name );

            }

            //主线程异常
//            Toast.makeText(FirstActivity.this,"解析成功",Toast.LENGTH_SHORT).show();


        }catch (Exception e){
            e.printStackTrace();
        }


    }

    //GET方法
    private void sendGETResWithUrl() {
        //开启线程进行网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {

                HttpURLConnection connection = null;
                BufferedReader reader = null;

                try {

                    URL url = new URL("http://www.cocoachina.com");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream stream = connection.getInputStream();

                    //读取输入流
                    reader = new BufferedReader(new InputStreamReader(stream));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {

                        response.append(line);
                    }

                    showResponse(response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (connection != null) {
                        connection.disconnect();
                    }
                }


            }

        }).start();
    }

    private void showResponse(final String response) {
        //运行UI线程
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

//                Toast.makeText(FirstActivity.this,"1234",Toast.LENGTH_SHORT).show();
                 String res = response;
                Log.d("response", res);
                responseText.setText(response);

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        Log.d("FirstActivity", "Task id is" + getTaskId());
        setContentView(R.layout.first_layout);

        //HttpURLConnection
        Button sendRes = (Button) findViewById(R.id.btn_request);
        responseText = (TextView) findViewById(R.id.Response_Data);
        sendRes.setOnClickListener(this);


        //webview加载网页
//        WebView webView = (WebView)findViewById(R.id.webView);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.setWebViewClient(new WebViewClient());
//        webView.loadUrl("http://baidu.com");


        //聊天
//        initMsgs();
//
//        inputText = (EditText)findViewById(R.id.input_text);
//        send = (Button)findViewById(R.id.send);
//        msgRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        msgRecyclerView.setLayoutManager(layoutManager);
//        msgAdapter = new MsgAdapter(msgList);
//        msgRecyclerView.setAdapter(msgAdapter);
//
//        send.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                String content = inputText.getText().toString();
//                if (!"".equals(content)){
//                    Msg msg = new Msg(content,Msg.TYPE_SEND);
//                    msgList.add(msg);
//                    //当有新的消息的时候
//                    msgAdapter.notifyItemInserted(msgList.size() - 1);
//                    //定位消息到最后一行
//                    msgRecyclerView.scrollToPosition(msgList.size() - 1);
//                    //情况输入框内容
//                    inputText.setText("");
//                }
//            }
//        });

//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar !=null){
//            actionBar.hide();
//        }

        // initFruits();

        //RecyclerView:LayoutManager
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        //StaggeredGridLayoutManager(int spanCount, int orientation):spanCount:列数   orientation:排列方向
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
//        //设置此处来决定数据的展示方向
//        recyclerView.setLayoutManager(layoutManager);
//        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(fruitList);
//        recyclerView.setAdapter(recyclerViewAdapter);


        //RecyclerView:LayoutManager
//        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        //设置此处来决定数据的展示方向
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recyclerView.setLayoutManager(layoutManager);
//        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(fruitList);
//        recyclerView.setAdapter(recyclerViewAdapter);


        //ListView
//        FruitAdapter fruitAdapter = new FruitAdapter(FirstActivity.this, R.layout.fruit_item, fruitList);
//        ListView listView = (ListView) findViewById(R.id.list_view);
//        listView.setAdapter(fruitAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Fruit fruit = fruitList.get(i);
//                System.out.print("int" + i);
//                System.out.print("long" + l);
//                Toast.makeText(FirstActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                FirstActivity.this, android.R.layout.simple_list_item_1, data
//        );
//        ListView listView = (ListView) findViewById(R.id.list_view);
//        listView.setAdapter(adapter);



/*
        //获取布局文件定义元素吧，得到按钮实例
*/
//        final Button button1 = (Button) findViewById(R.id.button_1);
//        button1.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                button1.setText("123");
//                Toast.makeText(FirstActivity.this,"hello world",Toast.LENGTH_SHORT).show();
//                /*//销毁当前活动，退出程序
//                //finish();
//                //系统的方式实现网而言跳转*/
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                //intent.setData(Uri.parse("tel:10086"));
//                startActivity(intent);
//            }
//        });


//        Button buttton1 = (Button) findViewById(R.id.button_1);
//        buttton1.setOnClickListener(this);

//        editText = (EditText) findViewById(R.id.edit_text);
//        imageView = (ImageView) findViewById(R.id.image_view);


//        Button button2 = (Button) findViewById(R.id.button_2);
//        button2.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
               /*// Toast.makeText(FirstActivity.this,"Hi,Bob",Toast.LENGTH_SHORT).show();
                //parma1:表示上下文   parma2：表示目标活动
                //显示intent
               Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                //隐式intent*/
//                Intent intent = new Intent("com.example.sandwind.onedemo.JUMP");
//                intent.addCategory("com.example.sandwind.onedemo.MY_CATEGORY");
//                Intent intent = new Intent(FirstActivity.this,FourActivity.class);
////                String data = "zhangsanfeng";
////                intent.putExtra("extra_data",data);
//                startActivity(intent);

        //FourActivity.actionStart(FirstActivity.this,"123","456");

//            }
//
//        });

//        Button button3 = (Button)findViewById(R.id.button_3);
//        button3.setOnClickListener(new  View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent intent = new Intent(FirstActivity.this,ThirdActivity.class);
//                /*sstartActivityForResult:在活动销毁的时候返回一个结果给上一个活动*/
//                startActivityForResult(intent,1);
//            }
//        });

    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.button_1:
//                /*取出EditText中输入的值
//                * Editable 也是可以直接通过弹框显示的
//                * Editable inPutText = editText.getText();
//                * */
//                String inPutText = editText.getText().toString();
//                Toast.makeText(FirstActivity.this, inPutText, Toast.LENGTH_SHORT).show();
//                imageView.setImageResource(R.drawable.image_back);
//
//
//                AlertDialog.Builder dialog = new AlertDialog.Builder(FirstActivity.this);
//                dialog.setTitle("This is a dialog");
//                dialog.setMessage("something is important");
//                dialog.setCancelable(false);
//                dialog.setPositiveButton("OK",new DialogInterface.OnClickListener(){
//                    @Override
//                    public void onClick(DialogInterface dialog,int which){
//
//                    }
//                });
//                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog,int which){
//
//                    }
//                });
//                dialog.show();
//
//
//
//
//
//
//                break;
//            default:
//                break;
//        }
//    }


    /*重写onActivityResult方法来解析使用startActivityForResult方法获取目标活动销毁后传递的数据*/
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
///*重写父类方法，不需要先super（）*/
//        switch (requestCode) {
//            case 1:
//                if (resultCode == RESULT_OK) {
//                    String returnData = data.getStringExtra("data_return");
//                    Toast.makeText(FirstActivity.this, returnData, Toast.LENGTH_SHORT).show();
//                    Log.d("FirstActivity", returnData);
//                }
//                break;
//            default:
//        }
//    }


//    list_view


//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d(TAG, "onStart");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d(TAG, "onResume");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.d(TAG, "onPause");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d(TAG, "onStop");
//    }
//
//    /*执行finish（）方法时，会调用此生命周期方法*/
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d(TAG, "onDestroy");
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.d(TAG, "onRestart");
//    }
}

