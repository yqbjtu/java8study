package com.yq.helloworld.StringRuleContent;

import lombok.Data;

import java.io.Serializable;

/**
 * Simple to Introduction
 * className: AlarmMsg
 *
 * @author EricYang
 * @version 2019/6/1 21:26
 */
@Data
public class AlarmMsg implements Serializable {
    private static final long serialVersionUID = -1L;

    private String id;
    private String title;
    private String content;
}
