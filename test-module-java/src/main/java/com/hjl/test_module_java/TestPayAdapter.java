package com.hjl.test_module_java;

import android.content.Context;
import android.util.Log;

import com.hjl.commonlib.base.BasePayAdapter;
import com.hjl.commonlib.base.ICommonCallback;

import org.json.JSONObject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * author: long
 * description please add a description here
 * Date: 2021/12/21
 */
public class TestPayAdapter extends BasePayAdapter {

    private static TestPayAdapter sInstance;

    public static synchronized TestPayAdapter getInstance() {
        if (sInstance == null) {
            sInstance = new TestPayAdapter();
        }
        return sInstance;
    }

    @Override
    public void pay(@Nullable Context context, @NonNull JSONObject sdkPayInfo, @Nullable ICommonCallback callback) {
        Log.i("ZRouter", "java pay ");
        callback.onFinished(1,"java pay ",null);
    }
}
