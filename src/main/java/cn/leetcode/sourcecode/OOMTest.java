package cn.leetcode.sourcecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xiaoya.wen@raykite.com
 * @Date 2021/02/20  11:17
 **/
public class OOMTest {

    public static void main(String[] args) {

//        List<Object> list = new ArrayList<>();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 2000; i++) {
//
//                    list.add(new byte[1024 * 1024 * 2]);
//                }
//            }
//        }).start();
//
//        while (true) {
//        }

        byte[] bytes = new byte[1024 * 1024 * 3];
        while (true) {

        }
    }
}
