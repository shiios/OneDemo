package com.example.sandwind.onedemo;

import android.app.DownloadManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class MyService extends Service {


    public DowmloadBinder mBinder = new DowmloadBinder();

    class DowmloadBinder extends Binder {
        public void startDownload() {
            Log.d("Myservice", "startDownload executed");
        }

        public int getProgress() {
            Log.d("Myservice", "getProgress");
            return 0;
        }

    }


    public MyService() {

    }


    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("Myservice", "OnCreate executed");
        Intent intent = new Intent(this,FirstActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("This is a content title")
                .setContentText("This is a content text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1,notification);

    }

    ///服务一启动要执行的内容可以写在此处
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Myservice", "onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Myservice", "onDestroy");

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return mBinder;
    }


}
