package rs_practice2;

class JobExecutor implements Runnable {
    private String jobLabel;

    public JobExecutor(String jobLabel) {
        this.jobLabel = jobLabel;
    }

    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println(jobLabel + " - Time left: " + i);
            try {
                Thread.sleep(1000); //checked exception, waits 1 second
            } catch (InterruptedException e) {
                System.out.println(jobLabel + " was stopped.");
            }
        }
        System.out.println(jobLabel + " - Job finished!");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread task1 = new Thread(new JobExecutor("Operation 1"));
        Thread task2 = new Thread(new JobExecutor("Operation 2"));

        task1.start();
        task2.start();
    }
}
