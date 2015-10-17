package com.fuck.formoney.base;

import android.support.v4.widget.SwipeRefreshLayout;

import com.fuck.formoney.recyclerview.interfaces.AdapterRespondent;
import com.fuck.formoney.recyclerview.interfaces.UIRespondent;

import java.util.List;

/**
 * 项目名称：ForMoney
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15-10-17 下午4:37
 * 修改人：N.Sun
 * 修改时间：15-10-17 下午4:37
 * 修改备注：
 */
public class ContentFragmentBase<T> extends BaseFragment implements UIRespondent<T>, AdapterRespondent, SwipeRefreshLayout.OnRefreshListener  {
    /**
     * 数据发生变化
     */
    @Override
    public void onDataChanged() {

    }

    /**
     * 数据插入
     *
     * @param position int
     */
    @Override
    public void onDataInsert(int position) {

    }

    /**
     * 数据移除
     *
     * @param position int
     */
    @Override
    public void onDataRemove(int position) {

    }

    @Override
    public void onRefresh() {

    }

    /**
     * 初始化（开始）
     */
    @Override
    public void onInitializeStart() {

    }

    /**
     * 初始化完成
     *
     * @param e    Exception
     * @param data List<T>
     */
    @Override
    public void onInitializeDone(Exception e, List<T> data) {

    }

    /**
     * 加载更多（开始）
     */
    @Override
    public void onLoadingMoreStart() {

    }

    /**
     * 加载更多完成
     *
     * @param e    Exception
     * @param data List<T>
     */
    @Override
    public void onLoadMoreDone(Exception e, List<T> data) {

    }

    /**
     * 开始刷新
     */
    @Override
    public void onRefreshingStart() {

    }

    /**
     * 刷新完成
     *
     * @param e    Exception
     * @param data List<T>
     */
    @Override
    public void onRefreshDone(Exception e, List<T> data) {

    }

    /**
     * 结束
     */
    @Override
    public void onEnd() {

    }
}
