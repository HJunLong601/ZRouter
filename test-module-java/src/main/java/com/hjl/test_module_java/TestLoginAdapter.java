package com.hjl.test_module_java;

import android.content.Context;
import android.util.Log;

import com.hjl.commonlib.base.ICommonCallback;
import com.hjl.commonlib.base.ILoginAdapter;

import org.json.JSONObject;

/**
 * author: long
 * description please add a description here
 * Date: 2021/12/21
 */
public class TestLoginAdapter implements ILoginAdapter {

    public String TAG = "ZRouter";

    private static TestLoginAdapter sInstance;

    public static synchronized TestLoginAdapter getInstance() {
        if (sInstance == null) {
            sInstance = new TestLoginAdapter();
        }
        return sInstance;
    }

    @Override
    public void login(Context context, JSONObject loginInfo, ICommonCallback callback) {
        Log.i("ZRouter", "java login");
        callback.onFinished(1,"java login",null);
    }

    @Override
    public void logout(Context context, ICommonCallback callback) {
        Log.i("ZRouter", "java logout");
        callback.onFinished(1,"java login",null);
    }


}
