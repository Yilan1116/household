package com.wyl.furns.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class DataUtils {
    public static<T>T copyParamToBean(Map value, T bean){
        try{
            BeanUtils.populate(bean,value);
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }
    public static int parseInt(String val, int defaultVal){
        try{
            return Integer.parseInt(val);
        }catch(NumberFormatException e){
            System.out.println("The format of " + val +" is wrong");
        }
        return defaultVal;
    }
}
