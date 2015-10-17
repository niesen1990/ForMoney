package com.fuck.formoney.activity.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.fuck.formoney.R;
import com.fuck.formoney.base.BaseActivity;
import com.fuck.formoney.fragment.recommend.RecommendFragment;

public class LinkShareActivity extends BaseActivity {

    @Override
    protected void init(Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new RecommendFragment(false)).commit();
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
