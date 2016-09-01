package com.feicui.jsondemo.web;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.feicui.jsondemo.R;

/**
 * Created by lenovo on 2016/8/31.
 */
public class WebActivity extends Activity{
    private WebView webView;
    private ProgressBar progressBar;
    private ImageView imageView_back;
    private SwipeRefreshLayout refreshLayout_web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        webView= (WebView) findViewById(R.id.webView);
        refreshLayout_web= (SwipeRefreshLayout) findViewById(R.id.refreshLayout_web);
        refreshLayout_web.setColorSchemeResources(R.color.colorAccent);
        refreshLayout_web.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                time=3;//每次下拉时计数器time重置为3
                handler.sendEmptyMessage(1);//这里接收handler消息
            }
        });
        imageView_back= (ImageView) findViewById(R.id.back);
        //返回图标监听，点击finish当前页面
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
        loadWeb();//默认进入WebView加载一次URL

        /**
         * 设置可放大缩小网页，默认displayzoomcontrols为true显示
         * */
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.getSettings().setSupportZoom(true);
        webView.setWebViewClient(webViewClient);//页面刷新的监听
        webView.setWebChromeClient(webChromeClient);//进度发生变化的监听
    }
    int time=3;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            time--;
            if (time>0){
                handler.sendEmptyMessageDelayed(1,1000);//1秒钟发送一次
            }else if (time<=0){
                loadWeb();//三秒后再刷新页面
                refreshLayout_web.setRefreshing(false);//隐藏刷新效果图
            }
        }
    };
    private void loadWeb(){
        String path = getIntent().getStringExtra("url");
        if (path!=null){
            webView.loadUrl(path);//如果路径不为空，就加载这个路径
        }
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
