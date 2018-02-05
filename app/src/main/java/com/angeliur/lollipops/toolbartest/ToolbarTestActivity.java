package com.angeliur.lollipops.toolbartest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.angeliur.lollipops.R;

/**
 * Created by Administrator on 2018/2/1 0001.
 */

public class ToolbarTestActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_test);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        // 标题的文字需在setSupportActionBar之前，不然会无效
        toolbar.setTitle("主标题");
        toolbar.setSubtitle("副标题");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.abc_action_bar_home_description,R.string.abc_action_bar_home_description_format);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        // 菜单的监听可以在toolbar里设置，
        // 也可通过Activity的onOptionsItemSelected回调方法来处理
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId){
                    case R.id.ab_setting:
                        Toast.makeText(ToolbarTestActivity.this,"setting",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        /* ShareActionProvider配置 */
        ShareActionProvider actionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menu.findItem(R.id.ab_share));
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        actionProvider.setShareIntent(intent);
        return super.onCreateOptionsMenu(menu);
    }
}
