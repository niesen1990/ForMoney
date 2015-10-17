package com.fuck.formoney.activity.recommend;

/**
 * 项目名称：ForMoney
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15-10-17 下午6:00
 * 修改人：N.Sun
 * 修改时间：15-10-17 下午6:00
 * 修改备注：
 */
public class BannerModel {

    private String image;
    private String title;

    public BannerModel(String image, String title) {
        this.image = image;
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
