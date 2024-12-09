package com.zh.test.test;

/**
 * @author 18437
 */
public class ThreadFour implements Runnable{
    @Override
    public void run() {
        synchronized (this){
            for (int i = 0; i < 20; i++) {
                System.out.println("线程3~~~~~"+i);
            }
        }
    }
}
