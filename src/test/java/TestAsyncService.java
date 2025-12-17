
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TestAsyncService {

    @Async
    public void asyncWork(int i) {
        log("start " + i);
        sleep(2000);
        log("end " + i);
    }

    private void log(String msg) {
        System.out.println(
                Thread.currentThread().getName() + " | " + msg
        );
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }
}