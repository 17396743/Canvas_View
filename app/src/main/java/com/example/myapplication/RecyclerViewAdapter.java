package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * @创建时间 2021/6/4 11:22
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.HomeHolder> {
    private ArrayList<Integer> colorsid;
    private Context context;

    public RecyclerViewAdapter(ArrayList<Integer> colorsid, Context context) {
        this.colorsid = colorsid;
        this.context = context;
    }

    @Override
    public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.rv_view_main, parent, false);
        return new HomeHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.HomeHolder holder, int position) {
        holder.viewRvItem.setBackgroundColor(colorsid.get(position));
        holder.viewRvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(position);
            }
        });
    }

    //第一步 定义接口
    public interface OnItemClickListener {
        void onClick(int position);
    }

    private OnItemClickListener listener;

    //第二步， 写一个公共的方法
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    @Override
    public int getItemCount() {
        return colorsid.size();
    }

    class HomeHolder extends RecyclerView.ViewHolder {
        View viewRvItem;

        public HomeHolder(View itemView) {
            super(itemView);
            viewRvItem = (View) itemView.findViewById(R.id.view_rv_item);

        }
    }

}
