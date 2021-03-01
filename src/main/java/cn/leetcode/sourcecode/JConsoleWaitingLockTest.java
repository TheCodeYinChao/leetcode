package cn.leetcode.sourcecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author xiaoya.wen@raykite.com
 * @Date 2021/01/20  10:25
 **/
public class JConsoleWaitingLockTest {

    public static void createBusyThread() {
        new Thread(() -> {
            while (true) {

            }
        }, "testBusyThread").start();
    }

    public static void createLockThread(final Object lock) {
        new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "testLockThread").start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        Object o = new Object();
        createLockThread(o);
    }
}
