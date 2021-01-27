package cn.leetcode.basestructure.recursion;

import org.junit.Test;

/**
 * 走台阶
 * dsc: RecursionDemo1
 * date: 2021/1/27 17:30
 * author: zyc
 */
public class RecursionDemo2 {
    /**
     *
     * 题目
     *
     * 假如这里有 n 个台阶，每次你可以跨 1 个台阶或者 2 个台阶，
     * 请问走这 n 个台阶有多少种走法？如果有 7 个台阶，
     * 你可以 2，2，2，1 这样子上去，也可以 1，2，1，1，2 这样子上去，
     * 总之走法有很多，那如何用编程求得总共有多少种走法呢？
     *
     * 分析解题思路：
     *  两种情况
     *  递
     *      台阶数 f(n)
     *      子式
     *      1 先走一个台阶  f(n-1)
     *      2 先走两个台阶  f(n-2)
     *
     *      f(n) = f(n-1)+f(n-2)
     *
     *  归
     *       最后一个台阶一步走完
     *    f(1) = 1;
     *     最后两个台阶一步走完 或者 一步一步走
     *    f(2) =2 ;
     * 白话 一次只能走 1步 或者两步，后面的n就会对应少1 或者2
     *     然后每一次都会有两种情况
     * 弊端
     *  1 耗时
     *  2 栈溢出
     */
    public int  count(int n){
        if(n == 1){return 1;}
        if(n == 2){return 2;}

        return  count(n-1)+count(n-2);
    }


    public int count1(int n){
        if (n == 1) return 1;
        if (n == 2) return 2;
        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; ++i) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        } return ret;
    }

    @Test
    public void call(){
        System.out.println(count1(7));//非递归 这里比递归快多啦
        System.out.println(count(7));//递归随着n的增大将会很耗时 当这里为40//165580141种情况
    }

}
