package com.feicui.jsondemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by lenovo on 2016/8/31.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
        ArrayList<GirlImage> list;
        Context context;

    public RecyclerViewAdapter(ArrayList<GirlImage> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
//        holder.icon.setImageResource(list.get(position).getPicUrl());
        Picasso.with(context).load(list.get(position).getPicUrl()).into(holder.icon);
        holder.title.setText(list.get(position).getTitle());
        holder.time.setText(list.get(position).getCtime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){
                    listener.ItemClick(position);
                }
            }
        });
    }
    public interface onItemClickListener{
        void ItemClick(int position);
    }
    private onItemClickListener listener;
    public void setOnItemClickListener(onItemClickListener listener){
        this.listener=listener;
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title,time;
        ImageView icon;
        public MyViewHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.text_title);
            time= (TextView) itemView.findViewById(R.id.text_time);
            icon= (ImageView) itemView.findViewById(R.id.icon);
        }
    }
}
