package com.hjl.zrouterdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.hjl.commonlib.DemoSDK
import com.hjl.commonlib.base.ICommonCallback
import com.hjl.zrouter.api.ZRouter
import com.hjl.zrouterdemo.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.tvChannelCount.text = "获取到渠道（路由）个数:${ZRouter.getInstance().routeMetaList.size}"

        binding.btnJavaLogin.setOnClickListener {
            DemoSDK.instance.supportChannelList.forEach {
                if (it.key.contains("java")){
                    it.value.getLoginAdapter()?.login(this, JSONObject(),object : ICommonCallback{
                        override fun onFinished(code: Int, msg: String, ext: Any?) {
                            Toast.makeText(this@MainActivity,"java login result msg :$msg",Toast.LENGTH_SHORT).show()
                        }
                    })
                }
            }
        }

        binding.btnKotlinLogin.setOnClickListener {
            DemoSDK.instance.supportChannelList.forEach {
                if (it.key.contains("kotlin")){
                    it.value.getLoginAdapter()?.login(this, JSONObject(),object : ICommonCallback{
                        override fun onFinished(code: Int, msg: String, ext: Any?) {
                            Toast.makeText(this@MainActivity,"kotlin login result msg :$msg",Toast.LENGTH_SHORT).show()
                        }
                    })
                }
            }
        }
    }
}