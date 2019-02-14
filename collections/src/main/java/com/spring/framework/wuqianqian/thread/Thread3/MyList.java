package com.spring.framework.wuqianqian.thread.Thread3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupeqing
 * @date 2019/1/15 20:40
 */
public class MyList {
    private static List<String> list = new ArrayList<String>();

    public static void add() {
        list.add("anyString");
    }

    public static int size() {
        return list.size();
    }

}
