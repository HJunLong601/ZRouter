package com.hjl.test_module_kotlin

import android.content.Context
import android.util.Log
import com.hjl.commonlib.base.ICommonCallback
import com.hjl.commonlib.base.ILoginAdapter
import org.json.JSONObject

/**
 * author: long
 * description please add a description here
 * Date: 2021/12/21
 */
class TestLoginAdapter : ILoginAdapter{
    override fun login(context: Context, loginInfo: JSONObject, callback: ICommonCallback) {
        Log.i("ZRouter", "kt login")
        callback.onFinished(1,"kt login")
    }

    override fun logout(context: Context?, callback: ICommonCallback) {
        Log.i("ZRouter", "kt logout")
        callback.onFinished(1,"kt logout")
    }


    companion object{
        val instance : TestLoginAdapter by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { TestLoginAdapter() }
    }
}