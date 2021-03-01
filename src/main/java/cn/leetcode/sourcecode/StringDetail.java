package cn.leetcode.sourcecode;

import java.util.Map;

/**
 * @Author xiaoya.wen@raykite.com
 * @Date 2021/01/05  14:55
 **/
public class StringDetail {

    public static void test() {
        // 1.new了几个对象?
        String str = "A" + "B" + "C"; // 0个 因为"A" "B" "C"都是常量 和"ABC"无异 编译期就认为是"ABC" 编译期优化
        // 1 10 11 12 13
    }

    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1) {
                    System.out.println("线程1锁o1");
                    try {
                        Thread.sleep(1000);
                        synchronized (o2) {
                            System.out.println("线程1锁o2");

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (o2) {
                System.out.println("线程2锁o2");
                synchronized (o1) {
                    System.out.println("线程2锁o1");
                }
            }
        }).start();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        allStackTraces.forEach((key,value) -> {
            System.out.println(key);
            for (StackTraceElement stack : value){

                System.out.println(stack);
            }
            System.out.println();
        });
//        new Thread(() -> {
//            for (; ; ) {
//
//            }
//        }).start();
//        while (true) {
//        /**
//         * -Xms                         堆初始大小
//         * -Xmx                         堆内存最大值
//         * -Xmn                         新生区大小
//         * -Xss                         栈大小
//         * -XX:SurvivorRatio            设置新生代中Eden区域与Survivor区域的容量比值，默认为8，代表Eden:Survivor=8:1
//         * -MetaspaceSize               元空间初始内存大小
//         * -MaxMetaspaceSize            元空间最大内存大小，默认-1，无限制，或者说只受限于本地内存大小
//         * -XX:+UseTLAB                 开启本地线程分配缓冲  默认开启
//         * -XX:+HeapDumpOnOutOfMemory   在虚拟机出现内存溢出时Dump出当前堆内存转储快照
//         * -XX:+PrintCommandLineFlags   查看命令行相关参数，包含使用的垃圾收集器
//         * -XX:+UseParallelGC           使用Parallel Scavenge收集器进行垃圾回收（吞吐量优先） JDK8中默认垃圾收集器 当他开启时Parallel Old默认开启
//         * -XX:ParallelGCThreads        用于限制垃圾收集的线程数，默认开启，和CPU个数相等
//         * -XX:MaxGCPauseMillis         用于控制最大垃圾收集停顿时间
//         * -XX:GCTimeRatio              用于设置吞吐量大小
//         *
//         */
//
//
//        }
    }

}
