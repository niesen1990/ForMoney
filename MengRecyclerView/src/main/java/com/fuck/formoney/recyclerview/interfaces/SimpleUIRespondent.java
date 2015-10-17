package com.fuck.formoney.recyclerview.interfaces;

import java.util.List;

/**
 * Created by root on 15-10-17.
 */
public class SimpleUIRespondent<T> implements UIRespondent<T>  {
    @Override
    public void onInitializeStart() {

    }

    @Override
    public void onInitializeDone(Exception e, List<T> data) {

    }

    @Override
    public void onLoadingMoreStart() {

    }

    @Override
    public void onLoadMoreDone(Exception e, List<T> data) {

    }

    @Override
    public void onRefreshingStart() {

    }

    @Override
    public void onRefreshDone(Exception e, List<T> data) {

    }

    @Override
    public void onEnd() {

    }
}
