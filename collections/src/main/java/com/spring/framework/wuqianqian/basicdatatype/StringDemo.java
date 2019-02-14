package com.spring.framework.wuqianqian.basicdatatype;

/**
 * 将字符串转城byte[]
 * @author liupeqing
 * @date 2019/2/14 16:55
 */
public class StringDemo {

    public static void main(String[] args) {
        String string = "你好啊";
        //Convert to byte[]
        byte[] bytes = string.getBytes();
        System.out.println("byte[] : " + bytes);
        //Convert back to String
        String s = new String(bytes);


        //Check converted string against original String
        System.out.println("Decoded String : " + s);
    }
}
