package com.fuck.formoney.recyclerview.interfaces;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Response;

import java.util.List;

/**
 * Created by root on 15-10-17.
 */
public interface DataProvider<T> {
    void doInitialize(Callback callback);

    void doRefresh(Callback callback);

    void doMore(Callback callback);

    List<T> doParser(Response response);

    void doSave(List<T> data);
}
