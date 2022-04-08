package com.hjl.test_module_java;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.hjl.commonlib.base.ICommonCallback;
import com.hjl.commonlib.base.ISDKAdapter;

import org.json.JSONObject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * author: long
 * description please add a description here
 * Date: 2021/12/21
 */
public class TestSDKAdapter implements ISDKAdapter {

    private static TestSDKAdapter sInstance;

    public static synchronized TestSDKAdapter getInstance() {
        if (sInstance == null) {
            sInstance = new TestSDKAdapter();
        }
        return sInstance;
    }


    @Override
    public boolean exit(Context context, boolean shouldKillGameProcess) {
        return false;
    }


    @Override
    public void init(@Nullable Context context, @Nullable JSONObject sdkInitInfo, @Nullable ICommonCallback callback) {
        Log.i("ZRouter","java init");
        callback.onFinished(1,"java init",null);
    }

    @Override
    public void initApp(@NonNull Application app) {
        Log.i("ZRouter","java initApp");
    }
}
