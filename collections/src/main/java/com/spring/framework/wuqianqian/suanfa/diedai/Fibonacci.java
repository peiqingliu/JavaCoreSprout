package com.spring.framework.wuqianqian.suanfa.diedai;

/**
 * @author liupeqing
 * @date 2019/2/14 15:38
 */
public class Fibonacci {

    //现在要求输入一个整数n，请你输出斐波那契数列的第n项。 n<=39
    //迭代方法

    public static int fibonacci(int number){
        if (number < 0) return 0;
        if (number == 1 || number == 2)return 1;
        int f = 1,s = 1,t =2;
        for (int i=3;i<=number;i++){
            //第三项为前两项之和
            t = f+s;
            //第二项给第一项
            f=s;
            //第三项给第二项
            s=t;
        }
        return t;
    }

    //递归
    public static int fibonacci2(int n) {

        if (n <= 0) {
            return 0;
        }
        if (n == 1||n==2) {
            return 1;
        }

        return fibonacci2(n - 2) + fibonacci2(n - 1);

    }

    //一般来说，迭代方法速度更快
    public static void main(String[] args) {
        int res = fibonacci(5);
        System.out.println(res);
        int res2 = fibonacci2(5);
        System.out.println(res2);
    }
}
