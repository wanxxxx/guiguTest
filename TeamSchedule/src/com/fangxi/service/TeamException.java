package com.fangxi.service;

/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-06 21:18
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -33875169145645948L;
    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
