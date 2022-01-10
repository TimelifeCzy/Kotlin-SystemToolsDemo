package com.example.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import android.content.pm.PackageManager

class SystemPackteManage : AppCompatActivity(){

    private val arrayList = ArrayList<String>()

    // Maste Dlg
    // ActivityManager.RunningAppProcessInfo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.currentsystem_activityapk)

        var cursys_button = findViewById<TextView>(R.id.currentsystem_button)
        cursys_button.text = "Get Current System RunApkPrj"
    }

    // Button Handle 获取系统安装APK
    fun currentsystem_button_onClick(view: View) {
        Toast.makeText(this, "Query System Install Apk",Toast.LENGTH_SHORT).show()

        // 初始化包管理
        val packageManager = packageManager

        try {
            // 获取用户安装的应
            var packInstallList = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)

            // 循环获取包详细
            for( i in 0..packInstallList.size - 1) {

                print(packInstallList[i].processName)
                // 获取详细包信息
                var appInfo = packageManager.getApplicationInfo(packInstallList[i].packageName, PackageManager.GET_META_DATA)
                var packageInfo = packageManager.getPackageInfo(packInstallList[i].packageName, 0)
                // 获取应用图标
                // var packInfoIcon = packageManager.getApplicationIcon(packInstallList[i].packageName)
                // 获取APP应用名 + version
                var appName = packageManager.getApplicationLabel(appInfo).toString()
                var showlisttempstr = appName + ": " + packageInfo.versionName
                arrayList.add(showlisttempstr)
            }
        } catch (e: NumberFormatException) {
            println(e.message)
        }

        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList)
        var cursys_list = findViewById<ListView>(R.id.currentsystem_ListView)
        // 展示数据
        cursys_list.adapter = adapter
    }

}

