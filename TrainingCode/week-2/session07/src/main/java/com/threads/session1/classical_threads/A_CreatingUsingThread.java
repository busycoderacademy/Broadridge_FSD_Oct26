package com.threads.session1.classical_threads;
//job --> runnable and worker --> thread
class Job implements Runnable {
    @Override
    public void run() {
        System.out.println("thread is doing the job :"+ Thread.currentThread().getName());

    }
}
public class A_CreatingUsingThread {
    public static void main(String[] args) throws InterruptedException {
    	System.out.println("Thread is running: "+ Thread.currentThread().getName()+ ": "+
                Thread.currentThread().getId()+": "+ Thread.currentThread().getPriority());

//      System.out.println("start");
        Job job=new Job();
      Thread thread1 = new Thread(job,"A");
      Thread thread2 = new Thread(job,"B");
      //thread2.setPriority(10);
      Thread thread3 = new Thread(job,"C");

      thread1.start();
      thread2.start();
      thread3.start();


      //main should finish at the last ... join method
        thread1.join();
        thread2.join(1000,100);
        thread3.join();

//        thread1.start();

      System.out.println("end");
    	
    	
    	
    	
    	
//    	//5, 10
//    	System.out.println("Thread is running: "+ Thread.currentThread().getName());
//    	System.out.println("Thread is running: "+ Thread.currentThread().getThreadGroup());
//    	
//    	System.out.println("Thread is running: "+ Thread.currentThread().getId());
//    	System.out.println("Thread is running: "+ Thread.currentThread().getPriority());
//    	
    	


    }
}
