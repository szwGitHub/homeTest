package com.zh.test.test;

/**
 * @author 18437
 */
public class ThreadOne extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("线程1~~~~~"+i);
        }
    }
}
