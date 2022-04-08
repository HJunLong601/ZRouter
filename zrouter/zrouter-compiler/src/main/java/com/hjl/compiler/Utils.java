package com.hjl.compiler;

import com.hjl.zrouter.annotation.RouteMeta;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;

import java.util.List;

import static com.hjl.compiler.Constant.*;
import static javax.lang.model.element.Modifier.PUBLIC;

/**
 * author: long
 * description please add a description here
 * Date: 2021/12/22
 */
public class Utils {

    static final ClassName ROUTER_ACQUIRER = ClassName.get("com.hjl.zrouter_api","IRouteAcquirer");

    static ParameterizedTypeName inputMapType = ParameterizedTypeName.get(
            ClassName.get(List.class),
            ClassName.get(RouteMeta.class)
    );

    public static MethodSpec.Builder getLoadPluginMethodBuilder(){
        return MethodSpec.methodBuilder(METHOD_LOAD_PLUGIN)
                .addAnnotation(Override.class)
                .addModifiers(PUBLIC)
                .addParameter(inputMapType,"data");
    }

}
