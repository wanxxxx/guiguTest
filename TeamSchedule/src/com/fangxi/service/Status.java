package com.fangxi.service;


public class Status {
    private final String NAME;

    public Status(String name) {
        NAME = name;
    }
    public static final Status FREE=new Status("FREE");
    public static final Status BUSY=new Status("VOCATION");
    public static final Status VOCATION=new Status("VOCATION");

    @Override
    public String toString() {
        return NAME;
    }
}
