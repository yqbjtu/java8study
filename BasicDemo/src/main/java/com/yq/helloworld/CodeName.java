package com.yq.helloworld;

import lombok.Data;

/**
 * Simple to Introduction
 * className: CodeName
 *
 * @author EricYang
 * @version 2018/7/2 9:38
 */

public class CodeName {
    String id;
    String name;
    String code;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
