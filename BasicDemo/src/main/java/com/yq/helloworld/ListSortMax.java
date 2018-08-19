package com.yq.helloworld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Simple to Introduction
 * className: ListSortMax
 *
 * @author EricYang
 * @version 2018/6/26 10:43
 */
public class ListSortMax {

    public static void main(String[] args) {
        List<Integer> stateList = new ArrayList<>();
        stateList.add(4);
        stateList.add(7);
        stateList.add(2);
        stateList.add(0);
        Integer max = Collections.max(stateList);
        System.out.println("arrayList is " + stateList);
        System.out.println("max value in arrayList is " + max);

        int a = 320;
        int b = (a - 0) & 128;
        System.out.println("b is " + b);
    }

}
