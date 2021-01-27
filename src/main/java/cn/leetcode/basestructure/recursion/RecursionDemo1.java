package cn.leetcode.basestructure.recursion;

import org.junit.Test;

/**
 * 电影几排
 * dsc: RecursionDemo1
 * date: 2021/1/27 17:30
 * author: zyc
 */
public class RecursionDemo1 {
    /**
     * 分析过程
     *
     *  当前位置（f(n)） 1
     *
     *  往前询问  f(n-1) + 1   f(n) = f(n-1)+1
     *
     *  非递归f(n+1) = f(n)+1
     *
     *  当位置为 1 时为第一排
     *
     *  注意:一定不要用人脑去分析他的执行过程
     */
    public int  ask(int n){
        if(n == 1){return 1;}

        return ask(n-1)+1;
    }

    public int ask1(int n){
        int ret = 1;
        for (int i = 2 ; i <= n;i++){
            ret = ret +1;
        }
        return ret;
    }





    @Test
    public void call(){
        System.out.println(ask(5));
        System.out.println(ask1(5));
    }



}
