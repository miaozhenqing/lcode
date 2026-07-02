package org.example;

import org.example.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        testHighCpu();
    }

    public static void testStackOverflow() {
        while (true) {
            // 递归调用自己，触发栈溢出
            testStackOverflow();
        }
    }
    public static void testOom() {
        while (true) {
            // 创建一个非常大的数组，并尝试使用它来触发内存溢出
            int[] arr = new int[1000000000];
        }
    }

    public static void testHighCpu() {
        new Thread(() -> {
            while (true) {
                // 执行一些计算密集型任务
                double result = Math.sqrt(Math.random() * 1000);
            }
        }, "HighCpuThread").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread exiting.");
    }

    public static void testBlock() {
        Thread blockingThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Blocking thread is going to sleep.");
                    Thread.sleep(5 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BlockingThread");
        Thread blockedThread = new Thread(() -> {
            System.out.println("Blocked thread trying to acquire the lock.");
            synchronized (lock) {
                System.out.println("Blocked thread  acquired the lock.");
            }
        }, "BlockedThread");

        blockingThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        blockedThread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread exiting.");
    }

}