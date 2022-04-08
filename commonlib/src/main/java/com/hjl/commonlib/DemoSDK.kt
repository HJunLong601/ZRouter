package com.hjl.commonlib

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.hjl.commonlib.base.*
import com.hjl.zrouter.api.ZRouter


/**
 * author: long
 * description please add a description here
 * Date: 2021/12/28
 */
class DemoSDK {

    val supportChannelList = mutableMapOf<String,IChannelAdapter>()

    val supportLoginList = mutableListOf<ILoginAdapter>()
    val supportSDKList = mutableListOf<ISDKAdapter>()
    val supportPayList = mutableListOf<IPayAdapter>()
    val supportExtendList = mutableListOf<IExtentAdapter>()
    lateinit var context: Context

    fun init(context : Context){
        this.context = context
        ZRouter.getInstance().init(context)

        ZRouter.getInstance().routeMetaList.forEach {

            Log.i("ZRouter", "get route meta:$it ")
            val newInstance = it.destination.getConstructor().newInstance() as IChannelAdapter
            supportChannelList[it.path] = newInstance
        }

        supportChannelList.values.forEach { channel ->

            channel.getExtentAdapter()?.let {
                supportExtendList.add(it)
            }

            channel.getPayAdapter()?.let {
                supportPayList.add(it)
            }

            channel.getSDKAdapter().let {
                supportSDKList.add(it)
            }

            channel.getLoginAdapter()?.let {
                supportLoginList.add(it)
            }
        }


        Log.i("ZRouter","get login list : $supportLoginList")
        Log.i("ZRouter","get pay list : $supportPayList")
        Log.i("ZRouter","get extend list : $supportExtendList")
        Log.i("ZRouter","get sdk list : $supportSDKList")
    }

    fun initApp(app : Application){
        supportSDKList.forEach {
            it.initApp(app)
        }
    }

    companion object{

        val instance : DemoSDK by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { DemoSDK() }

    }

}