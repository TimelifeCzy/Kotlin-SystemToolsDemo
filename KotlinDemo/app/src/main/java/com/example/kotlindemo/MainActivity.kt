package com.example.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // 调用Native
    init {
        System.loadLibrary("kotlindemo")
    }
    //载入C++里面的方法，不能少
    external fun stringFromJNI(): String?
    external fun ReadFileData(String: String): String?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("MainActivity: ", "yes my kotlinDeom")

        // 调用c++接口测试
        // var strings = stringFromJNI()
        // print(strings)
        // var readBuf = ReadFileData("/system/addon.d/50-base.sh")


        var var_text1 = findViewById<TextView>(R.id.show_test1)
        var_text1.text  = "Mod Game"

        var var_button_systempacket = findViewById<Button>(R.id.show_button_systempacket)
        var_button_systempacket.text = "Show System Install Akp"

        var var_button_gamedatamodify = findViewById<Button>(R.id.show_button_gamedatamodify)
        var_button_gamedatamodify.text = "Game Data Modify"

//        val file: File = File("/system/")
//        val subFile = file.listFiles()
//        for (iFileLength in subFile.indices) {
//            // 判断是否为文件夹
//            if (!subFile[iFileLength].isDirectory) {
//                val filename = subFile[iFileLength].name
//                Log.e("eee", "文件名 ： $filename")
//            }
//        }

    }

    // Dlg1: 系统软件管理
    fun ShowSystemInstallApk(view: View) {
        Toast.makeText(this,"System Apk Pack Qquery",Toast.LENGTH_SHORT).show()
        var intels = Intent(this@MainActivity, SystemPackteManage::class.java)
        startActivity(intels)
    }

    fun ShowGameDataModify(view: View) {
        Toast.makeText(this,"Game Data Modify Qquery",Toast.LENGTH_SHORT).show()
        var intels = Intent(this@MainActivity, GameDataModify::class.java)
        startActivity(intels)
    }

    // Dlg2: 照片清理

    // Dlg3: 网络检测

    // Dlg4: Hids监控

    // Dlg5: 游戏修改器





}