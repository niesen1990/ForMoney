package com.fuck.formoney.fragment.recommend;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.fuck.formoney.recyclerview.actions.DataController;
import com.fuck.formoney.recyclerview.adapter.ContentAdapterBase;

/**
 * 项目名称：ForMoney
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15-10-17 下午4:18
 * 修改人：N.Sun
 * 修改时间：15-10-17 下午4:18
 * 修改备注：
 */
public class RecommendAdapter extends ContentAdapterBase<RecommendModel.DataEntity.ListEntity> {
    private Context mContext;

    public RecommendAdapter(Context mContext, DataController<RecommendModel.DataEntity.ListEntity> mDataController, boolean need) {
        super(mContext, mDataController);
        this.mContext = mContext;
        moreFlag = true;
        // 设置HeaderView
        setNeedHeadView(need);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateCustomContentHolder(ViewGroup parent, int viewType) {
        return RecommendViewHolder.create(mContext, parent);
    }


    @Override
    protected void onBindCustomViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RecommendViewHolder) holder).onBindViewHolder(mContext, mDataController.getData(position));
    }

}
