package com.threads.session2.classical_threads;

public class RaceCondition {
    //volatile
    private   static boolean done = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!done) {
                    i++;
                }
                System.out.println("Done! [" + Thread.currentThread().getName() + " " + i + "]");
            }
        }).start();
        Thread.sleep(1000);
        done = true;
        System.out.println("Flag done set to true [" + Thread.currentThread().getName() + "]");
    }
}