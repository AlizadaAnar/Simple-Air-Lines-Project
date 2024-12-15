package org.example.rs_practice;

public class Main {
    public static void main(String[] args) {
        //1
//        MyThread myThread1 = new MyThread();
//        MyThread myThread2 = new MyThread();
//        MyThread myThread3 = new MyThread();
//        myThread1.start(); //when we call start it starts and paralelly executes run(),if we call more than once it throws Illegal exception
//        myThread2.start();
//        myThread3.start();


        //2
//          Thread thread = new Thread(new MyRunnable());
//          Thread thread2 = new Thread(new MyRunnable());
//          Thread thread3 = new Thread(new MyRunnable());
//          thread.start();
//          thread2.start();
//          thread3.start();


        //3
//          Thread thread = new Thread(new Runnable() {
//              @Override
//              public void run() {
//                  for (int i = 0; i < 10; i++) {
//                      System.out.println(i);
//                  }
//              }
//          });
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println(i);
//                }
//            }
//        });
//
//          thread.start();
//          thread2.start();


        //4
//        Thread thread = new Thread(() -> System.out.println("runnable is called here"));
//        thread.start();


        //5
//        Thread thread = new Thread(() -> {
//            while (true) {
//                System.out.println("daemond is started");
//            }
//        });
//
//        thread.setDaemon(true);
//        thread.start();

        //Real example
//        Thread daemonThread = new Thread(() -> {
//            while (true) {
//                System.out.println("Daemon thread working...");
//            }
//        });
//        daemonThread.setDaemon(true);
//        daemonThread.start();
//
//        try {
//            Thread.sleep(50); // Bura sherait yaradir ki 0.5 saniye vaxt erzinde mumkun qeder ashagidaki mesaj cap edilsin
//        } catch (
//                InterruptedException e) {//amma sleep() yazmasaq, daha az sayda cap edilecek. Sanki emeliat gedir real heyatda
//            e.printStackTrace();
//        }
//        System.out.println("Main thread finished.");



    }






        /*
                    1.
        1. have you question that when i call start how it executes run() method?
        2. when we write run it says it can be replaced with start, because start itself calls run()
        3. when we call start multiple times in thread it throws IllegalStateException, Where? Show where it throws


                    2.
        1. it works same way as first case
        2. differences ->
            1.  MyThread directly extends from Thread. Which directly create a thread Instance and calls start
            2.  Thread thread = new Thread(new MyRunnable());
                although this is more practical, because you use interface and also have Extends case in hand and
                this runs the run() method of Runnable.
                -----
                Eventually, you reach to the same result, but calling start through Interface is best practice



                  3.
         1. An anonymous class is a class without a name, defined and instantiated inline




                  4.
         1. Here in background Runnable interface is called due to Lambda expressions



                  5.
         1. Daemon threads run in the background and terminate when all user threads finish.
         Use setDaemon(true) before starting the thread.
         2. The text printed so many times because the daemon thread runs an infinite loop (while (true)) and
         keeps printing "daemond is started" as long as the main thread is still alive.
         3. Real example note -> Since daemon threads are not guaranteed to finish before the program exits,
         the main thread's completion message may appear in between daemon thread outputs.


         */
}
