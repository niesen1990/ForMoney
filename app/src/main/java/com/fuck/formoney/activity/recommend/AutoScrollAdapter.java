package com.fuck.formoney.activity.recommend;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fuck.formoney.R;
import com.fuck.formoney.utils.PicassoTools;

import java.util.ArrayList;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/25 15:32
 */
public class AutoScrollAdapter extends PagerAdapter {
    private ArrayList<BannerModel> banners;
    private Context context;

    public AutoScrollAdapter(Context context, ArrayList<BannerModel> banners) {
        this.context = context;
        if (banners != null) {
            this.banners = banners;
        } else {
            this.banners = new ArrayList<>();
        }
    }


    @Override
    public int getCount() {
        return banners.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_recommend_banner_item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_banner);
        PicassoTools.loadImage(container.getContext(), banners.get(position).getImage(), imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
    }

}
