


package com.yq.annotationDemo;

/**
 * Simple to Introduction
 * className: MyAnnotationTest
 *
 * @author EricYang
 * @version 2018/5/13 23:17
 */


public class MyAnnotationTest {
    public static void main(String[] args) {

        ClassA aObj = new ClassA();
        ClassB bObj = new ClassB();

        //当我们在某种业务冲存储ClassA和ClassB，我们需要根据nodeName决定春初在哪个数据库或者文件中
        Class<?> cls = aObj.getClass();

        MyAnnotation annotation = (MyAnnotation) cls.getAnnotation(MyAnnotation.class);
        System.out.println("aObj should be saved into " + annotation.nodeName());

        cls = bObj.getClass();
        annotation = (MyAnnotation) cls.getAnnotation(MyAnnotation.class);
        System.out.println("bObj should be saved into " + annotation.nodeName());
    }
}