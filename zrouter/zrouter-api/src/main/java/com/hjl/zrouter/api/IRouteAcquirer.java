package com.hjl.zrouter.api;

import com.hjl.zrouter.annotation.RouteMeta;

import java.util.List;

/**
 * author: long
 * description please add a description here
 * Date: 2021/12/22
 */
public interface IRouteAcquirer {

    void loadPlugin(List<RouteMeta> data);

}
