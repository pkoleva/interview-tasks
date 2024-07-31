import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pkoleva.api.MockService;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PerformanceTests {
    MockService mockService = new MockService();

    @Test
    void testConcurrentExecution() throws InterruptedException {
        final int[] duration = {0};
        final int[] exceptions = {0};

        int numThreads = 10;
        int numExecutionsPerThread = 100;

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++) {
            executor.execute(() -> {
                for (int j = 0; j < numExecutionsPerThread; j++) {
                    try {
                        int time = mockService.execute();
                        if(time>1000){duration[0]++;};
                    }
                    catch (IOException e){
                        exceptions[0]++;
                    }
                    }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        Assertions.assertTrue(exceptions[0]<=300,
                "Expected number of exceptions is less than or equal to 300, but the real number is "
                        + exceptions[0]);
        Assertions.assertTrue(duration[0]<=50,
                "Expected number of calls longer than 1 second is less than or equal to 50," +
                        "but the real number is " + duration[0]);
    }
}
