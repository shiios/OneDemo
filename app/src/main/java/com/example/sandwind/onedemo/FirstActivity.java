package com.example.sandwind.onedemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.IBinder;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.preference.DialogPreference;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
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
import org.litepal.tablemanager.Connector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.jar.Manifest;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import until.HttpCallBackListener;
import until.HttpUntil;

import static android.R.layout.simple_list_item_1;

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
//    TextView responseText;

//    @Override
//    public void onClick(View view) {
//        if (view.getId() == R.id.btn_request) {
//            //sendGETResWithUrl();
//           // sendPOSTResWithUrl();


//            String address = "http://172.21.28.26/one.json";
//            HttpUntil.sendHttpRequest(address, new HttpCallBackListener() {
//                @Override
//                public void onFinish(String response) {
//                    //parseSystemJSONWithObject(response);s
//                    showResponse(response);
//                    Log.d("response",response);
//                    parseGSONJSONWithObject(response);
//                }
//
//                @Override
//                public void onError(Exception e) {
//
//
//                }
//            });


//            HttpUntil.sendOkHttpResquest("http://172.21.28.26/one.json",new okhttp3.Callback(){
//
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
//                    String responseData = response.body().string();
//                    Log.d("res",responseData);
//                    showResponse(responseData);
//                   // parseGSONJSONWithObject(responseData);
//                    parseSystemJSONWithObject(responseData);
//                }
//
//                @Override
//                public void onFailure(Call call, IOException e) {
//
//                }
//            });

//
//        }
//    }

//    //POST方法
//    private void sendPOSTResWithUrl() {
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//
//                    OkHttpClient client = new OkHttpClient();
//                    Request request = new Request.Builder().url("http://172.21.28.26/one.json").build();
//                    Response response = client.newCall(request).execute();
//                    String responseData = response.body().string();
//                    parseSystemJSONWithObject(responseData);
//                    //parseGSONJSONWithObject(responseData);
//                    showResponse(responseData);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//
//    }
//
//    //GSON解析JSON数据：parseGSONJSONWithObject
//    private void parseGSONJSONWithObject(String jsonData) {
//        Gson gson = new Gson();
//        List<App> appList = gson.fromJson(jsonData, new TypeToken<List<App>>() {
//        }.getType());
//        for (App app : appList) {
//            Log.d("FirstActivity 123", "id is " + app.getId());
//            Log.d("FirstActivity 123", "id is " + app.getName());
//            Log.d("FirstActivity 123", "id is " + app.getVersion());
//        }
//
//    }
//
//    //系统方式解析json数据
//    private void parseSystemJSONWithObject(String jsonData) {
//
//        try {
//
//            JSONArray jsonArray = new JSONArray(jsonData);
//            for (int i = 0; i < jsonArray.length(); i++) {
//                //系统解析方式
//                //获取单个对象
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                String id = jsonObject.getString("id");
//                String version = jsonObject.getString("version");
//                String name = jsonObject.getString("name");
//                Log.d("FirstActivity", "id is " + id);
//                Log.d("FirstActivity", "version is " + version);
//                Log.d("FirstActivity", "name is " + name);
//
//            }
//
//            //主线程异常
////            Toast.makeText(FirstActivity.this,"解析成功",Toast.LENGTH_SHORT).show();
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    //GET方法
//    private void sendGETResWithUrl() {
//        //开启线程进行网络请求
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                HttpURLConnection connection = null;
//                BufferedReader reader = null;
//
//                try {
//
//                    URL url = new URL("http://www.cocoachina.com");
//                    connection = (HttpURLConnection) url.openConnection();
//                    connection.setRequestMethod("GET");
//                    connection.setConnectTimeout(8000);
//                    connection.setReadTimeout(8000);
//                    InputStream stream = connection.getInputStream();
//
//                    //读取输入流
//                    reader = new BufferedReader(new InputStreamReader(stream));
//                    StringBuilder response = new StringBuilder();
//                    String line;
//                    while ((line = reader.readLine()) != null) {
//
//                        response.append(line);
//                    }
//
//                    showResponse(response.toString());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    if (reader != null) {
//                        try {
//                            reader.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    if (connection != null) {
//                        connection.disconnect();
//                    }
//                }
//
//
//            }
//
//        }).start();
//    }
//
//    private void showResponse(final String response) {
//        //运行UI线程
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//
////                Toast.makeText(FirstActivity.this,"1234",Toast.LENGTH_SHORT).show();
//                String res = response;
//                Log.d("response", res);
//                responseText.setText(response);
//
//            }
//        });
//    }


    //发送通知


//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.send_voice:
//
//                Intent intent = new Intent(this,FiveActivity.class);
//                PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
//
//                NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
//                Notification notification = new NotificationCompat.Builder(this)
//                        .setContentTitle("紧急通知")
//                        //.setContentText("hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!")
//                        .setWhen(System.currentTimeMillis())
//                        //设置通知优先级直接弹窗显示
//                        .setPriority(NotificationCompat.PRIORITY_MAX)
//                        //展示更多的通知栏文字
//                        .setStyle(new NotificationCompat.BigTextStyle().bigText("hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello  world!hello "))
//                        .setSmallIcon(R.mipmap.ic_launcher)
//                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
//                        .setContentIntent(pi)
//                        .setVibrate(new long[]{0,1000,1000,1000})
//                        .setDefaults(NotificationCompat.DEFAULT_ALL)
//                        //.setLights(Color.GREEN,1000,1000)
//                       // .setAutoCancel(true)
//                        .build();
//                manager.notify(1,notification);
//                break;
//            default:
//                break;
//        }
//    }

//    //拍照
//    public static final int TAKE_PHOTO = 1;
//    //选择照片
//    public static final int CHOOSE_PHOTO = 2;
//    private ImageView picture;
//    private Uri imageUri;
//
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        switch (requestCode) {
//            case TAKE_PHOTO:
//                if (resultCode == RESULT_OK) {
//                    try {
//                        //显示拍照照片
//                        Log.d("showimage", imageUri.toString());
//                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
//                        //此处应当注意setImageBitmap与setImageInt，要看清上面的参数是什么
//                        picture.setImageBitmap(bitmap);
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                break;
//            case CHOOSE_PHOTO:
//                if (resultCode == RESULT_OK) {
//                    //判断手机系统版本
////                    if (Build.VERSION.SDK_INT >= 19) {
////                        //4.4及以上系统使用这个方法处理图片
////                        handleImageOnKitKat(data);
////                    } else {
////                        //4.4以下系统使用这个方法处理图片
////                        handleImageBeforeKitKat(data);
////                    }
//                    //4.4以下系统使用这个方法处理图片
//                    handleImageOnKitKat(data);
//                }
//            default:
//                break;
//        }
//    }
//
//    //
//    private void handleImageBeforeKitKat(Intent data) {
//        Uri uri = data.getData();
//        String imagePath = getImagePath(uri, null);
//        displayImage(imagePath);
//    }
//
//    //根据图片路径显示图片
//    private void displayImage(String imagePath) {
//
//        if (imagePath != null) {
//            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
//            picture.setImageBitmap(bitmap);
//        } else {
//            Toast.makeText(this, "failed to get image", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    //4.4以上系统
//    private void handleImageOnKitKat(Intent data) {
//        String imagePath = null;
//        Uri uri = data.getData();
//        if (DocumentsContract.isDocumentUri(this, uri)) {
//            //如果Document类型的uri，则使用documentid处理'
//            String docId = DocumentsContract.getDocumentId(uri);
//            if ("com.android.providers.media.document".equals(uri.getAuthority())) {
//                String id = docId.split(":")[1];
//                String selection = MediaStore.Images.Media._ID + "=" + id;
//                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
//
//            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
//                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
//                imagePath = getImagePath(contentUri, null);
//            }
//        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
//            //如果是content类型的Uri，则使用普通方式处理
//            imagePath = getImagePath(uri, null);
//        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
//            imagePath = getImagePath(null, null);
//        }
//        //根据图片路径显示图片
//        displayImage(imagePath);
//    }
//
//    //获取图片路径
//    private String getImagePath(Uri uri, String selection) {
//
//        String path = null;
//        //通过uri和selection来获取图片的真实路径
//        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
//        if (cursor != null) {
//            if (cursor.moveToFirst()) {
//                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
//
//            }
//            cursor.close();
//        }
//
//        return path;
//
//    }
//
//
//    //选择照片
//    private void openAlbum() {
//        Intent intent = new Intent("android.intent.action.GET_CONTENT");
//        intent.setType("image/*");
//        startActivityForResult(intent, CHOOSE_PHOTO);
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//
//        switch (requestCode) {
//            case 1:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    openAlbum();
//                } else {
//                    Toast.makeText(this, "You denied the permission", Toast.LENGTH_SHORT).show();
//                }
//                break;
//            default:
//                break;
//        }
//    }


    //运行时动态替换fragment
//    private void replaceFragment(Fragment fragment) {
//
//        FragmentManager fragmentManagetr = getSupportFragmentManager();
//        FragmentTransaction transaction = fragmentManagetr.beginTransaction();
//        transaction.replace(R.id.right_layout, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//
//    }
//
//    //点击一次在栈中添加了一个碎片，返回的时候就需要多返回几次
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.button_fragment:
//                //replaceFragment(new AnotherRightFragment());
//                break;
//            default:
//                break;
//        }
//    }


//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        String inputText = editText.getText().toString();
//        editText = (EditText)findViewById(R.id.edit);
//        save(inputText);
//    }

//    public void save(String inputText){
//
//        FileOutputStream outputStream = null;
//        BufferedWriter bufferedWriter = null;
//
//        try {
//
//            outputStream = openFileOutput("data", Context.MODE_PRIVATE);
//            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
//            bufferedWriter.write(inputText);
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }finally {
//
//            try {
//                if (bufferedWriter != null){
//                    bufferedWriter.close();
//                }
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//
//
//    }
//
//    public String load(){
//
//        FileInputStream inputStream = null;
//        BufferedReader reader = null;
//        StringBuilder stringBuilder = new StringBuilder();
//        try {
//
//            inputStream = openFileInput("data");
//            reader = new BufferedReader(new InputStreamReader(inputStream));
//
//            String line = "";
//            while ((line = reader.readLine()) != null){
//                stringBuilder.append(line);
//            }
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }finally {
//
//            if (reader != null){
//                try {
//                    reader.close();
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        return stringBuilder.toString();
//
//    }
//    private EditText editText;

//    private SharedPreferences preferences;
//    private SharedPreferences.Editor editor;
//
//    private EditText accountText;
//    private EditText passwordText;
//    private CheckBox checkBox;
//    private Button loginButton;

//    private MyDatabaseHelper database;
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//
//        switch (requestCode){
//            case 1:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                    call();
//                }else {
//                    Toast.makeText(FirstActivity.this,"deny",Toast.LENGTH_SHORT).show();
//                }
//                break;
//            default:
//        }
//    }
//
//    private  void call(){
//        try {
//
//            Intent intent = new Intent(Intent.ACTION_CALL);
//            intent.setData(Uri.parse("tel:100000"));
//            startActivity(intent);
//        }catch (SecurityException e){
//            e.printStackTrace();
//        }
//    }

//    public static final int UPDATE_TEXT = 1;
//
//    private TextView textView;
//
//
//    android.os.Handler handler = new android.os.Handler(){
//
//        @Override
//        public void handleMessage(Message msg) {
//
//            switch (msg.what){
//                case UPDATE_TEXT:
//                    textView.setText("Nice to meet you !");
//                    break;
//                default:
//                    break;
//            }
//
//        }
//    };

//    private Handler handler = new Handler() {
//
//        public void handleMessage(Message msg){
//            switch (msg.what){
//                case UPDATE_TEXT:
//                    textView.setText("Nice to meet you !");
//                    break;
//                default:
//                    break;
//            }
//        }
//    };


//    private MyService.DowmloadBinder dowmloadBinder;
//
//    private ServiceConnection connection = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
//
//            dowmloadBinder = (MyService.DowmloadBinder) iBinder;
//            dowmloadBinder.startDownload();
//            dowmloadBinder.getProgress();
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName componentName) {
//
//        }
//    };


    private DownlaodService.DownloadBinder downloadBinder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            downloadBinder = (DownlaodService.DownloadBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        Log.d("FirstActivity", "Task id is" + getTaskId());
        setContentView(R.layout.first_layout);

        Button startDownload = (Button) findViewById(R.id.start_download);
        Button pausedDownload = (Button) findViewById(R.id.paused_download);
        Button cancelDownload = (Button) findViewById(R.id.cancel_download);
        startDownload.setOnClickListener(this);
        pausedDownload.setOnClickListener(this);
        cancelDownload.setOnClickListener(this);

        Intent intent = new Intent(this,DownlaodService.class);
        startService(intent);
        bindService(intent,connection,BIND_AUTO_CREATE);
        if (ContextCompat.checkSelfPermission(FirstActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(FirstActivity.this,new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }
//        Button uBindBtn = (Button) findViewById(R.id.uBind_service);
//        Button bindpBtn = (Button) findViewById(R.id.bind_service);
//        uBindBtn.setOnClickListener(this);
//        bindpBtn.setOnClickListener(this);


//        Button startIntentService = (Button) findViewById(R.id.start_intent_service);
//        startIntentService.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_download:
                String utl = "http://tkdapp.chinatelling.com/tykd_pt/uploads/TYKD.ipa";
                downloadBinder.startDownload(utl);
                break;
            case R.id.paused_download:
                downloadBinder.pausedDownload();
                break;
            case R.id.cancel_download:
                downloadBinder.cancelDownload();
                break;
            default:
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){
            case 1:
                if (grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(FirstActivity.this,"拒绝权限将无法使用程序",Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

    //    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.start_intent_service:
//                Log.d("FirstActivity","Thread id is " + Thread.currentThread().getId());
//            Intent intent = new Intent(FirstActivity.this,MyIntentService.class);
//                startService(intent);
//                break;
//            default:
//                break;
//        }
//    }

    //    @Override
//    public void onClick(View view) {
//
//        switch (view.getId()){
//            case R.id.bind_service:
//                Intent unbindIntent = new Intent(FirstActivity.this,MyService.class);
//                bindService(unbindIntent,connection,BIND_AUTO_CREATE);//绑定服务
//                break;
//            case R.id.uBind_service:
//                Intent bindIntent = new Intent(FirstActivity.this,MyService.class);
//                unbindService(connection);//解绑服务
//        }
//    }

    //        Button changeButton = (Button) findViewById(R.id.change_text);
//        textView = (TextView)findViewById(R.id.textview);
//        changeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch (view.getId()){
//                    case R.id.change_text:
//                        new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                                //子线程更新UI，会崩溃 报错：Only the original thread that created a view hierarchy can touch its views.
//                                Message message = new Message();
//                                message.what = UPDATE_TEXT;
//                                handler.sendMessage(message);
//                            }
//                        }).start();
//                        break;
//                    default:
//                        break;
//                }
//            }
//        });


//        Button button = (Button) findViewById(R.id.make_call);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//               if (ContextCompat.checkSelfPermission(FirstActivity.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
//                   ActivityCompat.requestPermissions(FirstActivity.this,new String[] {Manifest.permission.CALL_PHONE},1);
//               }else {
//                   call();
//               }
//
//            }
//        });


//database = new MyDatabaseHelper(this, "BookS.db", null, 2);

//        Button button = (Button) findViewById(R.id.Create_database);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               // database.getWritableDatabase();
//                Connector.getDatabase();
//
//            }
//        });
//
//
//        Button addData = (Button) findViewById(R.id.add_data);
//        addData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Book book = new Book();
//                book.setName("xiaoya");
//                book.setAuthor("zhangsan");
//                book.setPages(1334);
//                book.setPrice(78.90);
//                book.setPress("unkone");
//                book.save();
//                SQLiteDatabase db = database.getWritableDatabase();
//                ContentValues values = new ContentValues();
//
//                values.put("name", "The dA BAOBO");
//                values.put("author", "hanahm");
//                values.put("pages", 123423);
//                values.put("price", 12.90);
//                db.insert("Book", null, values);
//
//            }
//        });
//
//        Button updateButton = (Button) findViewById(R.id.update_data);
//        updateButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SQLiteDatabase db = database.getWritableDatabase();
//                ContentValues values = new ContentValues();
//                values.put("price", 10.99);
//                db.update("Book", values, "name = ?", new String[]{"The dA BAOBO"});
//            }
//        });
//
//        Button deleteButton = (Button) findViewById(R.id.delete_data);
//        deleteButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SQLiteDatabase db = database.getWritableDatabase();
//                db.delete("Book", "pages > ?", new String[]{"500"});
//            }
//        });
//
//        Button queryButton = (Button) findViewById(R.id.query_data);
//        queryButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SQLiteDatabase db = database.getWritableDatabase();
//                //查询表中所有的数据
//                Cursor cursor = db.query("Book", null, null, null, null, null, null);
//                if (cursor.moveToFirst()) {
//                    do {
//                        //遍历cursor对象，取出数据并打印
//                        String name = cursor.getString(cursor.getColumnIndex("name"));
//                        String cuthor = cursor.getString(cursor.getColumnIndex("author"));
//                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
//                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
//                        Log.d("FirstActivity", "book name is " + name);
//                        Log.d("FirstActivity", "book author is " + cuthor);
//                        Log.d("FirstActivity", "book pages is " + pages);
//                        Log.d("FirstActivity", "book price is " + price);
//                    }while (cursor.moveToNext());
//                }
//                cursor.close();
//            }
//        });
//        loginButton = (Button) findViewById(R.id.Login);
//        loginButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                String account = accountText.getText().toString();
//                String password = passwordText.getText().toString();
//
//                if (account.equals("admin") && password.equals("123456")){
//                    editor = preferences.edit();
//                    //复选框被选中
//                    if(checkBox.isChecked()){
//                        //存储密码
//                        editor.putString("account",account);
//                        editor.putString("password",password);
//                        editor.putBoolean("remember_password",true);
//
//                    }else {//复选框没有被选中
//                        editor.clear();
//                    }
//                    //提交存储
//                    editor.apply();
//
//                    Intent intent = new Intent(FirstActivity.this,FiveActivity.class);
//                    startActivity(intent);
//                    finish();
//                }else {
//                    Toast.makeText(FirstActivity.this,"account or password is invalid",Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//        });
//
//        preferences = PreferenceManager.getDefaultSharedPreferences(this);
//        boolean isRember = preferences.getBoolean("remember_password",false);
//
//        accountText = (EditText) findViewById(R.id.Account);
//        passwordText = (EditText) findViewById(R.id.Password);
//        checkBox = (CheckBox) findViewById(R.id.rember_pass);
//
//        if (isRember){
//            String accunt = preferences.getString("account","");
//            String password = preferences.getString("password","");
//            accountText.setText(accunt);
//            passwordText.setText(password);
//            checkBox.setChecked(true);
//        }


//        Button button = (Button)findViewById(R.id.SaveButton);
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
//                editor.putString("name","tom");
//                editor.putInt("age",29);
//                editor.putBoolean("married",false);
//                editor.apply();
//                Toast.makeText(FirstActivity.this,"Store Succeed",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        Button button1 = (Button)findViewById(R.id.RestoreButton);
//        button1.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);
//                String name = preferences.getString("name","");
//                int age = preferences.getInt("age",0);
//                Boolean married = preferences.getBoolean("married",false);
//
//                Log.d("FirstActivity","name is " + name);
//                Log.d("FirstActivity","age is " + age);
//                Log.d("FirstActivity","married is " + married);
//            }
//        });


//        editText = (EditText)findViewById(R.id.edit);
//
//        String inputText = load();
//        if (!TextUtils.isEmpty(inputText)){
//            editText.setText(inputText);
//            editText.setSelection(inputText.length());
//            Toast.makeText(FirstActivity.this,"Restoring succeeded",Toast.LENGTH_SHORT).show();
//
//        }

//        Button button = (Button) findViewById(R.id.button_fragment);
//        button.setOnClickListener(this);
//replaceFragment(new RightFragment());
//拍照
//        Button takePhoto = (Button) findViewById(R.id.take_photo);
//        picture = (ImageView) findViewById(R.id.picture);
//        //如果开头中没有写 View.OnClickListener，那么就在方法调用处写
//        takePhoto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //创建文件对象，存放拍摄照片。并存放在手机sd卡的应用关联缓存目录下
//                //应用关联缓存目录：SD卡中专门用于存放应用缓存数据的位置，具体路径为：/sdcard/Android/data/<package name>/cache
//                File outPutImage = new File(getExternalCacheDir(), "output_image.jpg");
//                try {
//                    if (outPutImage.exists()) {
//                        outPutImage.delete();
//                    }
//                    outPutImage.createNewFile();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                if (Build.VERSION.SDK_INT >= 24) {
//                    imageUri = FileProvider.getUriForFile(FirstActivity.this, "com.example.sandwind.onedemo.fileprovider", outPutImage);
//                } else {
//                    imageUri = Uri.fromFile(outPutImage);
//                }
//
//                Log.d("imageUri", imageUri.toString());
//
//                //启动相机程序
//                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
//                startActivityForResult(intent, TAKE_PHOTO);
//            }
//        });
//        //选择照片
//        Button chooseFromAlbum = (Button) findViewById(R.id.choose_from_album);
//        chooseFromAlbum.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                if (ContextCompat.checkSelfPermission(FirstActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
////                    ActivityCompat.requestPermissions(FirstActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
////                } else {
////                    openAlbum();
////                }
//
//
//                openAlbum();
//            }
//        });


//发送通知
//Button sendVoice = (Button) findViewById(R.id.send_voice);
//sendVoice.setOnClickListener(this);


//HttpURLConnection
//        Button sendRes = (Button) findViewById(R.id.btn_request);
//        responseText = (TextView) findViewById(R.id.Response_Data);
//        sendRes.setOnClickListener(this);


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

//    }
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
