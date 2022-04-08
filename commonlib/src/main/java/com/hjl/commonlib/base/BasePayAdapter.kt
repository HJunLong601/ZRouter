package com.hjl.commonlib.base

import android.content.Context
import org.json.JSONObject

/**
 * author: long
 * description please add a description here
 * Date: 2021/12/21
 */
abstract class BasePayAdapter : IPayAdapter {

    override fun performPay(
        context: Context?,
        sdkPayInfo: JSONObject,
        callback: ICommonCallback?
    ) {
        // do something before pay ,like report or check user info

        pay(context, sdkPayInfo,callback)
    }

    abstract fun pay(
        context: Context?,
        sdkPayInfo: JSONObject,
        callback: ICommonCallback?
    )

}