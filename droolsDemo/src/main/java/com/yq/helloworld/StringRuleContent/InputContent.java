package com.yq.helloworld.StringRuleContent;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderErrors;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 **/

@Slf4j
public class InputContent {

    private KnowledgeBase knowledgeBase;

    public InputContent() {
    }

    public KnowledgeBuilderErrors loadRule(String ruleFullContent) {
        this.knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        if (StringUtils.isEmpty(ruleFullContent)){
            log.debug("ruleContent is empty!");
            return null;
        }

        try {
            kbuilder.add(ResourceFactory.newByteArrayResource(ruleFullContent.getBytes("utf-8")), ResourceType.DRL);

            if (kbuilder.hasErrors()) {
                KnowledgeBuilderErrors errors = kbuilder.getErrors();
                return errors;
            }
        }  catch (UnsupportedEncodingException ex) {
            log.error("Found exception when converting rule to byte", ex);
        } catch (Exception e) {
            log.error("Found exception ", e);
            throw e;
        }

        Collection<KnowledgePackage> pkgs = kbuilder.getKnowledgePackages();
        this.knowledgeBase.addKnowledgePackages( pkgs );

        return null;
    }

    public void triggerRule(Object fact, List<String> list){
        if(fact==null) {
            log.debug("facts is empty!");
            return;
        }
        log.debug( "Inserting fact={}" , fact );

        StatefulKnowledgeSession statefulKSession = this.knowledgeBase.newStatefulKnowledgeSession();
        statefulKSession.setGlobal("list", list);

        Object obj = statefulKSession.getGlobal("list");
        statefulKSession.insert(fact);
        statefulKSession.fireAllRules();
        statefulKSession.getEntryPoints().clear();
        statefulKSession.dispose();
    }

    public static final void main(final String[] args) {
        String str = "package org.drools.demo;\n" +
                "import java.util.HashMap;\n" +
                "import java.util.Date;\n" +
                "import java.util.Map;\n" +
                "import java.util.HashMap;\n" +
                "import java.util.List;\n" +
                "dialect  \"mvel\"\n" +
                "global java.util.List list\n" +
                "rule  \"917f802ca94847abbd3d4c63569d48d5\" salience 3\n" +
                "when\n" +
                " $map: Map( $msg:( (this[\"name\"] /3 ) == 3)==true )\n" +
                "then \n" +
                "list.add(\"str11\");\n" +
                "end \n\n" +


                "rule  \"01a3fe25a6264ad6bd7b660521827be1\" salience 2\n" +
                 "when \n" +
                  " $map: Map( $msg:(this[\"M0002\"]>50 && this[\"M0002\"]<70 && this[\"M0005\"] >55 && this[\"M0005\"]<=80)==true )\n" +
                   " then " +
                 "list.add(\"str3\");\n" +
                "end";

        InputContent demo = new InputContent();
        try {
            KnowledgeBuilderErrors errors = demo.loadRule(str.toString());
            if (errors != null) {
               System.out.println("规则内容与规则语法不符合" + errors.toString() + ", str:" + str);
                return ;
            }
        } catch (Exception ex) {
            log.error("exception, ex={}", ex);
            System.out.println("加载规则内容出现异常");
            return ;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("name", 6);
        //map.put("M0002", 65);
        //map.put("M0005", 61);
        List<String> list = new ArrayList<>();
        System.out.println("初始size：" + list.size() + "个告警" );
        try {
            demo.triggerRule(map, list);
        } catch (Exception ex) {
            System.out.println("执行规则出现异常" + ex.getMessage());
            return ;
        }

        if (list == null || list.size() == 0) {
            System.out.println("规则执行正常，没有告警产生");
        }
        else {
            System.out.println("规则执行正常，产生" + list + "个告警" );
        }

        list.clear();
        try {
            demo.triggerRule(map, list);
        } catch (Exception ex) {
            System.out.println("执行规则出现异常2" + ex.getMessage());
            return ;
        }

        if (list == null || list.size() == 0) {
            System.out.println("规则执行正常2，没有告警产生");
            return;
        }
        else {
            System.out.println("规则执行正常2，产生" + list.size() + "个告警" );
            return;
        }
    }
}
