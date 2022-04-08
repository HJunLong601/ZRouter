package com.hjl.test_module_java;

import android.content.Context;
import android.util.Log;

import com.hjl.commonlib.base.ICommonCallback;
import com.hjl.commonlib.base.IExtentAdapter;

/**
 * author: long
 * description please add a description here
 * Date: 2021/12/21
 */
public class TestExtentAdapter implements IExtentAdapter {

    public String TAG = "ZRouter";

    private static TestExtentAdapter sInstance;

    public static synchronized TestExtentAdapter getInstance() {
        if (sInstance == null) {
            sInstance = new TestExtentAdapter();
        }

        return sInstance;
    }


    @Override
    public Integer[] getSupportActions() {
        return new Integer[]{1};
    }

    @Override
    public void doAction(Context context, int actionId, ICommonCallback callback, Object... objArr) {
        if (actionId == 1){
            Log.i(TAG, "doAction: 1");
        }
    }

    @Override
    public String doActionSync(Context context, int actionId) {
        if (actionId == 2){
            return "action 2 success";
        }

        return null;
    }


    @Override
    public void doAction(Context context, int actionId) {

    }

    @Override
    public void doAction(Context context, int actionId, Object... objArr) {

    }
}
