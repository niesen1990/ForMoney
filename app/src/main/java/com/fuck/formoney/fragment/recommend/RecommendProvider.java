package com.fuck.formoney.fragment.recommend;

import android.content.Context;
import android.text.TextUtils;

import com.fuck.formoney.base.BaseApplication;
import com.fuck.formoney.base.Constants;
import com.fuck.formoney.network.OkHttpClientManager;
import com.fuck.formoney.recyclerview.actions.DataController;
import com.fuck.formoney.utils.log.Log;
import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目名称：ForMoney
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15-10-17 下午2:04
 * 修改人：N.Sun
 * 修改时间：15-10-17 下午2:04
 * 修改备注：
 */
public class RecommendProvider extends DataController<RecommendModel.DataEntity.ListEntity> {

    private Context mContext;
    private int pageCount = 1;

    public RecommendProvider(Context context) {
        mContext = context;
    }
    @Override
    public void doInitialize(Callback callback) {
        pageCount = 1;
        Map<String, String> body = new HashMap<>();
        body.put("tokenId", BaseApplication.token);
        body.put("pageNo", pageCount+"");
        body.put("pageSize", "10");
        OkHttpClientManager.asyncPost(Constants.Recommend.RECOMMEND_GETPAGE, body, callback);
    }

    @Override
    public void doRefresh(Callback callback) {
        pageCount = 1;
        Map<String, String> body = new HashMap<>();
        body.put("tokenId", BaseApplication.token);
        body.put("pageNo", pageCount+"");
        body.put("pageSize", "10");
        OkHttpClientManager.asyncPost(Constants.Recommend.RECOMMEND_GETPAGE, body, callback);
    }

    @Override
    public void doMore(Callback callback) {
        pageCount = pageCount++;
        Map<String, String> body = new HashMap<>();
        body.put("tokenId", BaseApplication.token);
        body.put("pageNo", pageCount+"");
        body.put("pageSize", "10");
        OkHttpClientManager.asyncPost(Constants.Recommend.RECOMMEND_GETPAGE, body, callback);

    }

    @Override
    public List<RecommendModel.DataEntity.ListEntity> doParser(Response response) {
        try {
            String result = response.body().string();
            Log.i("response", "response = " + result);
            if (TextUtils.isEmpty(result)) {
                return null;
            }
            Gson gson = new Gson();
            RecommendModel data = gson.fromJson(result, RecommendModel.class);
            return data.getData().getList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void doSave(List<RecommendModel.DataEntity.ListEntity> data) {

    }
}
