package com.feicui.jsondemo.web;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.feicui.jsondemo.R;

/**
 * Created by lenovo on 2016/8/31.
 */
public class WebActivity extends Activity{
    private WebView webView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        webView= (WebView) findViewById(R.id.webView);

        String path = getIntent().getStringExtra("url");
        if (path!=null){
            webView.loadUrl(path);//如果路径不为空，就加载这个路径
        }
        /**
         * 设置可放大缩小网页，默认displayzoomcontrols为true显示
         * */
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.getSettings().setSupportZoom(true);
        webView.setWebViewClient(webViewClient);//页面刷新的监听
        webView.setWebChromeClient(webChromeClient);//进度发生变化的监听
    }
    private WebViewClient webViewClient=new WebViewClient(){
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    };
    private  WebChromeClient webChromeClient=new WebChromeClient(){
        //设置进度监听，进度小于100时显示进度，>=100是设置进度条不可见

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            if (newProgress<100){
                progressBar.setProgress(newProgress);
            }
            if (newProgress>=100){
                progressBar.setVisibility(View.GONE);
            }
        }
    };
    // 如果可以返回则返回上一级页面，不能返回则关闭页面
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
