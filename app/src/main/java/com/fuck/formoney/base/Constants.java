package com.fuck.formoney.base;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/10 13:09
 */
public class Constants {
    public static String packageName = "com.cmbb.smartkids";
    public static final String INTENT_ACTION_EXIT_APP = packageName + ".intent.action.exitapp";
    public final static int CANCEL_WAIT_DIALOG = 10001;
    public final static String BASE_URL = "http://121.41.94.101:8098/";
    //public final static String BASE_URL = "http://192.168.100.158:8080/qj-web/";

    public static class SharePreference {
        public static final String SCREEN_WIDTH = "screen_width";
        public static final String SCREEN_HEIGHT = "screen_height";
        public static final String IS_FIRST_INTO = "is_first_info";
        public static final String USER_TOKEN = "token";
        // user
        public static final String USER_HEAD_IMAGE = "user_head_image";
        public static final String USER_STATUS = "user_status";
        public static final String USER_NICK = "user_nick";
        public static final String USER_PROFESSION = "user_profession";
        public static final String USER_PHONE = "user_phone";
        public static final String USER_SEX = "user_sex";
        public static final String USER_BIRTHDAY = "user_birthday";
    }

    public static final class Share {
        public static final String WEIXIN_APP_KEY = "wx766b807ef51aa8da";
        public static final String WEIXIN_APPSECRET = "139fc6ccddba72262d94688368082312";

        public static final String QQ_APP_KEY = "1104000906";
        public static final String QQ_APPSECRET = "T73NH4Tz75dWsPdy";

        public static final String DESCRIPTOR = "com.cmbb.smartkids";
    }

    public static final class Broadcast {
        public static final String COUNT_TIME = "com.cmbb.smartkids.counttimen";
    }

    public static final class LoginAndRegister {
        public static final String GETREGISTSECURITYCODE = BASE_URL + "user/getRegistSecurityCode";
        public static final String REGISTER = BASE_URL + "user/register";
        public static final String LOGIN = BASE_URL + "user/login";
    }

    public static final class UserInfo {
        public static final String UPDATE_USER_BASIC = BASE_URL + "user/updateUserBasic";
        public static final String USER_PROFIT = BASE_URL + "/profit/getUserProfit";
    }
}
