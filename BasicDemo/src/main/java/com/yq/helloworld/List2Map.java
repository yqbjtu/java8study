package com.yq.helloworld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Simple to Introduction
 * className: List2Map
 *
 * @author EricYang
 * @version 2018/7/2 9:38
 */
public class List2Map {

    public static void main(String[]  args) {
        List<CodeName> list = new ArrayList<>();
//        for(int i=0; i < 5; i++) {
//            CodeName codeName = new CodeName();
//            codeName.setId("00" + i);
//            codeName.setName("Tom" + i);
//            list.add(codeName);
//        }
        System.out.println("list" +  list);

        Map<String, CodeName> codeMap = list.stream().collect(Collectors.toMap(CodeName::getId, a -> a,(k1, k2)->k1));

        System.out.println("codeMap" +  codeMap);

        List<Integer> stateList = new ArrayList<>();
        //stateList.add(7);
        //stateList = null;
        Integer sensorStateValue = 6;
        //if (stateList != null && stateList.size() != 0) {
//            sensorStateValue = Collections.max(stateList);
        //}

        System.out.println("sensorStateValue:" +  sensorStateValue);

        Integer state = 0;
        if (state == 1) {
            System.out.println("state is 0" );
        }
        else {
            System.out.println("state is not 0" );
        }

    }
}
