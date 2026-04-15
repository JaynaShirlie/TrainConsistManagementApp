import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase13TrainConsistigentTest {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    private List<Bogie> createBogies(int size) {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (i % 3 == 0)
                bogies.add(new Bogie("Sleeper", 72));
            else if (i % 3 == 1)
                bogies.add(new Bogie("AC", 50));
            else
                bogies.add(new Bogie("General", 90));
        }
        return bogies;
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> bogies = createBogies(100);

        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }

        for (Bogie b : result) {
            assertTrue(b.capacity > 60);
        }
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> bogies = createBogies(100);

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        for (Bogie b : result) {
            assertTrue(b.capacity > 60);
        }
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = createBogies(100);

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = createBogies(1000);

        long start = System.nanoTime();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = createBogies(100000);

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertFalse(result.isEmpty());

        for (Bogie b : result) {
            assertTrue(b.capacity > 60);
        }
    }
}