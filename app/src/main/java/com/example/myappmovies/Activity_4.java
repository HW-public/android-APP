package com.example.myappmovies;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.net.ContentHandler;

public class Activity_4 extends Activity {

    TextView textView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        //设置顶部状态栏为黑色
        getWindow().setStatusBarColor(Color.BLACK);

        textView=findViewById(R.id.textView7);
        //设置滚动
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());

    }
}
