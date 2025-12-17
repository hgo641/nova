import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class AsyncExecutorTest {

    @Test
    void async_executor_basic() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        System.out.println("TEST START");

        executor.submit(() -> {
            sleep(2000);
            System.out.println(Thread.currentThread().getName() + " TASK-1 DONE");
        });

        executor.submit(() -> {
            sleep(1000);
            System.out.println(Thread.currentThread().getName() + " TASK-2 DONE");
        });

        System.out.println("TEST END");

        // 테스트 종료 전에 기다리게 하려고 잠깐 sleep
        Thread.sleep(3000);
        executor.shutdown();
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }
}