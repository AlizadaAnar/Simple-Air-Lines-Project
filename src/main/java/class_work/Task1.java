package class_work;

public class Task1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread: " + Thread.currentThread().getName() + " Number: " + i);
        }
    }

    public static void main(String[] args) {
        Task1 thread = new Task1();

        // Start the thread
        thread.start();

        // Attempting to start the same thread twice (throws IllegalThreadStateException)
        try {
            thread.start();
        } catch (IllegalThreadStateException e) {
            System.out.println("Exception: Cannot start the same thread twice!");
        }
    }
}
