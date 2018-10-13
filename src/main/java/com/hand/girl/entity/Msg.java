package com.hand.girl.entity;

import lombok.Data;
import org.apache.tomcat.jni.Mmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
public class Msg<T> {

    private static final int SUCCESS =1;
    private static final int ERROR = 0;
    private static final String msg = "成功";
    private static final String fail = "null";

    private Integer code;
    private String status;
    private T data;

    public Msg(T data){
        this.code = SUCCESS;
        this.status = msg;
        this.data = data;
    }
    public Msg(Integer code,String msg){
        this.code = code;
        this.status = msg;
    }

    /*private Map map = new HashMap();

    public static Msg success(){
        Msg msg = new Msg();
        msg.setCode(1);
        msg.setStatus("成功");
        return msg;
    }
    public static Msg fail(){
        Msg msg = new Msg();
        msg.setCode(0);
        msg.setStatus("不成功");
        return msg;
    }
    public Msg map(String a,Object o){
        this.getMap().put(a,o);
        return this;
    }*/
}
