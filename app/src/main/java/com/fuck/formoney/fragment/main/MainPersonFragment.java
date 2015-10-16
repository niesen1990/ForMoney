package com.fuck.formoney.fragment.main;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.fuck.formoney.R;
import com.fuck.formoney.activity.setting.SettingActivity;
import com.fuck.formoney.activity.user.InfoEditActivity;
import com.fuck.formoney.base.BaseFragment;
import com.fuck.formoney.base.Constants;
import com.fuck.formoney.utils.SPCache;
import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainPersonFragment extends BaseFragment {

    public MainPersonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    private RelativeLayout rl01;
    private ImageView ivHead;
    private AppCompatTextView tvName;
    private AppCompatTextView tvId;
    private CardView cv01;
    private CardView cv02;
    private CardView cv03;
    private CardView cv04;
    private CardView cv05;
    private CardView cv06;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_person, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rl01 = (RelativeLayout) view.findViewById(R.id.rl_01);
        ivHead = (ImageView) view.findViewById(R.id.iv_head);
        tvName = (AppCompatTextView) view.findViewById(R.id.tv_name);
        tvId = (AppCompatTextView) view.findViewById(R.id.tv_id);
        cv01 = (CardView) view.findViewById(R.id.cv_01);
        cv01.setOnClickListener(this);
        cv02 = (CardView) view.findViewById(R.id.cv_02);
        cv03 = (CardView) view.findViewById(R.id.cv_03);
        cv04 = (CardView) view.findViewById(R.id.cv_04);
        cv05 = (CardView) view.findViewById(R.id.cv_05);
        cv06 = (CardView) view.findViewById(R.id.cv_06);
        cv06.setOnClickListener(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_fragment_person, menu);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        String image = SPCache.getString(Constants.SharePreference.USER_HEAD_IMAGE, "");
        String nick = SPCache.getString(Constants.SharePreference.USER_NICK, "");
        if (!TextUtils.isEmpty(image)) {
            Picasso.with(getActivity()).load(image).fit().error(R.mipmap.ic_launcher).into(ivHead);
        }
        if (!TextUtils.isEmpty(nick)) {
            tvName.setText(nick);
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        Intent intent;
        switch (v.getId()) {
            case R.id.cv_01:
                intent = new Intent(getActivity(), InfoEditActivity.class);
                startActivity(intent);
                break;
            case R.id.cv_06:
                intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
                break;
        }
    }
}
