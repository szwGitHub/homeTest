package com.zh.test.test;

/**
 * @author 18437
 */
public class ThreadTwo extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("线程2~~~~~"+i);
        }
    }
}
