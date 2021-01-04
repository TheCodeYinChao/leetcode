package cn.leetcode.sourcecode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * AQS底层源码分析
 *
 * @Author xiaoya.wen@raykite.com
 * @Date 2020/12/24  18:51
 **/
public class AQSDemo {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        lock.lock();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        lock.unlock();
    }

//    /**
//     * ==========================lock()方法分析===========================================
//     */
//
//    /**
//     * Creates and enqueues node for current thread and given mode.
//     * 为当前线程和给定模式创建节点并将其排队。
//     *
//     * @param mode Node.EXCLUSIVE for exclusive, Node.SHARED for shared
//     * @return the new node
//     */
//    private Node addWaiter(Node mode) {
//        Node node = new Node(Thread.currentThread(), mode);
//        // Try the fast path of enq; backup to full enq on failure
//        Node pred = tail;
//        if (pred != null) { // 尾节点不为空
//            node.prev = pred; // 将需要插入节点的prev前节点指向旧尾节点
//            if (compareAndSetTail(pred, node)) { // 采用CAS设置尾节点
//                pred.next = node; // 将旧尾节点的next指向新尾节点
//                return node;
//            }
//        }
//        enq(node); // 尾节点为空 当前队列为空
//        return node;
//    }
//
//    /**
//     * Inserts node into queue, initializing if necessary. See picture above. 将节点插入队列，必要时进行初始化
//     *
//     * @param node the node to insert
//     * @return node's predecessor
//     */
//    private Node enq(final Node node) {
//        for (; ; ) {
//            Node t = tail;
//            if (t == null) { // Must initialize 必须初始化
//                if (compareAndSetHead(new Node())) // 新建一个哨兵节点进行占位 head头节点指向这个哨兵节点
//                    tail = head;    // tail尾节点指向head头节点 也就是哨兵节点
//            } else {
//                node.prev = t; // 将要插入节点的前节点指向 尾节点
//                if (compareAndSetTail(t, node)) { // 采用CAS将当前需要插入的节点放入尾节点 （希望当前尾节点是t 更改为node）
//                    t.next = node; // 将旧尾节点的next指向新尾节点
//                    return t;
//                }
//            }
//        }
//    }
//
//    /**
//     * Acquires in exclusive uninterruptible mode for thread already in
//     * queue. Used by condition wait methods as well as acquire.
//     * 以独占不间断模式获取已在队列中的线程。用于条件等待方法以及获取。
//     *
//     * @param node the node
//     * @param arg  the acquire argument
//     * @return {@code true} if interrupted while waiting
//     */
//    final boolean acquireQueued(final Node node, int arg) {
//        boolean failed = true;
//        try {
//            boolean interrupted = false;
//            for (; ; ) {
//                final Node p = node.predecessor(); // 获取当前节点的前节点
//                if (p == head && tryAcquire(arg)) { // 前驱节点p等于头节点 && 加锁成功 （占用锁的线程已释放）
//                    setHead(node); // setHead(node) 设置头节点为当前节点 node的thread设置为null node的前驱节点设置为null
//                    p.next = null; // help GC
//                    failed = false;
//                    return interrupted;
//                }
//                if (shouldParkAfterFailedAcquire(p, node) && // shouldParkAfterFailedAcquire() 在抢占失败后进入阻塞状态 将哨兵节点的waitStatus的值设置为-1
//                        parkAndCheckInterrupt()) // parkAndCheckInterrupt() --> 采用 LockSupport.park(this); 使当前线程阻塞在此
//                    interrupted = true;
//            }
//        } finally {
//            if (failed)
//                cancelAcquire(node); // 取消排队
//        }
//    }
//
//    /**
//     * Checks and updates status for a node that failed to acquire.
//     * Returns true if thread should block. This is the main signal
//     * control in all acquire loops.  Requires that pred == node.prev.
//     *
//     * 检查并更新未能获取的节点的状态。
//     * 如果线程阻塞，则返回true。这是所有采集环路中的主要信号控制
//     *
//     * @param pred node's predecessor holding status
//     * @param node the node
//     * @return {@code true} if thread should block
//     */
//    private static boolean shouldParkAfterFailedAcquire(Node pred, Node node) {
//        // 获取前驱节点的状态
//        int ws = pred.waitStatus;
//        // 如果是SIGNAL 状态，即等待被占用的资源释放，直接返回true
//        // 准备继续调用parkAndCheckInterrupt()方法 用于将当前线程挂起
//        if (ws == Node.SIGNAL)
//            return true;
//        if (ws > 0) {
//            // 循环判断前驱节点的前驱节点是否也为CANCELLED状态，忽略该状态的节点，重新连接队列
//            do {
//                node.prev = pred = pred.prev;
//            } while (pred.waitStatus > 0);
//            pred.next = node;
//        } else {
//            // 将当前节点的前驱节点设置为SIGNAL状态，用于后续唤醒操作
//            compareAndSetWaitStatus(pred, ws, Node.SIGNAL);
//        }
//        return false;
//    }
//
//    /**
//     * Convenience method to park and then check if interrupted
//     *
//     * @return {@code true} if interrupted
//     */
//    private final boolean parkAndCheckInterrupt() {
//        // 线程挂起 程序不会继续向下执行
//        LockSupport.park(this);
//        // 根据 park 方法API描述 程序在下述三种情况会继续向下执行
//        // 1. unpark
//        // 2. 被中断（interrupt）
//        // 3. 其他不合逻辑的返回才会继续向下执行
//
//        // 因上述三种情况程序执行至此 返回当前线程的中断状态 并清空中断状态
//        // 如果由于被中断，该方法返回true
//        return Thread.interrupted();
//    }
//    /**
//     * ==========================unlock()方法分析===========================================
//     */
//
//    /**
//     * Releases in exclusive mode.  Implemented by unblocking one or
//     * more threads if {@link #tryRelease} returns true.
//     * 以独占模式释放。如果{@link#tryRelease}返回true，则通过取消阻止一个或多个线程来实现
//     *
//     * This method can be used to implement method {@link Lock#unlock}.
//     *
//     * @param arg the release argument.  This value is conveyed to
//     *        {@link #tryRelease} but is otherwise uninterpreted and
//     *        can represent anything you like.
//     * @return the value returned from {@link #tryRelease}
//     */
//    public final boolean release(int arg) {
//        if (tryRelease(arg)) {
//            Node h = head; // 获取头节点 （哨兵节点）
//            if (h != null && h.waitStatus != 0)
//                unparkSuccessor(h);
//            return true;
//        }
//        return false;
//    }
//
//    protected final boolean tryRelease(int releases) {
//        int c = getState() - releases; // getState() 获取state的值
//        if (Thread.currentThread() != getExclusiveOwnerThread()) // 当前线程和占用锁的线程不是同一个线程
//            throw new IllegalMonitorStateException();
//        boolean free = false;
//        if (c == 0) { // state的值是1 （只上了一次锁）
//            free = true;
//            setExclusiveOwnerThread(null); // 将占用锁的线程设置为null
//        }
//        setState(c);  // 从新设置state的值
//        return free;
//    }
//
//    /**
//     * Wakes up node's successor, if one exists.
//     *
//     * @param node the node
//     */
//    private void unparkSuccessor(Node node) {
//        /*
//         * If status is negative (i.e., possibly needing signal) try
//         * to clear in anticipation of signalling.  It is OK if this
//         * fails or if status is changed by waiting thread.
//         */
//        int ws = node.waitStatus;
//        if (ws < 0)
//            compareAndSetWaitStatus(node, ws, 0); // 设置头节点的waitStatus 为 0
//
//        /*
//         * Thread to unpark is held in successor, which is normally
//         * just the next node.  But if cancelled or apparently null,
//         * traverse backwards from tail to find the actual
//         * non-cancelled successor.
//         */
//        Node s = node.next; // 获取头节点的下一个节点
//        if (s == null || s.waitStatus > 0) {
//            s = null;
//            for (Node t = tail; t != null && t != node; t = t.prev)
//                if (t.waitStatus <= 0)
//                    s = t;
//        }
//        if (s != null)
//            LockSupport.unpark(s.thread); // 唤醒队列中第二个节点所对应的线程
//    }

}

