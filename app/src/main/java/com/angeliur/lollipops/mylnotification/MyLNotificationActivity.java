package com.angeliur.lollipops.mylnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.icu.util.ULocale;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RemoteViews;

import com.angeliur.lollipops.R;

/**
 * Created by Administrator on 2018/2/1 0001.
 */

public class MyLNotificationActivity extends AppCompatActivity {

    private int NOTIFICATION_ID_BASIC = 1;
    private int NOTIFICATION_ID_COLLAPSE = 2;
    private int NOTIFICATION_ID_HEADSUP = 3;
    private int NOTIFICATION_ID_VISIBILITY = 4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notification);
    }

    public void basicNotify(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        // 构造PendingIntent
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification.Builder builder = new Notification.Builder(this);
        // 设置Notification的各种属性
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));

        builder.setContentTitle("Basic Notifications");
        builder.setContentText("I am a basic notification");
        builder.setSubText("it is really basic");
        // 通过NotificationManager来发出Notification
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID_BASIC,builder.build());

    }

    public void collapsedNotify(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.sina.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0, intent, 0);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(
                getResources(), R.mipmap.ic_launcher));
        // 通过RemoteViews来创建自定义的Notification视图
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification);
        remoteViews.setTextViewText(R.id.textView,"show me when collapsed");
        Notification notification = builder.build();
        notification.contentView = remoteViews;

        // 通过RemoteViews来创建自定义的Notification视图
        RemoteViews remoteViews2 = new RemoteViews(getPackageName(), R.layout.notification_expanded);
        notification.bigContentView = remoteViews2;

        // 通过NotificationManager来发出Notification
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID_COLLAPSE,notification);

    }

    public void headsupNotify(View view){
        Notification.Builder builder = new Notification.Builder(this)
                .setContentTitle("Notification for Visibility Test")
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle("Headsup Notification")
                .setContentText("I am a Headsup notification.");
        Intent push = new Intent();
        push.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        push.setClass(this,MyLNotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, push, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentText("Heads-Up Notification on Android 5.0")
                .setFullScreenIntent(pendingIntent,true);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID_HEADSUP,builder.build());

    }

    public void visibilityNotify(View view){
        RadioGroup radioGroup = (RadioGroup) findViewById(
                R.id.visibility_radio_group);
        Notification.Builder builder = new Notification.Builder(this)
                .setContentTitle("Notification for Visibility Test");
        switch (radioGroup.getCheckedRadioButtonId()){
            case R.id.radio_button_public:
                builder.setVisibility(Notification.VISIBILITY_PUBLIC);
                builder.setContentText("public");
                builder.setSmallIcon(R.drawable.ic_public);
                break;
            case R.id.radio_button_private:
                builder.setVisibility(Notification.VISIBILITY_PRIVATE);
                builder.setContentText("private");
                builder.setSmallIcon(R.drawable.ic_private);
                break;
            case R.id.radio_button_secret:
                builder.setVisibility(Notification.VISIBILITY_SECRET);
                builder.setContentText("secret");
                builder.setSmallIcon(R.drawable.ic_secret);
                break;

        }
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID_VISIBILITY,builder.build());
    }
}
