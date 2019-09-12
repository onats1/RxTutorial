package com.example.rxtutorial;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private static final String TAG = "DataSource";
    public static List<Tasks> createDataSource(){
        List<Tasks> dataList = new ArrayList<>();
        dataList.add(new Tasks("Take out the trash", true, 3));
        dataList.add(new Tasks("Walk the dog", false, 2));
        dataList.add(new Tasks("Lay my bed", true, 1));
        dataList.add(new Tasks("Unload the dishwasher", false, 0));
        dataList.add(new Tasks("Make dinner", true, 5));

        Log.d(TAG, "createDataSource: " + Thread.currentThread().getName());
        return dataList;
    }

    public static DownloadableObject startDownload(){
        return new DownloadableObject();
    }
}
