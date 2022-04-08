package com.hjl.commonlib.base

import android.app.Activity
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


/**
 * Description Activity 基类
 * Date 2020/3/2 16:24
 * created by long
 */
abstract class BaseActivity<VDB : ViewDataBinding> : AppCompatActivity() {

    protected val TAG: String = this.javaClass.simpleName

    protected lateinit var binding : VDB

    lateinit var mContext: Activity

    abstract fun initData()

    abstract fun initView()

    abstract fun initLoad()

    abstract fun getLayoutId() : Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,getLayoutId())
        binding.lifecycleOwner = this
        mContext = this

        initData()
        initView()
        initLoad()


    }


    /**
     * 是否改变状态栏文字颜色为黑色，默认为黑色
     */
    protected open fun isUseBlackFontWithStatusBar(): Boolean {
        return true
    }

    /**
     * 是否设置成透明状态栏，即就是全屏模式
     */
    protected open fun isUseFullScreenMode(): Boolean {
        return false
    }



}