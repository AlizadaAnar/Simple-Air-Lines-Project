package org.example.example_from_chrom;

public class WorkerThread extends Thread{

    public WorkerThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(Thread.currentThread().getName() + " - Countdown: " + i);
                Thread.sleep(1000);  // Pauses the thread for 1 second
            }
            System.out.println(Thread.currentThread().getName() + " - Finished!");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
    }
}
