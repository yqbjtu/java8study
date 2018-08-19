package com.yq.helloworld;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple to Introduction
 * className: StringDemo
 *
 * @author EricYang
 * @version 2018/7/3 10:18
 */
public class StringDemo {

    public static void main(String[] args) {
        String urlHeader= "key1, key2:, ke11y3:value3";
        String[] headers = urlHeader.split(",");
        for (String str : headers) {
            int index = str.indexOf(":");
            if (index == -1) {
                continue;
            }
            System.out.println("index:" + index );
            String name = str.substring(0, index);
            String value = str.substring(index+1);
            System.out.println("name:" + name + ", value:" + value);
        }

        List<String> monitorPointVOListD = new ArrayList<>();
        List<String> monitorPointVOListM = null;
        monitorPointVOListD.addAll(monitorPointVOListM);
    }

}
