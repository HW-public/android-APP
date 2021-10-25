package com.example.myappmovies;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StartAnimation extends Activity {

    ImageView imageView;
    Animation animation1,animation2;
    TextView textView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_animation);

        //设置顶部状态栏为黑色
        getWindow().setStatusBarColor(Color.BLACK);

        imageView=findViewById(R.id.imageView);
        textView=findViewById(R.id.textView1);

        animation1= AnimationUtils.loadAnimation(StartAnimation.this, R.anim.start_animation);
        animation2= AnimationUtils.loadAnimation(StartAnimation.this, R.anim.alpha);
        imageView.startAnimation(animation1);
        textView.startAnimation(animation2);
        animation1.setFillAfter(true);
//        Intent intent = new Intent();
//        intent.setClass(getActivity(), Activity_1.class);
//        startActivity(intent);
        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent=new Intent(StartAnimation.this,MainActivity01.class);
                startActivity(intent);
                finish();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }




}
