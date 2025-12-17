

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {
        TestAsyncService.class,
        AsyncTestConfig.class
})
class AysncAnnotationTest {

    @Autowired
    TestAsyncService asyncService;

    @Test
    void spring_async_test() throws Exception {
        System.out.println("TEST START");

        asyncService.asyncWork(1);
        asyncService.asyncWork(2);
        asyncService.asyncWork(3);

        System.out.println("TEST END");

        // 비동기 작업 완료 대기
        Thread.sleep(3000);
    }
}