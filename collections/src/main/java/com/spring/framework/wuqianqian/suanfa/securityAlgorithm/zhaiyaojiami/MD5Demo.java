package com.spring.framework.wuqianqian.suanfa.securityAlgorithm.zhaiyaojiami;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 不可逆
 * MD5的作用是让大容量信息在用数字签名软件签署私人密钥前被"压缩"成一种保密的格式 （也就是把一个任意长度的字节串变换成一定长的十六进制数字串）。
 *
 * 特点：
 * 压缩性： 任意长度的数据，算出的MD5值长度都是固定的。
 * 容易计算： 从原数据计算出MD5值很容易。
 * 抗修改性： 对原数据进行任何改动，哪怕只修改1个字节，所得到的MD5值都有很大区别。
 * 强抗碰撞： 已知原数据和其MD5值，想找到一个具有相同MD5值的数据（即伪造数据）是非常困难的。
 *
 * @author liupeqing
 * @date 2019/2/14 15:55
 */
public class MD5Demo {

    public static void main(String[] args) {
        String r1 = getMD5Code("hello");
       System.out.println(r1);
        String r2=  MD5("hello");
        System.out.println(r2);

    }

    /**
     * 第一种实现方法
     * @param message
     * @return
     */
    //利用JDK提供java.security.MessageDigest类实现MD5算法：
    public static String getMD5Code(String message){
        String md5Str = "";
        try {
            //创建MD5算法消息摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            //生成的哈希值的字节数组
            byte[] md5Bytes = md.digest(message.getBytes());
            md5Str = bytes2Hex(md5Bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5Str;
    }

    // 2进制转16进制
    private static String bytes2Hex(byte[] bytes){
        StringBuffer result  = new StringBuffer();
        int temp;
        try{
            for (int i=0;i<bytes.length;i++){
                temp = bytes[i];
                if (temp < 0){
                    temp += 256;
                }
                if (temp < 16) {
                    result.append("0");
                }
                result.append(Integer.toHexString(temp));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return result.toString();

    }

    /**
     * 第二种实现方法
     * @param md5Array
     * @return
     */

    // 通过java提供的BigInteger 完成byte->HexString
    private static String bytesToHex(byte[] md5Array) {
        BigInteger bigInt = new BigInteger(1, md5Array);
        return bigInt.toString(16);
    }

    public static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try {
            byte[] btInput = s.getBytes("UTF-8");
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
