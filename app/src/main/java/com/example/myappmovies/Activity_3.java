package com.example.myappmovies;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

public class Activity_3 extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        //设置顶部状态栏为黑色
        getWindow().setStatusBarColor(Color.BLACK);}
}
