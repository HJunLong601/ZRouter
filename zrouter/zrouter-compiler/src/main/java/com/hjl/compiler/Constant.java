package com.hjl.compiler;

import com.hjl.zrouter.annotation.RouteMeta;
import com.squareup.javapoet.ClassName;

/**
 * author: long
 * description please add a description here
 * Date: 2021/12/22
 */
interface Constant {
    String KEY_MODULE_NAME = "ZROUTER_MODULE_NAME";
    String PREFIX_CLASS_NAME = "ZRouter$$";
    String METHOD_LOAD_PLUGIN = "loadPlugin";
    String PACKAGE_OF_GENERATE_FILE = "com.hjl.zrouter.routes";
    String FILE_TIP = "This file generate by ZRouter, Do not modify";

    ClassName CLS_ROUTER_ACQUIRER = ClassName.get("com.hjl.zrouter.api","IRouteAcquirer");
    ClassName CLS_ROUTE_META = ClassName.get(RouteMeta.class);


}
