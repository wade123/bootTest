/**
 * BrandBigData.com Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.aiden.boot.thread;

/**
 * @author Tim_Yu
 * @version $Id: NewThread.java, v0.1 2018/1/12 17:17 Tim_Yu
 */
public class ThreadDemo {
    public static void main(String args[]) {
        test1();
    }

    public static void test1() {
        //创建一个新线程
        for (int i = 0; i < 1; i++) {
            Thread thread = new Thread(new NewThread());
            thread.start();
        }
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }
}

//创建一个新的线程
class NewThread implements Runnable {

    //第二个线程入口
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                int sum = 0;
                for (int j = 0; j < 100; j++) {
                    for (int k = 0; k < 100; k++) {
                        sum += j * k;
                    }
                }
                System.out.println(sum);
                // 暂停线程
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}