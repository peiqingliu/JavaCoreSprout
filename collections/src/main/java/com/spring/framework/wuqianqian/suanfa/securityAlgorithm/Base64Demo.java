package com.spring.framework.wuqianqian.suanfa.securityAlgorithm;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Base64算法
 * 应用
 * - 电子邮件传输：可以进行简单"加密"且防乱码
 *  - 网络数据传输：不论是通过`HTTP`的`GET`方式以URL参数传递参数，还是通过`POST`方式以数据体传输数据，都能发现Base64编码藏匿其中
 *  - 密钥存储：将密钥从二进制表现形式转换成Base64，这样可读性变得更高
 *  - 数字证书存储：很多数字证书以Base64方式存储和传输
 * @author liupeqing
 * @date 2019/2/14 17:17
 */
public class Base64Demo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "朝如青丝暮成雪+高堂明镜悲白发";
        System.out.println("遵循RFC2048：没72的字符会换行"+ new String(Base64.encodeBase64(s.getBytes("UTF-8"),true)));
        System.out.println("=================================================================================");
        String encryBase64 = Base64.encodeBase64String(s.getBytes("UTF-8"));
        System.out.println("base64加密："+encryBase64);
        String inputData = encryBase64;
        String dec = new String(Base64.decodeBase64(inputData.getBytes("utf-8")), "utf-8");
        System.out.println("base64解密："+dec);

    }
}
