import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

class BogieTest {

    private List<Bogie> getSampleBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70)
        );
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = getSampleBogies();

        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(222, total); // 72 + 56 + 24 + 70
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = getSampleBogies();

        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertTrue(total > 0);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 80)
        );

        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(80, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = getSampleBogies();

        List<Integer> capacities = bogies.stream()
                .map(Bogie::getCapacity)
                .collect(Collectors.toList());

        assertEquals(Arrays.asList(72, 56, 24, 70), capacities);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = getSampleBogies();

        int expectedSum = 0;
        for (Bogie b : bogies) {
            expectedSum += b.getCapacity();
        }

        int streamSum = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(expectedSum, streamSum);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = getSampleBogies();
        List<Bogie> copy = new ArrayList<>(bogies);

        bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(copy.size(), bogies.size());
    }
}
