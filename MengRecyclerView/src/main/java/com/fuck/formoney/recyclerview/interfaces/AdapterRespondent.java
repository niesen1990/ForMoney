package com.fuck.formoney.recyclerview.interfaces;

/**
 * Created by root on 15-10-17.
 */
public interface AdapterRespondent {
    /**
     * 数据发生变化
     */
    void onDataChanged();

    /**
     * 数据插入
     *
     * @param position int
     */
    void onDataInsert(int position);

    /**
     * 数据移除
     *
     * @param position int
     */
    void onDataRemove(int position);
}
