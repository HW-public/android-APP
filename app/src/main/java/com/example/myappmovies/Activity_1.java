package com.example.myappmovies;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

public class Activity_1 extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        //设置顶部状态栏为黑色
        getWindow().setStatusBarColor(Color.BLACK);}




}
