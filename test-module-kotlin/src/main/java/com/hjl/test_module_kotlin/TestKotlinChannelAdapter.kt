package com.hjl.test_module_kotlin


import com.hjl.commonlib.base.IChannelAdapter
import com.hjl.commonlib.base.ILoginAdapter
import com.hjl.commonlib.base.ISDKAdapter
import com.hjl.zrouter.annotation.Route

/**
 * author: long
 * description please add a description here
 * Date: 2021/12/21
 */
@Route(path = "/test/kotlin")
class TestKotlinChannelAdapter : IChannelAdapter {
    override fun getSDKAdapter(): ISDKAdapter {
        return TestSDKAdapter.instance
    }

    override fun getLoginAdapter(): ILoginAdapter {
        return TestLoginAdapter.instance
    }
}