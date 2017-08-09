package com.example.sandwind.onedemo;

import android.os.AsyncTask;
import android.os.Environment;
import android.webkit.DownloadListener;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sandwind on 2017/8/8.
 */

public class DownloadTask extends AsyncTask<String, Integer, Integer> {
    public static final int TYPE_SUCCESS = 0;
    public static final int TYPE_FAILED = 1;
    public static final int TYPE_PAUSED = 2;
    public static final int TYPE_CANCELED = 3;

    private DownloadLister listener;
    private boolean isCanceled = false;
    private boolean isPaused = false;
    private int lastProgess;

    public DownloadTask(DownloadLister downloadListener) {
        this.listener = downloadListener;
    }



    private long getContentPath(String dowanloadul) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(dowanloadul)
                .build();
        Response response = client.newCall(request).execute();

        if (response != null && response.isSuccessful()){
            long contentLength = response.body().contentLength();
            response.close();
            return contentLength;
        }

        return 0;

    }
    @Override
    protected Integer doInBackground(String... params) {

        InputStream is = null;
        RandomAccessFile savedFile = null;
        File file = null;

        try {
            long downloadedlength = 0;
            String downloadUrl = params[0];
            String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
            String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            file = new File(directory + fileName);
            if (file.exists()) {
                downloadedlength = file.length();
            }
            long contentlenght = getContentPath(downloadUrl);
            if (contentlenght == 0) {
                return TYPE_FAILED;

            } else if (contentlenght == downloadedlength) {
                return TYPE_SUCCESS;
            }


            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .addHeader("RANGE", "bytes=" + downloadedlength + "-")
                    .url(downloadUrl)
                    .build();

            Response response = client.newCall(request).execute();
            if (response != null) {
                is = response.body().byteStream();
                savedFile = new RandomAccessFile(file, "rw");
                savedFile.seek(downloadedlength);
                byte[] b = new byte[1024];
                int total = 0;
                int len;
                while ((len = is.read(b)) != -1) {
                    if (isCanceled) {
                        return TYPE_CANCELED;
                    } else if (isPaused) {
                        return TYPE_PAUSED;
                    } else {
                        total += len;

                        savedFile.write(b, 0, len);
                        //计算已经下载的百分比
                        int progress = (int) ((total + downloadedlength) * 100 / contentlenght);
                        publishProgress(progress);

                    }
                }
                response.body().close();
                return TYPE_SUCCESS;

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {

                if (is != null) {
                    is.close();
                }
                if (savedFile != null) {
                    savedFile.close();
                }
                if (isCanceled && file != null) {
                    file.delete();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return TYPE_FAILED;

    }



    @Override
    protected void onProgressUpdate(Integer... values) {

        int progress = values[0];
        if (progress > lastProgess){
            listener.onProgress(progress);
            lastProgess = progress;
        }

    }

    public void pausedDownload(){
        isPaused = true;
    }

    public void cancelDownload(){
        isCanceled = true;
    }


    @Override
    protected void onPostExecute(Integer status) {

        switch (status){
            case TYPE_SUCCESS:
                listener.onSuccess();
                break;
            case TYPE_FAILED:
                listener.onFailed();
                break;
            case TYPE_PAUSED:
                listener.onPaused();
                break;
            case TYPE_CANCELED:
                listener.onCanceled();
                break;
            default:
                break;
        }
    }

}