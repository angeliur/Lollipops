package com.angeliur.lollipops.animatedselector;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.angeliur.lollipops.R;

/**
 * Created by Administrator on 2018/2/1 0001.
 */

public class AnimatedSelectorActivity extends AppCompatActivity {

    private boolean mIsCheck;
    private static final int[] STATE_CHECKED = new int[]{
            android.R.attr.state_checked};
    private static final int[] STATE_UNCHECKED = new int[]{};
    private ImageView imageView;
    private Drawable drawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_selector);
        imageView = (ImageView) findViewById(R.id.image);
        drawable = getResources().getDrawable(R.drawable.fab_anim);
        imageView.setImageDrawable(drawable);
    }

    public void anim(View view){
        if (mIsCheck){
            imageView.setImageState(STATE_UNCHECKED,true);
            mIsCheck = false;
        }else {
            imageView.setImageState(STATE_CHECKED,true);
            mIsCheck = true;
        }
    }
}
