package com.yq.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Simple to Introduction
 * className: ConcurrentHashMapDemo
 *
 * @author EricYang
 * @version 2018/6/28 15:08
 */

public class ConcurrentHashMapDemo {
    private static final Logger logger = LoggerFactory.getLogger(ConcurrentHashMapDemo.class);
    public static void main(String[] args) {
        try {
            Map<String, String> map = new ConcurrentHashMap<>();
            String value = map.get(null);
        }
        catch (Exception ex) {
            logger.info("map ex", ex);
        }

    }

}
