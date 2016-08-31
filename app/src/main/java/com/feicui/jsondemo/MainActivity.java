package com.feicui.jsondemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.feicui.jsondemo.web.WebActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<GirlImage> Girllist=new ArrayList<>();
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refreshLayout= (SwipeRefreshLayout) findViewById(R.id.refreshLayout);
        refreshLayout.setColorSchemeResources(R.color.colorAccent);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                time=3;//再次下拉时，计数器重置
                handler.sendEmptyMessage(1);//接收handler发送的消息

            }
        });
        load();
    }
    int time=3;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            time--;
            if (time>0){
                handler.sendEmptyMessageDelayed(1,1000);
            }else if (time<=0){
                refreshLayout.setRefreshing(false);
                load();
            }
        }
    };

    private void load(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String str=JsonParseUtil.getJsonData();
                Girllist=ParserGirlImage.getGirlInfo(str);//参数列表为
                Log.d("debug","获取到的json字符串"+str);

                for (int i=0;i<Girllist.size();i++){
                    Log.d("debug",Girllist.get(i).toString());
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter=new RecyclerViewAdapter(Girllist,getBaseContext());
                        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,1));
                        recyclerView.setAdapter(adapter);
                        adapter.setOnItemClickListener(new RecyclerViewAdapter.onItemClickListener() {
                            @Override
                            public void ItemClick(int position) {
                                Intent intent=new Intent(getBaseContext(), WebActivity.class);
                                intent.putExtra("url",Girllist.get(position).getUrl());
                                startActivity(intent);
                            }
                        });
                    }
                });
            }
        }).start();
    }
}
