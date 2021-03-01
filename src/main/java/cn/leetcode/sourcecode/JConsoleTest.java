package cn.leetcode.sourcecode;

import java.util.ArrayList;

/**
 * @Author xiaoya.wen@raykite.com
 * @Date 2021/01/19  18:43
 **/
public class JConsoleTest {

    public static final Object OBJECT = new Object();


    static class OOMObjext {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        ArrayList<OOMObjext> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObjext());
        }

//        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
//        Thread.sleep(1000);
//        fillHeap(1000);
//        System.gc();
        test();
//        test1();
    }

    public static void test() throws InterruptedException {

//        if (true) {
//            byte[] b = new byte[1024 * 1024 * 6];
//        }

        {
            byte[] b = new byte[1024 * 1024 * 6];
        }

        Thread.sleep(10000);

        System.out.println("准备请求执行垃圾回收");
        System.gc();

        Thread.sleep(10000);
    }

    public static void test1() throws InterruptedException {
        {
            byte[] b = new byte[1024 * 1024 * 6];
        }

        int i = 0;

        Thread.sleep(10000);

        System.out.println("准备请求执行垃圾回收");
        System.gc();

        Thread.sleep(10000);
    }

//    public static void test1() {
//        Instant start = Instant.now();
//
//        OptionalLong result = LongStream.rangeClosed(0L, 50000000000L)
//                .parallel()
//                .reduce(Long::sum);
//
//        Instant end = Instant.now();
//        System.out.println(result.getAsLong());
//
//        System.out.println(Duration.between(start, end).toMillis());
//    }

    public static void test2() {
        Object o = new Object();
    }

    public static void test3() {
        int i = 1;
        switch (i) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
        }
        System.out.println(3);
    }

    private void test4(){
        Object o = new Object();
        if (true){

            Object o1 = new Object();
        }else {
            Integer i = new Integer(2);
            byte b = i.byteValue();
        }
    }

}
