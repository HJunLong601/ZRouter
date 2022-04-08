package com.hjl.zrouterdemo

import android.app.Application
import android.content.Context
import com.hjl.commonlib.DemoSDK

/**
 * author: long
 * description please add a description here
 * Date: 2022/4/8
 */
class DemoApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

        DemoSDK.instance.init(base!!)

    }

    override fun onCreate() {
        super.onCreate()

        DemoSDK.instance.initApp(this)
    }
}