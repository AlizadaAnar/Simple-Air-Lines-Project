package class_work;

public class Task5 {
    public static void main(String[] args) {
        // Thread 1: Countdown from 5 to 1
        Thread countdownThread = new Thread(() -> {
            for (int i = 5; i > 0; i--) {
                System.out.println("Countdown: " + i);
                try {
                    Thread.sleep(1000); // Simulate delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Thread 2: Print task finished
        Thread taskFinishedThread = new Thread(() -> {
            System.out.println("Task finished!");
        });

        // Start both threads
        countdownThread.start();
        taskFinishedThread.start();

        try {
            // Main thread waits for both threads to finish
            countdownThread.join();
            taskFinishedThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread done.");
    }
}
