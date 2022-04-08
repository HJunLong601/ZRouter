package com.hjl.commonlib.base

import android.app.Application
import android.content.Context
import org.json.JSONObject

/**
 * author: long
 * description 注意 此处接口定义为了方便写为kt，实际为了兼容kt与java 互调的情况 可以使用java文件定义接口
 * 并在实现类提供 set函数，即可实现kotlin调用java 监听器等使用kotlin闭包
 * Date: 2021/12/9
 */




interface ICommonCallback {
    fun onFinished(code: Int, msg: String = "", ext: Any? = null)
}

interface ILoginAdapter {
    fun login(context: Context, loginInfo: JSONObject, callback: ICommonCallback)

    fun logout(context: Context?, callback: ICommonCallback)
}

interface IPayAdapter {
    fun performPay(
        context: Context?,
        sdkPayInfo: JSONObject,
        callback: ICommonCallback?
    )
}

interface ISDKAdapter{
    fun exit(context: Context?, shouldKillGameProcess: Boolean): Boolean {
        return false
    }


    fun init(context: Context?, sdkInitInfo: JSONObject?, callback: ICommonCallback?)

    fun initApp(app : Application)
}

interface IExtentAdapter{

    fun doActionSync(context: Context?, actionId: Int):String?

    fun doAction(context: Context?, actionId: Int){
        doAction(context, actionId,null)
    }

    fun doAction(context: Context?, actionId: Int, vararg objArr: Any?){
        doAction(context, actionId,null, objArr)
    }

    fun doAction(
        context: Context?,
        actionId: Int,
        callback: ICommonCallback?,
        vararg objArr: Any?
    ){

    }

    fun getSupportActions(): Array<Int>
}

interface IChannelAdapter{

    fun getExtentAdapter(): IExtentAdapter? {
        return null
    }

    fun getSDKAdapter() : ISDKAdapter

    fun getPayAdapter(): IPayAdapter? {
        return null
    }

    fun getLoginAdapter(): ILoginAdapter? {
        return null
    }


}

