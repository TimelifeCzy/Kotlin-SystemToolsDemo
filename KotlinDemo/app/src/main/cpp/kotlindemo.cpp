// Write C++ code here.
//
// Do not forget to dynamically load the C++ library into your application.
//
// For instance,
//
// In MainActivity.java:
//    static {
//       System.loadLibrary("kotlindemo");
//    }
//
// Or, in MainActivity.kt:
//    companion object {
//      init {
//         System.loadLibrary("kotlindemo")
//      }
//    }

#include <jni.h>
#include <iostream>
#include <fstream>
#include <string>
#include <map>
#include <memory>

//这里的名字要严格按照：Java_包名_方法名，1表示_
extern "C" JNIEXPORT jstring JNICALL
Java_com_example_kotlindemo_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject thiz
)
{
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_kotlindemo_MainActivity_ReadFileData(
        JNIEnv *env,
        jobject thiz,
        jstring file_path
)
{
    // 获取大小
    // ReleaseStringUTFChars GetStringUTFRegion GetStringUTFChars()
    char* c_filepath = const_cast<char *>(env->GetStringUTFChars(file_path, 0));
    std::ofstream ofsteam_ptr;
    std::ifstream ifsteam_ptr;

    ifsteam_ptr.open(c_filepath, std::ios::in | std::ios::binary);
    ifsteam_ptr.seekg(0, std::ios::end);
    int nFileLen = ifsteam_ptr.tellg();
    ifsteam_ptr.seekg(0,std::ios::beg);

    char* read_buffer = (char*)malloc(nFileLen+1);
    memset(read_buffer, 0, nFileLen+1);

    if(!ifsteam_ptr.bad()) {
        ifsteam_ptr.read(read_buffer, nFileLen);
    }

    return env->NewStringUTF(read_buffer);
}