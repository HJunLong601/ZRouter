package com.hjl.zrouter.api;

import android.content.Context;
import android.util.Log;

import com.hjl.zrouter.BuildConfig;
import com.hjl.zrouter.annotation.RouteMeta;
import com.hjl.zrouter.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * author: long
 * description please add a description here
 * Date: 2021/12/22
 */
public class ZRouter {

    public static String TAG = "ZRouter";
    private static boolean isDebug = BuildConfig.DEBUG;

    private Context mContext;
    private static ZRouter sInstance;



    private List<RouteMeta> routeMetaList = new ArrayList<>();

    public static synchronized ZRouter getInstance() {
        if (sInstance == null) {
            sInstance = new ZRouter();
        }

        return sInstance;
    }

    public void init(Context context){

        mContext = context;
        Log.i(TAG, "start init");
        routeMetaList.clear();
        loadRouterMap();
        if (isLoadByPlugin){
            Log.i(TAG, "load route meta from plugin");
        }else {
            try {
                // todo 耗时操作 可用ASM插件解决
                Set<String> clsNameSet = ClassUtils.getFileNameByPackageName(context, "com.hjl.zrouter.routes");
                parseCls(clsNameSet);
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(TAG,"load route meta error :",e);
            }
        }
    }


    private boolean isLoadByPlugin = false;

    private static void loadRouterMap(){
        // TODO : ASM 代码插入
    }

    public static boolean debuggable(){
        return isDebug;
    }

    private void parseCls(Set<String> data) throws Exception {
        for (String cls : data){
            ((IRouteAcquirer)Class.forName(cls).getConstructor().newInstance()).loadPlugin(routeMetaList);
        }
    }

    public List<RouteMeta> getRouteMetaList() {
        return routeMetaList;
    }

}
