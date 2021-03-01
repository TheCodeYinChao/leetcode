package cn.leetcode.sourcecode;

import java.util.Map;
import java.util.Set;

/**
 * @Author xiaoya.wen@raykite.com
 * @Date 2021/01/20  11:09
 **/
public class DeadlockDemo implements Runnable {
    int a, b;
    public DeadlockDemo(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        /**
         * 这里造成死锁的根本原因是Integer.valueOf()方法出于减少对象创建次数和节省内存的考虑，
         * 会对数值-18~127之间的Integer对象进行缓存，如果valueOf()方法传入的参数在这个范围之内，就直接
         * 返回缓存中的对象。也就是说代码中尽管调用了200次Integer.valueOf()方法，但一共只返回了两个不同的Integer对象。
         * 假如某个线程的两个synchronized块之间发生了一次线程切换，那就会出现线程A在等待线程B持有的Integer.valueOf(1)，
         * 线程B又在等待被线程A持有的Integer.valueOf(2)，结果大家都跑不下去的情况。
         */
        synchronized (Integer.valueOf(a)) {
            synchronized (Integer.valueOf(b)) {
                System.out.println(a + b);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(new DeadlockDemo(1, 2)).start();
            new Thread(new DeadlockDemo(2, 1)).start();
        }

        Thread.sleep(1000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<Thread, StackTraceElement[]> all = Thread.getAllStackTraces();
                Set<Map.Entry<Thread, StackTraceElement[]>> entries = all.entrySet();
                for (Map.Entry<Thread, StackTraceElement[]> en : entries) {
                    Thread t = en.getKey();
                    StackTraceElement[] v = en.getValue();
                    System.out.println("【Thread name is ：" + t.getName() + "】");
                    for (StackTraceElement s : v) {
                        System.out.println("\t" + s.toString());
                    }
                }
            }
        }).start();
    }
}
