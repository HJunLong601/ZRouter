package com.hjl.zrouter.annotation;

import androidx.annotation.NonNull;

/**
 * author: long
 * description please add a description here
 * Date: 2021/12/22
 */
public class RouteMeta {

    private Class<?> destination;   // Destination
    private String path;            // Path of route
    private String group;           // Group of route
    private int priority = -1;      // The smaller the number, the higher the priority
    private int extra;

    public RouteMeta() {
    }

    public RouteMeta(Class<?> destination, String path, String group, int priority, int extra) {
        this.destination = destination;
        this.path = path;
        this.group = group;
        this.priority = priority;
        this.extra = extra;
    }

    public Class<?> getDestination() {
        return destination;
    }

    public void setDestination(Class<?> destination) {
        this.destination = destination;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getExtra() {
        return extra;
    }

    public void setExtra(int extra) {
        this.extra = extra;
    }

    @NonNull
    @Override
    public String toString() {
        return "RouteMeta{" +
                ", destination=" + destination +
                ", path='" + path + '\'' +
                ", group='" + group + '\'' +
                ", priority=" + priority +
                ", extra=" + extra +
                '}';
    }
}
