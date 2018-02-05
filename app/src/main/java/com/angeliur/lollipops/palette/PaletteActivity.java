package com.angeliur.lollipops.palette;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.Window;

import com.angeliur.lollipops.R;

/**
 * Created by Administrator on 2018/2/1 0001.
 */

public class PaletteActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        // 创建Palette对象
        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                // 通过Palette来获取对应的色调
                Palette.Swatch swatch = palette.getDarkVibrantSwatch();
                // 将颜色设置给相应的组件
                getActionBar().setBackgroundDrawable(new ColorDrawable(swatch.getRgb()));
                Window window = getWindow();
                window.setStatusBarColor(swatch.getRgb());
            }
        });
    }
}
