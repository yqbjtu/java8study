
package com.yq.annotationDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Simple to Introduction
 * className: MyAnnotation
 *
 * @author EricYang
 * @version 2018/5/13 23:16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.METHOD, ElementType.TYPE })
public @interface MyAnnotation {
    /**
     * 定义基本属性
     * @return
     */
    String nodeName();
}
