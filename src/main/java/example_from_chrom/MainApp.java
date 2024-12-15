package example_from_chrom;

public class MainApp {
    public static void main(String[] args) {
        WorkerThread thread1 = new WorkerThread("Worker 1");
        WorkerThread thread2 = new WorkerThread("Worker 2");

        thread2.setDaemon(true);

        thread1.start();
        thread2.start();

        try {
            thread1.join();  // Wait for thread1 to finish
            thread2.join();  // Wait for thread2 to finish
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("Main thread is done!");
    }
}



/*
        1. Logic of join().
            We have main thread which runs by default when we use setDaemon(true). And we use join() in order to push
            Main mehtod for waiting thread1  for finishing its executions, after that Main thread can
            finish the execution of code, and we will ensure that no data lost from thread1.

            Explanation of thread2 -> The code thread2.setDaemon(true); sets thread2 as a daemon thread, meaning it
            will run in the background and will not prevent the program from exiting once all non-daemon threads
            (like the main thread) have finished.







 */
