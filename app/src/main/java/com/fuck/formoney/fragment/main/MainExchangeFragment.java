package com.fuck.formoney.fragment.main;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fuck.formoney.R;
import com.fuck.formoney.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainExchangeFragment extends BaseFragment {

    public MainExchangeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_exchange, container, false);
        return rootView;
    }


}
