package class_work;

public class Task3 {
    // Task 3: Creating a Thread using an Anonymous Runnable Class
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 11; i <= 15; i++) {
                    System.out.println("Anonymous Thread: " + Thread.currentThread().getName() + " Number: " + i);
                }
            }
        });

        // Start the thread
        thread.start();
    }

}
