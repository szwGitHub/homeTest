package com.zh.test.test;

/**
 * @author 18437
 */
public class ThreadTest {

    public static void main(String[] args) {
        ThreadOne threadOne = new ThreadOne();
        ThreadTwo threadTwo = new ThreadTwo();



        threadOne.start();
        threadTwo.start();

        Thread threadFour = new Thread(new ThreadFour());
        threadFour.start();

        Thread threadFive = new Thread(new ThreadFour(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("线程4~~~~~"+i);
                }
            }
        });
        threadFive.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程~~~~~"+i);
        }
    }
}
