import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Write a program where a method can be accessed by only 5 threads at a time.
 */
public class SemaphoreExample {

    private static final Semaphore semaphore = new Semaphore(5, true);
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i <= 10; i++) {
            int threadId = i;
            executorService.submit(()-> limitAccess(threadId));
        }
        executorService.shutdown();
    }

    private static void limitAccess(int threadId) {
        boolean acquired = false;

        try {
            semaphore.acquire();
            acquired = true;

            System.out.println("Thread " + threadId + " entered");

            Thread.sleep(5000);

            System.out.println("Thread " + threadId + " completed");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (acquired)
                semaphore.release();
        }
    }
}
