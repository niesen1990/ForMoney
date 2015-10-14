package com.fuck.formoney.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 项目名称：ForMoney
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15/9/8 下午8:55
 */
public class PackageModel implements Parcelable {

    private long downloadId;
    private String fileName;
    private String packageName;

    public long getDownloadId() {
        return downloadId;
    }

    public void setDownloadId(long downloadId) {
        this.downloadId = downloadId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.downloadId);
        dest.writeString(this.fileName);
        dest.writeString(this.packageName);
    }

    public PackageModel() {
    }

    protected PackageModel(Parcel in) {
        this.downloadId = in.readLong();
        this.fileName = in.readString();
        this.packageName = in.readString();
    }

    public static final Parcelable.Creator<PackageModel> CREATOR = new Parcelable.Creator<PackageModel>() {
        public PackageModel createFromParcel(Parcel source) {
            return new PackageModel(source);
        }

        public PackageModel[] newArray(int size) {
            return new PackageModel[size];
        }
    };
}
