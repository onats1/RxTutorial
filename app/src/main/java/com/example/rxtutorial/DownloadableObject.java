package com.example.rxtutorial;

import android.util.Log;

public class DownloadableObject {

    private static final String TAG = "DownloadableObject";

    public String downloadedString = "Empty String";

    public void downloadData(){

        Log.d(TAG, "downloadData: " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        downloadedString = "Download Success";
    }
}
