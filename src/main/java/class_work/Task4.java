package class_work;

public class Task4 {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread is running...");
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Set the thread as a daemon
        daemonThread.setDaemon(true);

        // Start the daemon thread
        daemonThread.start();

        // Main thread finishes
        System.out.println("Main thread is finishing...");
    }
}
