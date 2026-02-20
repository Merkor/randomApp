package testspringapp.raznoe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiTreads {
    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {
            executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
        }

        executorService.shutdown();
    }
}
