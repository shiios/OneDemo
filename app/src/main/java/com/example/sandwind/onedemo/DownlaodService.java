package com.example.sandwind.onedemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import java.io.File;
import java.io.InputStream;

public class DownlaodService extends Service {
    public DownlaodService() {
    }

    private DownloadTask downloadTask;
    private String downloadurl;
    private DownloadLister lister = new DownloadLister() {
        @Override
        public void onProgress(int progress) {

            getNotificationManager().notify(1, getNotification("Downloading...", progress));
        }

        @Override
        public void onSuccess() {

            downloadTask = null;
            stopForeground(true);

            getNotificationManager().notify(1, getNotification("Download Success", -1));

            Toast.makeText(DownlaodService.this, "download success", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailed() {

            downloadTask = null;
            stopForeground(true);
            getNotificationManager().notify(1, getNotification("Download Failed", -1));
            Toast.makeText(DownlaodService.this, "download failed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPaused() {

            downloadTask = null;
            Toast.makeText(DownlaodService.this, "paused", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCanceled() {

            downloadTask = null;
            stopForeground(true);
            Toast.makeText(DownlaodService.this, "canceled", Toast.LENGTH_SHORT).show();
        }
    };

    private NotificationManager getNotificationManager() {
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    private Notification getNotification(String title, int progress) {


        Intent intent = new Intent(DownlaodService.this, FirstActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setContentIntent(pendingIntent);
        builder.setContentTitle(title);

        if (progress > 0) {
            builder.setContentText(progress + "%");
            builder.setProgress(100, progress, false);
        }
        return builder.build();

    }


    private DownloadBinder mBinder = new DownloadBinder();

    class DownloadBinder extends Binder{

        public void startDownload(String url){
            if (downloadTask == null){
                downloadurl = url;
                downloadTask = new DownloadTask(lister);
                downloadTask.execute(downloadurl);
                startForeground(1,getNotification("Downloading...",0));
                Toast.makeText(DownlaodService.this,"Downloading...",Toast.LENGTH_SHORT).show();
            }
        }

        public void pausedDownload(){
            if (downloadTask != null){
                downloadTask.pausedDownload();
            }
        }

        public void cancelDownload(){
            if (downloadTask != null){
                downloadTask.cancelDownload();
            }else {
                if (downloadurl != null){
                    String fileName = downloadurl.substring(downloadurl.lastIndexOf("/"));
                    String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
                    File file = new File(directory+fileName);
                    if (file.exists()){
                        file.delete();
                    }
                    getNotificationManager().cancel(1);
                    stopForeground(true);
                    Toast.makeText(DownlaodService.this,"Canceled",Toast.LENGTH_SHORT).show();
                }
            }
        }

    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       // throw new UnsupportedOperationException("Not yet implemented");

        return mBinder;
    }
}
