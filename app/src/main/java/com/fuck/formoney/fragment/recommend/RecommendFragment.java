package com.fuck.formoney.fragment.recommend;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;

import com.fuck.formoney.base.CommonFragment;
import com.fuck.formoney.recyclerview.actions.DataController;

/**
 * 项目名称：ForMoney
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15-10-17 下午4:35
 * 修改人：N.Sun
 * 修改时间：15-10-17 下午4:35
 * 修改备注：
 */
public class RecommendFragment extends CommonFragment<RecommendModel.DataEntity.ListEntity> {
    boolean need;


    public RecommendFragment() {
    }

    @SuppressLint("ValidFragment")
    public RecommendFragment(boolean needHeadView) {
        this.need = needHeadView;
    }

    @Override
    protected DataController<RecommendModel.DataEntity.ListEntity> onGenerateDataController() {
        return new RecommendProvider(getActivity());
    }

    @Override
    protected RecyclerView.Adapter onGenerateAdapter(DataController<RecommendModel.DataEntity.ListEntity> controller) {
        return new RecommendAdapter(getActivity(), controller, need);
    }

    @Override
    protected boolean enableRefresh() {
        return true;
    }
}
