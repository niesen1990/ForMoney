package com.fuck.formoney.activity.main;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.fuck.formoney.R;
import com.fuck.formoney.base.BaseActivity;

public class LinkShareActivity extends BaseActivity {
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void init(Bundle savedInstanceState) {
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("限时推荐");
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_link_share;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_link_share, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
