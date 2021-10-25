//package com.example.myappmovies;
//
//import androidx.annotation.RequiresApi;
//import androidx.fragment.app.Fragment;
//
//
//import android.os.Build;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.KeyEvent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.webkit.WebChromeClient;
//import android.webkit.WebResourceRequest;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//import android.widget.FrameLayout;
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//public class Fragment1 extends Fragment {
//
//    private WebSettings webSettings;
//    private WebView webView;
//
//
//    String url = "https://www.dikotv.com/?btwaf=26341362";
//
//    /**
//     * 视频全屏参数
//     */
//    protected static final FrameLayout.LayoutParams COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//    private View customView;
//    private FrameLayout fullscreenContainer;
//    private WebChromeClient.CustomViewCallback customViewCallback;
//
//
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.activity_1, container, false);
//
//    }
//
//
//
//    @Override
//    public void onViewCreated(View view, Bundle savedInstanceState) {
//
//        // TODO Auto-generated method stub
//        super.onViewCreated(view, savedInstanceState);
//        webView = (WebView) view.findViewById(R.id.webview1);
//
//
//
//        webSettings = webView.getSettings();
//        // 允许访问文件
//        webSettings.setAllowFileAccess(true);
//        // 加载图片
//        webSettings.setLoadsImagesAutomatically(true);
//        //开启本地dom储存
//        webSettings.setDomStorageEnabled(true);
//        // 设置 WebView 允许执行 JavaScript 脚本
//        webSettings.setJavaScriptEnabled(true);
//        //支持缓存
//        webSettings.setAppCacheEnabled(true);
//
//        webView.setOnKeyListener(new View.OnKeyListener() {
//
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if ((keyCode == KeyEvent.KEYCODE_BACK) && event.getRepeatCount()==0) {
//                    webView.goBack();
//                    return true;
//                }
//                return false;
//            }
//
//        });
//
//
//        //在APP内打开网页，而不是调用自身浏览器来打开
//        webView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                // TODO Auto-generated method stub
//                return false;
//            }
//            // @Override
//            public void onPageFinished(WebView webView, String url) {
//
//
//
////                webView.loadUrl("javascript:function setTop(){document.querySelector('.header').style.display=\"none\";}setTop();");
////                webView.loadUrl("javascript:function setTop(){document.querySelector('.hot_banner_box').style.display=\"none\";}setTop();");
////                webView.loadUrl("javascript:function setTop(){document.querySelector('.banner-top swiper-container-horizontal opacity-top').style.display=\"none\";}setTop();");
//                // webView.loadUrl("javascript:function setTop(){document.querySelector('.row').style.display=\"none\";}setTop();");
//            }
//        });
//        //如果webView中需要用户手动输入用户名、密码或其他，则webview必须设置支持获取手势焦点。
//        webView.requestFocusFromTouch();
//        // 加载指定网页
//        webView.loadUrl(url);
//        //判断页面加载过程
//        //由于有些网页肯呢过加载缓慢，所以我们需要去判断页面的加载过程，制作进度条给与用户良好的体验效果。
//        //WebView通过设置一个WebChromeClient并且通过WebChromeClient的onProgressCHanged()方法得到当前加载的进度。
//        //setWebChromeClient辅助WebView处理JavaScript的对话框，网站图标，网站title，加载进度等
//        //setWebClient就是帮助WebView处理各种通知、请求事件
//        webView.setWebChromeClient(new WebChromeClient() {
//            //实现点击加载画面
//            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                view.loadUrl(request.getUrl().toString());
//                return true;
//            }
//
//            @Override
//            //获取加载进度对加载进度进行判断
//            //拦截广告
//            public void onProgressChanged(WebView view, int newProgress) {
//
//                Log.e("WebView>>>>>>>", newProgress + "");
//
//                webView.loadUrl("javascript:function setTop(){document.querySelector('.header').style.display=\"none\";}setTop();");
//                webView.loadUrl("javascript:function setTop(){document.querySelector('.hot_banner_box').style.display=\"none\";}setTop();");
//                webView.loadUrl("javascript:function setTop(){document.querySelector('.banner-top swiper-container-horizontal opacity-top').style.display=\"none\";}setTop();");
//                 //webView.loadUrl("javascript:function setTop(){document.querySelector('body > div.container.v\\.dingko\\.com > div:nth-child(2)').style.display=\"none\";}setTop();");
//                super.onProgressChanged(view, newProgress);
//            }
//
//
////            /*** 视频播放相关的方法 **/
////            @Override
////            public View getVideoLoadingProgressView() {
////                FrameLayout frameLayout = new FrameLayout();
////                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
////                return frameLayout;
////            }
////
////            @Override
////            public void onShowCustomView(View view, CustomViewCallback callback) {
////               // showCustomView(view, callback);
////            }
////
////            @Override
////            public void onHideCustomView() {
////               // hideCustomView();
////            }
//
//
//        });
//
//
//    }
//}
//
