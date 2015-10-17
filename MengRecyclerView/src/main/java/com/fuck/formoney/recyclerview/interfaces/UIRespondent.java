package com.fuck.formoney.recyclerview.interfaces;

import java.util.List;

/**
 * Created by root on 15-10-17.
 */
public interface UIRespondent<T>  {
    /**
     * 初始化（开始）
     */
    void onInitializeStart();

    /**
     * 初始化完成
     *
     * @param e    Exception
     * @param data List<T>
     */
    void onInitializeDone(Exception e, List<T> data);

    /**
     * 加载更多（开始）
     */
    void onLoadingMoreStart();

    /**
     * 加载更多完成
     *
     * @param e    Exception
     * @param data List<T>
     */
    void onLoadMoreDone(Exception e, List<T> data);

    /**
     * 开始刷新
     */
    void onRefreshingStart();

    /**
     * 刷新完成
     *
     * @param e    Exception
     * @param data List<T>
     */
    void onRefreshDone(Exception e, List<T> data);

    /**
     * 结束
     */
    void onEnd();
}
