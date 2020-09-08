package com.leetcode.problems.multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintIOrder {





}

class Foo {

    public Foo() {

    }

    private volatile int flag = 0;

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(flag != 1) {

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag = 2;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (flag != 2) {

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
