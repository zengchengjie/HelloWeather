package com.example.a10062376.helloweather.utils;

import android.app.Application;
import android.content.Context;

import com.example.a10062376.helloweather.base.BasePreference;

/**
 * Created by zengchengjie on 2018/4/11.
 * 具体实现sp
 * 引用示例:
 * PreferenceUtils preferenceUtils = PreferenceUtils.getInstance();
   preferenceUtils.setFirstLaunch(true);
   String userName = preferenceUtils.getUserName();
 */
public class PreferenceUtils extends BasePreference {
    private static PreferenceUtils preferenceUtils;
    /**
     * 需要增加key就在这里新建
     */
    //用户名的key
    private String USER_NAME = "user_name";
    //是否首次启动的key
    private String FIRST_LAUNCH = "first_launch";


    private PreferenceUtils(Context context) {
        super(context);
    }

    /**
     * 这里我通过自定义的Application来获取Context对象，所以在获取preferenceUtils时不需要传入Context。
     * @return
     */
    public synchronized static PreferenceUtils getInstance(Context context) {
        if (null == preferenceUtils) {
            preferenceUtils = new PreferenceUtils(context);
        }
        return preferenceUtils;
    }

    public void setFirstLaunch(boolean isFirst) {
        setBoolean(FIRST_LAUNCH,isFirst);
    }

    public boolean getFirstlaunch() {
        return getBoolean(FIRST_LAUNCH);
    }

    public void setUserName(String name) {
        setString("fefe", name);
    }

    public String getUSER_NAME_KEY() {
        return getString(USER_NAME);
    }
}