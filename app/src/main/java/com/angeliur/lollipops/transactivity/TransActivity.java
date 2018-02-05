package com.angeliur.lollipops.transactivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;

import com.angeliur.lollipops.R;
import com.angeliur.lollipops.animatedselector.AnimatedSelectorActivity;
import com.angeliur.lollipops.mylnotification.MyLNotificationActivity;
import com.angeliur.lollipops.palette.PaletteActivity;


/**
 * Created by Administrator on 2018/2/1 0001.
 */

public class TransActivity extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);
    }

    // 设置不同动画效果
    public void explode(View view) {
        intent = new Intent(this, Transition.class);
        intent.putExtra("flag", 0);
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this)
                        .toBundle());
    }

    public void slide(View view) {
        intent = new Intent(this, Transition.class);
        intent.putExtra("flag", 1);
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this)
                        .toBundle());
    }

    public void fade(View view) {
        intent = new Intent(this, Transition.class);
        intent.putExtra("flag", 2);
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this)
                        .toBundle());
    }

    public void share(View view) {
        intent = new Intent(this, Transition.class);
        View fab = findViewById(R.id.fab_button);
        intent.putExtra("flag", 3);
        // 创建单个共享元素
//        startActivity(intent,
//                ActivityOptions.makeSceneTransitionAnimation(
//                        this, view, "share").toBundle());

        startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(this,
                // 创建多个共享元素
                Pair.create(view,"share"),
                Pair.create(fab,"fab")).toBundle());
    }
}
