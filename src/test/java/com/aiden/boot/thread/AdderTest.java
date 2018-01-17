/**
 * BrandBigData.com Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.aiden.boot.thread;

/**
 * @author Tim_Yu
 * @version $Id: AdderTest.java, v0.1 2018/1/15 15:07 Tim_Yu
 */
public class AdderTest {

    public static void main(String[] args) throws InterruptedException {
        test1();
        System.out.println("=================================");
        testObj();
    }

    public static void testObj() throws InterruptedException {
        RichMan richMan = new RichMan(0, "");
        Thread thread = new Thread(richMan);
        thread.start();
        for (int i = 0; i < 10000; i++) {
            richMan.addOneDollar();
            richMan.addSign();
        }
//        Thread.sleep(5000);
        System.out.println("主线程 money = " + richMan.getMoney());
        System.out.println("主线程 sign length = " + richMan.getSign().length());
    }

    public static void test1() throws InterruptedException {
        Integer counter = 0;
        String sign = "";
        Thread thread = new Thread(new AdderThread(counter, sign));
        thread.start();
        for (int i = 0; i < 10; i++) {
            counter++;
            sign += "$";
        }
        Thread.sleep(1000);
        System.out.println("the value of counter = " + counter);
        System.out.println("the sign is = " + sign + " , length = " + sign.length());
    }
}

class AdderThread implements Runnable {
    private Integer adder;
    private String sign;

    public AdderThread(Integer adder, String sign) {
        this.adder = adder;
        this.sign = sign;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            adder++;
            sign += "$";
        }
    }
}

class RichMan implements Runnable {
    private Integer money;
    private String sign;

    public RichMan(Integer money, String sign) {
        this.money = money;
        this.sign = sign;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            this.addOneDollar();
            this.addSign();
        }
        System.out.println("子线程 money = " + this.money);
        System.out.println("子线程 sign length = " + this.sign.length());
    }

    public void addOneDollar() {
        this.money++;
    }

    public void addSign() {
        this.sign += "$";
    }

    public Integer getMoney() {
        return money;
    }

    public String getSign() {
        return sign;
    }

}
