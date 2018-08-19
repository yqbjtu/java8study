package com.yq.helloworld;

import com.yq.annotationDemo.ClassA;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple to Introduction
 * className: MainDemo
 *
 * @author EricYang
 * @version 2018/6/6 9:30
 */
public class MainDemo {

    public static void main(String[] args) {
        //byte[] bytes = new byte[] { 7B,226E616D65223A22C4E3BAC331227D };
//        try {
//            String str = new String(bytes,"UTF-8");
//            System.out.println("str2:" + str );
//        }
//        catch (Exception ex) {
//
//        }
//        List<String> existingMonitorPointList = null;
//        List<String> b = Collections.unmodifiableList(existingMonitorPointList);
//        System.out.println("b:" + b );

//        Map<String, Object> msgMap = new HashMap<>();
//        Map<String, Object> dataMap = (Map<String, Object>) msgMap.get("data");
//        System.out.println("dataMap:" + dataMap );


//dataMap        msg={"deviceid":"9477414361974210afb3038115e509a6","id":123456,"msg":{"data":{"L001":80,"L002":"aaa","humidity":50,
//                "temperature":{"part1_temperature":36.7,"part2_temperature":37.5}},"delta":1}
//                ,"sendTime":"2018-05-02T15:18:50.632","topic":"iiot.prod1","ts":"1528368237766"},
//        oneMinuteBefore=1528368633231, diff=-395465
        long ts = 1528368237766L;
        long one = 1528368633231L;
        Date tsDate = new Date(ts); // 根据long类型的毫秒数生命一个date类型的时间
        Date oneDate = new Date(one);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

        String tsDateStr = formatter.format(tsDate); // Date把date类型的时间转换为string
        System.out.println("tsDate:" + tsDateStr );

        String oneDateStr = formatter.format(oneDate);
        System.out.println("oneDateStr:" + oneDateStr );

        Map<String, Object> map = new HashMap<>();
        map.put("ts", 1528695675030L);

        Long longObj = (Long)map.get("ts");
        Date objDate = new Date(longObj.longValue());
        System.out.println("objDate:" + objDate);


//        List<String> modelIdList = new ArrayList<>();
//        modelIdList.add("model01");
//        modelIdList.add("model02");
//
//        String[] array = new String[modelIdList.size()];
//        String[] array2 = modelIdList.toArray(array);
//        System.out.println("array:" + Arrays.toString(array) + ", obj:" + array);
//        System.out.println("array2:" + Arrays.toString(array2) + ", obj:" + array2);

        try {
            String str= "nihao";
            byte[] bytes = str.getBytes("utf-8");

            System.out.println("str:" + str + ", bytes:" + Arrays.toString(bytes));
            String str1 = "中nihao中";
            bytes = str1.getBytes("GBK");
            System.out.println("str1:" + str1 + ", bytes:" + Arrays.toString(bytes));
        }
        catch (Exception ex){

        }

    }

}
