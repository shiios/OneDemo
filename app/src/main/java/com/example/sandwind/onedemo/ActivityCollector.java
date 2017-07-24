package com.example.sandwind.onedemo;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandwind on 2017/7/20.
 */

public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }


    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity:activities){
            if (!activity.isFinishing()){
                /*
                * 下述方法杀掉进程的代码为：
                * android.os.Process.killProcess(android.os.Process.myPid());
                * myPid()接收的是当前程序的进程  id
                * */
                activity.finish();
            }
        }
    }

}
