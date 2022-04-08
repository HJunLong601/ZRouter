package com.hjl.zrouter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author: long
 * description please add a description here
 * Date: 2021/12/21
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Route {

    String path();

    int priority() default -1;

    int extras() default Integer.MIN_VALUE;

}
