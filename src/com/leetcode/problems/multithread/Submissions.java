package com.leetcode.problems.multithread;

import java.util.concurrent.Semaphore;

public class Submissions {
}

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    private Semaphore sf = new Semaphore(1);
    private Semaphore sb = new Semaphore(0);

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            sf.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            sb.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            sb.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            sf.release();
        }
    }
}
