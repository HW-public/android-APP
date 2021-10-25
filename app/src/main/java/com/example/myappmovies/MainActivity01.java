package com.example.myappmovies;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity01 extends AppCompatActivity {

     private Fragment2 fragment2;

     private FragmentTransaction transaction;
     private FragmentManager fragmentManager;

     private WebSettings webSettings;
     private  WebView webView;

     //进度条
     private ProgressDialog progressDialog;

     String url = "https://www.dikotv.com/ ";

    /** 视频全屏参数 */
    protected static final FrameLayout.LayoutParams COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    private View customView;
    private FrameLayout fullscreenContainer;
    private WebChromeClient.CustomViewCallback customViewCallback;

    //Animation animation;


private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:

                webView=findViewById(R.id.webView);
                webView.setVisibility(View.VISIBLE);

//                animation= AnimationUtils.loadAnimation(MainActivity01.this, R.anim.scale);
//                BottomNavigationView home=findViewById(R.id.navigation_home);
//                home.startAnimation(animation);

                transaction = fragmentManager.beginTransaction();
//                if(f1==null){
//                    f1=new Fragment1();
//                    transaction.add(R.id.main_frame_layout,f1);
//                }
                transaction.commit();
                transaction.hide(fragment2);
//                transaction.show(f1);
                return true;
            case R.id.navigation_me:

                webView=findViewById(R.id.webView);
                webView.setVisibility(View.GONE);
                transaction = fragmentManager.beginTransaction();
                if(fragment2==null){
                    fragment2=new Fragment2();
                    transaction.add(R.id.main_frame_layout,fragment2);
                }
                transaction.commit();
                transaction.show(fragment2);
                return true;
        }
        return false;
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        webView=findViewById(R.id.webView);
        fragmentManager = getSupportFragmentManager();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //设置顶部状态栏为黑色
        getWindow().setStatusBarColor(Color.BLACK);
        //创建网页初始化
        createWebView();

    }
    //初始化方法
//    private void setDefaultFragment() {
//        transaction = fm.beginTransaction();
//        f1=new Fragment1();
//        transaction.add(R.id.main_frame_layout,f1);
//        transaction.commit();
//        transaction.show(f1);
//    }







//    // 点击事件
//    @Override
//    public void onClick(View v) {
//        switch(v.getId()){
//            case R.id.imageButton1:
//                setSelectStatus(0);
//                break;
//            case R.id.imageButton2:
//                setSelectStatus(1);
//                break;
//        }
//    }
//    //点击切换状态方法
//    private void setSelectStatus(int index){
//        switch (index){
//            case 0://home
//            {
//                imageButton_home.setImageDrawable(getResources().getDrawable(R.drawable.home_press_icon));
//                imageButton_me.setImageDrawable(getResources().getDrawable(R.drawable.tab_mine_nor));
//
////
//
//
//                break;
//            }
//            //点击下方的me按钮实现图片的切换，以及一些不可见
//            case 1://me
//            {
//                imageButton_home.setImageDrawable(getResources().getDrawable(R.drawable.home_normal_icon));
//                imageButton_me.setImageDrawable(getResources().getDrawable(R.drawable.tab_mine_sel));
//
//                break;
//            }
//
//        }
//    }
//    实现物理按钮回退
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //按下返回键并且webview界面可以返回
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();// goBack()表示返回WebView的上一页面
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
    /* 创建 WebView 实例 并 实现网页当中全屏以及点击加载，屏蔽广告的方法 */
    @SuppressLint("SetJavaScriptEnabled")
    private void createWebView() {
        webSettings=webView.getSettings();
        // 允许访问文件
        webSettings.setAllowFileAccess(true);
        // 加载图片
        webSettings.setLoadsImagesAutomatically(true);
        //开启本地dom储存
        webSettings.setDomStorageEnabled(true);
        // 设置 WebView 允许执行 JavaScript 脚本
        webSettings.setJavaScriptEnabled(true);
        //支持缓存
        webSettings.setAppCacheEnabled(true);
        //在APP内打开网页，而不是调用自身浏览器来打开
        webView.setWebViewClient(new WebViewClient(){
           // @Override
           public void onPageFinished(WebView webView, String url) {
               webView.loadUrl("javascript:function setTop(){document.querySelector('.header').style.display=\"none\";}setTop();");
               webView.loadUrl("javascript:function setTop(){document.querySelector('.hot_banner_box').style.display=\"none\";}setTop();");
               webView.loadUrl("javascript:function setTop(){document.querySelector('.banner-top swiper-container-horizontal opacity-top').style.display=\"none\";}setTop();");
              // webView.loadUrl("javascript:function setTop(){document.querySelector('.row').style.display=\"none\";}setTop();");
            }
        });
       // 如果webView中需要用户手动输入用户名、密码或其他，则webview必须设置支持获取手势焦点。
        webView.requestFocusFromTouch();
        // 加载指定网页
        webView.loadUrl(url);
//        判断页面加载过程
//        由于有些网页肯呢过加载缓慢，所以我们需要去判断页面的加载过程，制作进度条给与用户良好的体验效果。
//        WebView通过设置一个WebChromeClient并且通过WebChromeClient的onProgressCHanged()方法得到当前加载的进度。
//        setWebChromeClient辅助WebView处理JavaScript的对话框，网站图标，网站title，加载进度等
//        setWebClient就是帮助WebView处理各种通知、请求事件
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            //获取加载进度对加载进度进行判断
            public void onProgressChanged(WebView view, int newProgress) {
                // newProgress 1 ~ 100 之间的证书
                if (newProgress == 100) {
                    // 加载完成，关闭ProgressDialog
                    closeDialog();
                } else {
                    // 还在加载，打开ProgressDialog
                    openDialog(newProgress);
                }
                webView.loadUrl("javascript:function setTop(){document.querySelector('.header').style.display=\"none\";}setTop();");
                webView.loadUrl("javascript:function setTop(){document.querySelector('.hot_banner_box').style.display=\"none\";}setTop();");
                webView.loadUrl("javascript:function setTop(){document.querySelector('.banner-top swiper-container-horizontal opacity-top').style.display=\"none\";}setTop();");
                // webView.loadUrl("javascript:function setTop(){document.querySelector('body > div.container.v\\.dingko\\.com > div:nth-child(2)').style.display=\"none\";}setTop();");
                super.onProgressChanged(view, newProgress);
            }
            //还在加载时弹出的窗口，方法
            private void openDialog(int newProgress) {
                if (progressDialog == null) {
                    progressDialog = new ProgressDialog(MainActivity01.this);
                    progressDialog.setProgress(newProgress);
                    progressDialog.setTitle("加载中");
                    progressDialog.show();
                } else {
                    progressDialog.setProgress(newProgress);
                }
            }
            //加载完成，关闭弹出的窗口，方法
            private void closeDialog() {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                    progressDialog = null;
                }
            }
            //视频播放相关的方法
            @Override
            public View getVideoLoadingProgressView() {
                FrameLayout frameLayout = new FrameLayout(MainActivity01.this);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
                return frameLayout;
            }
            @Override
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
                showCustomView(view, callback);
            }
            @Override
            public void onHideCustomView() {
                hideCustomView();
            }
        });
    }
    //视频播放全屏
    private void showCustomView(View view, WebChromeClient.CustomViewCallback callback) {
        // if a view already exists then immediately terminate the new one
        if (customView != null) {
            callback.onCustomViewHidden();
            return;
        }
        MainActivity01.this.getWindow().getDecorView();
        FrameLayout decor = (FrameLayout) getWindow().getDecorView();
        fullscreenContainer = new FullscreenHolder(MainActivity01.this);
        fullscreenContainer.addView(view, COVER_SCREEN_PARAMS);
        decor.addView(fullscreenContainer, COVER_SCREEN_PARAMS);
        customView = view;
        //横屏
        MainActivity01.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setStatusBarVisibility(false);
        customViewCallback = callback;
    }
    //隐藏视频全屏
    public void hideCustomView() {
        //横屏播放
        MainActivity01.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (customView == null) {
            return;
        }
        setStatusBarVisibility(true);
        FrameLayout decor = (FrameLayout) getWindow().getDecorView();
        decor.removeView(fullscreenContainer);
        fullscreenContainer = null;
        customView = null;
        customViewCallback.onCustomViewHidden();
        webView.setVisibility(View.VISIBLE);
    }
    //全屏容器界面
    static class FullscreenHolder extends FrameLayout {

        public FullscreenHolder(Context ctx) {
            super(ctx);
            setBackgroundColor(ctx.getResources().getColor(android.R.color.black));
        }

        @Override
        public boolean onTouchEvent(MotionEvent evt) {
            return true;
        }
    }

    private void setStatusBarVisibility(boolean visible) {
        int flag = visible ? 0 : WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                /** 回退键 事件处理 优先级:视频播放全屏-网页回退-关闭页面 */
                if (customView != null) {
                    hideCustomView();
                } else if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    finish();
                }
                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }
}
