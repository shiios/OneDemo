package com.example.sandwind.onedemo;

/**
 * Created by sandwind on 2017/8/8.
 */

public interface DownloadLister {

    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();


}
