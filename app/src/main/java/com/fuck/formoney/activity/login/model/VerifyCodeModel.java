package com.fuck.formoney.activity.login.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 项目名称：ForMoney
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15/10/13 下午7:58
 */
public class VerifyCodeModel implements Parcelable {


    /**
     * resultMsg : 发送成功
     * statusCode : 200
     */

    private String resultMsg;
    private int statusCode;

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return "VerifyCodeModel{" +
                "resultMsg='" + resultMsg + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.resultMsg);
        dest.writeInt(this.statusCode);
    }

    public VerifyCodeModel() {
    }

    protected VerifyCodeModel(Parcel in) {
        this.resultMsg = in.readString();
        this.statusCode = in.readInt();
    }

    public static final Parcelable.Creator<VerifyCodeModel> CREATOR = new Parcelable.Creator<VerifyCodeModel>() {
        public VerifyCodeModel createFromParcel(Parcel source) {
            return new VerifyCodeModel(source);
        }

        public VerifyCodeModel[] newArray(int size) {
            return new VerifyCodeModel[size];
        }
    };
}
