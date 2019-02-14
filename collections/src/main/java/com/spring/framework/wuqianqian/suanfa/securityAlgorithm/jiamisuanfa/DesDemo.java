package com.spring.framework.wuqianqian.suanfa.securityAlgorithm.jiamisuanfa;

/**
 *
 * 对称加密：
 * 加密密钥和解密密钥相同的加密算法。
 *
 * 对称加密算法使用起来简单快捷，密钥较短，且破译困难，除了数据加密标准（DES），
 * 另一个对称密钥加密系统是国际数据加密算法（IDEA），它比DES的加密性好，
 * 而且对计算机功能要求也没有那么高。IDEA加密标准由PGP（Pretty Good Privacy）系统使用。
 *
 * DES:
 * DES全称为Data Encryption Standard，即数据加密标准，是一种使用密钥加密的块算法，现在已经过时。
 *
 * @author liupeqing
 * @date 2019/2/14 16:19
 */

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * DES加密介绍 DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。DES加密算法出自IBM的研究，
 * 后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，
 * 24小时内即可被破解。虽然如此，在某些简单应用中，我们还是可以使用DES加密算法，本文简单讲解DES的JAVA实现 。
 * 注意：DES加密和解密过程中，密钥长度都必须是8的倍数
 */
public class DesDemo {

    //测试
    public static void main(String[] args) {
        // 待加密内容
        String str = "你好啊";
        // 密码，长度要是8的倍数
        String password = "95880288";

        try{
            //字符串加密后，是字节数组形式
            byte[] result = encrypt(str.getBytes(),password);
            System.out.println("加密后：" + result);

            byte[] decryResult = decrypt(result,password);
            System.out.println("解密后：" + new String(decryResult));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加密:就算是同一个明文，每次加密后的值都是不同的，但是解密的时候，解出来的是同一个。
     * @param datasource 需要加密的内容
     * @param password 密钥
     * @return
     */
    public static byte[] encrypt(byte[] datasource, String password){

        try{
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象,ENCRYPT_MODE用于将 Cipher 初始化为加密模式的常量
            cipher.init(Cipher.ENCRYPT_MODE, securekey,random);
            // 现在，获取数据并加密
            // 正式执行加密操作
             byte[] encryResult = cipher.doFinal(datasource); // 按单部分操作加密或解密数据，或者结束一个多部分操作
            return encryResult;

        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     * @param src 加密后的字符串
     * @param password 密钥，和加密的密钥是同一个
     * @return
     */
    public static byte[] decrypt(byte[] src, String password) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
// DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// 返回实现指定转换的
        // Cipher
        // 对象
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
        return cipher.doFinal(src);
    }
}
