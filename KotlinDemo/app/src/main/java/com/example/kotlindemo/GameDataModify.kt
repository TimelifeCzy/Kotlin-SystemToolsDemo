package com.example.kotlindemo
import android.app.ActivityManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameDataModify : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gamedata_modify)

        var gamedata_img = findViewById<ImageView>(R.id.gamedata_imageView);

        var gamedata_text = findViewById<TextView>(R.id.gamedata_text);
        gamedata_text.text = "检测当前窗口运行程序";

        val mActivityManager = this.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager;
        var mPackageName = "";
        if(Build.VERSION.SDK_INT > 20){
            mPackageName = mActivityManager.getRunningAppProcesses().get(0).processName;
        }else{
            //mPackageName = mActivityManager.getRunningTasks(1).get(0).topActivity.packageName.toString();
        }

        var activityManager = this.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager;
        //var cn = activityManager.runningAppProcesses.get(0) as ActivityManager.RunningAppProcessInfo;
    }
}

// 获取屏幕正在运行的程序
/*
*
ActivityManager mActivityManager =(ActivityManager)this.getSystemService(Context.ACTIVITY_SERVICE);
if(Build.VERSION.SDK_INT > 20){
    String mPackageName = mActivityManager.getRunningAppProcesses().get(0).processName;
}else{
  String mpackageName =  mActivityManager.getRunningTasks(1).get(0).topActivity.getPackageName();
}
ActivityManager activityManager = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
RunningAppProcessInfo  cn = activityManager.getRunningAppProcesses().get(0)
mForegroundUidPids.get(uid, new SparseBooleanArray()).put(pid, true);
* */