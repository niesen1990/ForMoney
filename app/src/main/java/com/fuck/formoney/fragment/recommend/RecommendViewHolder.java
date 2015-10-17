package com.fuck.formoney.fragment.recommend;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fuck.formoney.R;
import com.fuck.formoney.activity.recommend.RecommendDetailActivity;
import com.fuck.formoney.utils.PicassoTools;
import com.fuck.formoney.utils.TDevice;
import com.fuck.formoney.utils.log.Log;

/**
 * 项目名称：ForMoney
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15-10-17 下午2:20
 * 修改人：N.Sun
 * 修改时间：15-10-17 下午2:20
 * 修改备注：
 */
public class RecommendViewHolder extends RecyclerView.ViewHolder {

    private RelativeLayout tl_item;
    private ImageView civ_head;
    private TextView tv_title;
    private TextView tv_money;
    private TextView tv_record;
    private TextView btn_download;

    private RecommendViewHolder(View view) {
        super(view);
        tl_item = (RelativeLayout) view.findViewById(R.id.tl_item);
        civ_head = (ImageView) view.findViewById(R.id.civ_head);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_money = (TextView) view.findViewById(R.id.tv_money);
        tv_record = (TextView) view.findViewById(R.id.tv_record);
        btn_download = (TextView) view.findViewById(R.id.btn_download);
    }

    public static RecommendViewHolder create(final Context mContext, ViewGroup parent) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.fragment_recommend_item, parent, false);
        return new RecommendViewHolder(v);
    }

    public void onBindViewHolder(final Context context, final RecommendModel.DataEntity.ListEntity entry) {
        tl_item.setTag(entry);
        tl_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecommendModel.DataEntity.ListEntity listEntity = (RecommendModel.DataEntity.ListEntity) tl_item.getTag();
                Log.e("package", "package = " + TDevice.checkApkExist(context, entry.getPacketName()));
                Intent intent = new Intent(context, RecommendDetailActivity.class);
                intent.putExtra("id", listEntity.getId()+"");
                context.startActivity(intent);
            }
        });
        btn_download.setTag(entry);
        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        PicassoTools.loadImage(context, entry.getTaskImgPath(), civ_head);
        tv_title.setText(entry.getTaskItemName());
    }

}
