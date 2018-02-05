package com.angeliur.lollipops.recyclerview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.angeliur.lollipops.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/2/1 0001.
 */

public class RecyclerViewActivity extends Activity {


    private RecyclerView mRcList;
    private LinearLayoutManager mLlManager;
    private ArrayList<String> mData;
    private RecyclerAdapter mAdapter;
    private Spinner spinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        mRcList = (RecyclerView) findViewById(R.id.rc_list);
        mLlManager = new LinearLayoutManager(this);
        mRcList.setLayoutManager(mLlManager);
        // 设置显示动画
        mRcList.setHasFixedSize(true);
        mData = new ArrayList<>();
        mData.add("recyclerview");
        mData.add("recyclerview");
        mData.add("recyclerview");
        mData.add("recyclerview");
        mAdapter = new RecyclerAdapter(mData);
        mRcList.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final View view, int position) {
                // 设置点击动画
                view.animate().translationZ(15f).setDuration(1000)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                view.animate().translationZ(1f).setDuration(1000).start();
                            }
                        }).start();
            }
        });

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    // 设置为线性布局
                    mRcList.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this));
                }else if (position == 1){
                    // 设置为表格布局
                    mRcList.setLayoutManager(new GridLayoutManager(RecyclerViewActivity.this,3));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void addRecycler(View view){
        mData.add("recyclerview");
        int size = mData.size();
        if (size > 0){
            mAdapter.notifyDataSetChanged();
        }
    }

    public void delRecycler(View view){
        int size = mData.size();
        if (size > 0){
            mData.remove(size - 1);
            mAdapter.notifyDataSetChanged();
        }
    }
}
