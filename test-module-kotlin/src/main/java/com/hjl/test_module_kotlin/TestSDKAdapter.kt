package com.hjl.test_module_kotlin

import android.app.Application
import android.content.Context
import android.util.Log
import com.hjl.commonlib.base.ICommonCallback
import com.hjl.commonlib.base.ISDKAdapter
import org.json.JSONObject

/**
 * author: long
 * description please add a description here
 * Date: 2021/12/21
 */
class TestSDKAdapter : ISDKAdapter {

    override fun init(context: Context?, sdkInitInfo: JSONObject?, callback: ICommonCallback?) {
        Log.i("ZRouter","kt init")
        callback?.onFinished(1,"kt init success")
    }

    override fun initApp(app: Application) {
        Log.i("ZRouter","kt initApp")
    }



    companion object{
        val instance : TestSDKAdapter by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { TestSDKAdapter() }
    }
}