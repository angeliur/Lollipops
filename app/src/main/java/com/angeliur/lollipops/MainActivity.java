package com.angeliur.lollipops;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.angeliur.lollipops.animatedselector.AnimatedSelectorActivity;
import com.angeliur.lollipops.mylnotification.MyLNotificationActivity;
import com.angeliur.lollipops.palette.PaletteActivity;
import com.angeliur.lollipops.recyclerview.RecyclerViewActivity;
import com.angeliur.lollipops.toolbartest.ToolbarTestActivity;
import com.angeliur.lollipops.transactivity.TransActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openTransActivity(View view){
        startActivity(new Intent(this, TransActivity.class));
    }

    public void openAnimatedSelectorActivity(View view){
        startActivity(new Intent(this, AnimatedSelectorActivity.class));
    }

    public void openMyLNotification(View view){
        startActivity(new Intent(this, MyLNotificationActivity.class));
    }

    public void openPaletteActivity(View view){
        startActivity(new Intent(this, PaletteActivity.class));
    }

    public void openToolbarTestActivity(View view){
        startActivity(new Intent(this, ToolbarTestActivity.class));
    }

    public void openRecyclerViewActivity(View view){
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }
}
