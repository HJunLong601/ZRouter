package com.hjl.test_module_java;


import com.hjl.commonlib.base.IChannelAdapter;
import com.hjl.commonlib.base.IExtentAdapter;
import com.hjl.commonlib.base.ILoginAdapter;
import com.hjl.commonlib.base.IPayAdapter;
import com.hjl.commonlib.base.ISDKAdapter;
import com.hjl.zrouter.annotation.Route;

/**
 * author: long
 * description please add a description here
 * Date: 2021/12/21
 */

@Route(path = "/test/java")
public class TestJavaChannelAdapter implements IChannelAdapter {
    @Override
    public IExtentAdapter getExtentAdapter() {
        return TestExtentAdapter.getInstance();
    }

    @Override
    public ISDKAdapter getSDKAdapter() {
        return TestSDKAdapter.getInstance();
    }

    @Override
    public IPayAdapter getPayAdapter() {
        return TestPayAdapter.getInstance();
    }

    @Override
    public ILoginAdapter getLoginAdapter() {
        return TestLoginAdapter.getInstance();
    }
}
