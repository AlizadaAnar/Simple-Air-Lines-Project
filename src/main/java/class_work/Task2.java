package class_work;

public class Task2 implements Runnable {
    // Task 2: Creating a Thread using the Runnable Interface
    @Override
    public void run() {
        for (int i = 6; i <= 10; i++) {
            System.out.println("Runnable Thread: " + Thread.currentThread().getName() + " Number: " + i);
        }
    }

    public static void main(String[] args) {
        // Create a Runnable instance
        Task2 task = new Task2();

        // Start the thread
        Thread thread = new Thread(task);
        thread.start();
    }

}
