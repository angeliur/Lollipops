package com.angeliur.lollipops.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.angeliur.lollipops.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2018/2/1 0001.
 */

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<String> mData;
    private OnItemClickListener listener;

    public RecyclerAdapter(ArrayList<String> mData) {
        this.mData = mData;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 将布局转化为View并传递给RecyclerView封装好的ViewHolder
        View view = View.inflate(parent.getContext(), R.layout.recy_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // 建立起ViewHolder中视图与数据的关联
        holder.tv.setText(mData.get(position) + position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView;
            tv.setOnClickListener(this);
        }

        // 通过接口回调来实现RecyclerView的点击事件
        @Override
        public void onClick(View v) {
            if (listener != null){
                listener.onItemClick(v,getPosition());
            }
        }
    }
}
