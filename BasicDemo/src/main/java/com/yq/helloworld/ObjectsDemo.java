package com.yq.helloworld;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Simple to Introduction
 * className: ObjectsDemo
 *
 * @author EricYang
 * @version 2018/8/18 23:22
 */
public class ObjectsDemo {
    public static void main(String[] args) {
        String str1 = "str";
        System.out.println("str1 is null? " + Objects.isNull(str1));

        List<String> list = Arrays.asList("a", "b", null, null);
        List<String> list2 = list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        System.out.println(list2);
    }
}
