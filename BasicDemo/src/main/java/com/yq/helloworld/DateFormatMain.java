package com.yq.helloworld;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Simple to Introduction
 * className: DateFormatMain
 *
 * @author EricYang
 * @version 2018/6/23 16:01
 */
public class DateFormatMain {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date now = new Date();
        String nowStr = sdf.format(now);
        System.out.println("nowStr:" + nowStr);

        long nowLong = System.currentTimeMillis();
        System.out.println("nowLong:" + nowLong);
    }

}
