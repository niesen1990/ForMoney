package com.fuck.formoney.activity.login.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 项目名称：ForMoney
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15/10/13 下午8:18
 */
public class RegisterModel implements Parcelable {

    /**
     * resultMsg : 用户登陆成功
     * statusCode : 200
     * tokenId : 66B8C1A3E0D24EAE85B94210A12A819E
     * data : {"appVersion":"","inviteCode":"CYL7Jvtt","loginDate":"2015-10-14 17:32:05","loginPassword":"e10adc3949ba59abbe56e057f20f883e","userAddress":"","userBigHeadImgUrl":"","userBigImgHeight":"","userBigImgWidth":"","userBirthday":"","userCity":"","userIndex":"","userMail":"","userNick":"","userPhone":"13818155072","userPhoneVersion":"","userProfession":"","userSex":"","userSignContext":"","userSmallHeadImgUrl":"","userSmallImgHeight":"","userSmallImgWidth":"","userStatus":0}
     * appPushToken : 9ab1efc820304358bd351df8af8f197c
     */

    private String resultMsg;
    private int statusCode;
    private String tokenId;
    private DataEntity data;
    private String appPushToken;

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setAppPushToken(String appPushToken) {
        this.appPushToken = appPushToken;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getTokenId() {
        return tokenId;
    }

    public DataEntity getData() {
        return data;
    }

    public String getAppPushToken() {
        return appPushToken;
    }

    public static class DataEntity implements Parcelable {
        /**
         * appVersion :
         * inviteCode : CYL7Jvtt
         * loginDate : 2015-10-14 17:32:05
         * loginPassword : e10adc3949ba59abbe56e057f20f883e
         * userAddress :
         * userBigHeadImgUrl :
         * userBigImgHeight :
         * userBigImgWidth :
         * userBirthday :
         * userCity :
         * userIndex :
         * userMail :
         * userNick :
         * userPhone : 13818155072
         * userPhoneVersion :
         * userProfession :
         * userSex :
         * userSignContext :
         * userSmallHeadImgUrl :
         * userSmallImgHeight :
         * userSmallImgWidth :
         * userStatus : 0
         */

        private String appVersion;
        private String inviteCode;
        private String loginDate;
        private String loginPassword;
        private String userAddress;
        private String userBigHeadImgUrl;
        private String userBigImgHeight;
        private String userBigImgWidth;
        private String userBirthday;
        private String userCity;
        private String userIndex;
        private String userMail;
        private String userNick;
        private String userPhone;
        private String userPhoneVersion;
        private String userProfession;
        private String userSex;
        private String userSignContext;
        private String userSmallHeadImgUrl;
        private String userSmallImgHeight;
        private String userSmallImgWidth;
        private int userStatus;

        public void setAppVersion(String appVersion) {
            this.appVersion = appVersion;
        }

        public void setInviteCode(String inviteCode) {
            this.inviteCode = inviteCode;
        }

        public void setLoginDate(String loginDate) {
            this.loginDate = loginDate;
        }

        public void setLoginPassword(String loginPassword) {
            this.loginPassword = loginPassword;
        }

        public void setUserAddress(String userAddress) {
            this.userAddress = userAddress;
        }

        public void setUserBigHeadImgUrl(String userBigHeadImgUrl) {
            this.userBigHeadImgUrl = userBigHeadImgUrl;
        }

        public void setUserBigImgHeight(String userBigImgHeight) {
            this.userBigImgHeight = userBigImgHeight;
        }

        public void setUserBigImgWidth(String userBigImgWidth) {
            this.userBigImgWidth = userBigImgWidth;
        }

        public void setUserBirthday(String userBirthday) {
            this.userBirthday = userBirthday;
        }

        public void setUserCity(String userCity) {
            this.userCity = userCity;
        }

        public void setUserIndex(String userIndex) {
            this.userIndex = userIndex;
        }

        public void setUserMail(String userMail) {
            this.userMail = userMail;
        }

        public void setUserNick(String userNick) {
            this.userNick = userNick;
        }

        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }

        public void setUserPhoneVersion(String userPhoneVersion) {
            this.userPhoneVersion = userPhoneVersion;
        }

        public void setUserProfession(String userProfession) {
            this.userProfession = userProfession;
        }

        public void setUserSex(String userSex) {
            this.userSex = userSex;
        }

        public void setUserSignContext(String userSignContext) {
            this.userSignContext = userSignContext;
        }

        public void setUserSmallHeadImgUrl(String userSmallHeadImgUrl) {
            this.userSmallHeadImgUrl = userSmallHeadImgUrl;
        }

        public void setUserSmallImgHeight(String userSmallImgHeight) {
            this.userSmallImgHeight = userSmallImgHeight;
        }

        public void setUserSmallImgWidth(String userSmallImgWidth) {
            this.userSmallImgWidth = userSmallImgWidth;
        }

        public void setUserStatus(int userStatus) {
            this.userStatus = userStatus;
        }

        public String getAppVersion() {
            return appVersion;
        }

        public String getInviteCode() {
            return inviteCode;
        }

        public String getLoginDate() {
            return loginDate;
        }

        public String getLoginPassword() {
            return loginPassword;
        }

        public String getUserAddress() {
            return userAddress;
        }

        public String getUserBigHeadImgUrl() {
            return userBigHeadImgUrl;
        }

        public String getUserBigImgHeight() {
            return userBigImgHeight;
        }

        public String getUserBigImgWidth() {
            return userBigImgWidth;
        }

        public String getUserBirthday() {
            return userBirthday;
        }

        public String getUserCity() {
            return userCity;
        }

        public String getUserIndex() {
            return userIndex;
        }

        public String getUserMail() {
            return userMail;
        }

        public String getUserNick() {
            return userNick;
        }

        public String getUserPhone() {
            return userPhone;
        }

        public String getUserPhoneVersion() {
            return userPhoneVersion;
        }

        public String getUserProfession() {
            return userProfession;
        }

        public String getUserSex() {
            return userSex;
        }

        public String getUserSignContext() {
            return userSignContext;
        }

        public String getUserSmallHeadImgUrl() {
            return userSmallHeadImgUrl;
        }

        public String getUserSmallImgHeight() {
            return userSmallImgHeight;
        }

        public String getUserSmallImgWidth() {
            return userSmallImgWidth;
        }

        public int getUserStatus() {
            return userStatus;
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "appVersion='" + appVersion + '\'' +
                    ", inviteCode='" + inviteCode + '\'' +
                    ", loginDate='" + loginDate + '\'' +
                    ", loginPassword='" + loginPassword + '\'' +
                    ", userAddress='" + userAddress + '\'' +
                    ", userBigHeadImgUrl='" + userBigHeadImgUrl + '\'' +
                    ", userBigImgHeight='" + userBigImgHeight + '\'' +
                    ", userBigImgWidth='" + userBigImgWidth + '\'' +
                    ", userBirthday='" + userBirthday + '\'' +
                    ", userCity='" + userCity + '\'' +
                    ", userIndex='" + userIndex + '\'' +
                    ", userMail='" + userMail + '\'' +
                    ", userNick='" + userNick + '\'' +
                    ", userPhone='" + userPhone + '\'' +
                    ", userPhoneVersion='" + userPhoneVersion + '\'' +
                    ", userProfession='" + userProfession + '\'' +
                    ", userSex='" + userSex + '\'' +
                    ", userSignContext='" + userSignContext + '\'' +
                    ", userSmallHeadImgUrl='" + userSmallHeadImgUrl + '\'' +
                    ", userSmallImgHeight='" + userSmallImgHeight + '\'' +
                    ", userSmallImgWidth='" + userSmallImgWidth + '\'' +
                    ", userStatus=" + userStatus +
                    '}';
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.appVersion);
            dest.writeString(this.inviteCode);
            dest.writeString(this.loginDate);
            dest.writeString(this.loginPassword);
            dest.writeString(this.userAddress);
            dest.writeString(this.userBigHeadImgUrl);
            dest.writeString(this.userBigImgHeight);
            dest.writeString(this.userBigImgWidth);
            dest.writeString(this.userBirthday);
            dest.writeString(this.userCity);
            dest.writeString(this.userIndex);
            dest.writeString(this.userMail);
            dest.writeString(this.userNick);
            dest.writeString(this.userPhone);
            dest.writeString(this.userPhoneVersion);
            dest.writeString(this.userProfession);
            dest.writeString(this.userSex);
            dest.writeString(this.userSignContext);
            dest.writeString(this.userSmallHeadImgUrl);
            dest.writeString(this.userSmallImgHeight);
            dest.writeString(this.userSmallImgWidth);
            dest.writeInt(this.userStatus);
        }

        public DataEntity() {
        }

        protected DataEntity(Parcel in) {
            this.appVersion = in.readString();
            this.inviteCode = in.readString();
            this.loginDate = in.readString();
            this.loginPassword = in.readString();
            this.userAddress = in.readString();
            this.userBigHeadImgUrl = in.readString();
            this.userBigImgHeight = in.readString();
            this.userBigImgWidth = in.readString();
            this.userBirthday = in.readString();
            this.userCity = in.readString();
            this.userIndex = in.readString();
            this.userMail = in.readString();
            this.userNick = in.readString();
            this.userPhone = in.readString();
            this.userPhoneVersion = in.readString();
            this.userProfession = in.readString();
            this.userSex = in.readString();
            this.userSignContext = in.readString();
            this.userSmallHeadImgUrl = in.readString();
            this.userSmallImgHeight = in.readString();
            this.userSmallImgWidth = in.readString();
            this.userStatus = in.readInt();
        }

        public static final Parcelable.Creator<DataEntity> CREATOR = new Parcelable.Creator<DataEntity>() {
            public DataEntity createFromParcel(Parcel source) {
                return new DataEntity(source);
            }

            public DataEntity[] newArray(int size) {
                return new DataEntity[size];
            }
        };
    }

    @Override
    public String toString() {
        return "RegisterModel{" +
                "resultMsg='" + resultMsg + '\'' +
                ", statusCode=" + statusCode +
                ", tokenId='" + tokenId + '\'' +
                ", data=" + data +
                ", appPushToken='" + appPushToken + '\'' +
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
        dest.writeString(this.tokenId);
        dest.writeParcelable(this.data, 0);
        dest.writeString(this.appPushToken);
    }

    public RegisterModel() {
    }

    protected RegisterModel(Parcel in) {
        this.resultMsg = in.readString();
        this.statusCode = in.readInt();
        this.tokenId = in.readString();
        this.data = in.readParcelable(DataEntity.class.getClassLoader());
        this.appPushToken = in.readString();
    }

    public static final Parcelable.Creator<RegisterModel> CREATOR = new Parcelable.Creator<RegisterModel>() {
        public RegisterModel createFromParcel(Parcel source) {
            return new RegisterModel(source);
        }

        public RegisterModel[] newArray(int size) {
            return new RegisterModel[size];
        }
    };
}
