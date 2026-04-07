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
                new Bogie("General", 90)
        );
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = getSampleBogies();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Test", 60)
        );

        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Test", 40)
        );

        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 70),
                new Bogie("B", 80),
                new Bogie("C", 50)
        );

        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 20),
                new Bogie("B", 30)
        );

        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 70),
                new Bogie("B", 80)
        );

        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = getSampleBogies();

        List<Bogie> copy = new ArrayList<>(bogies);

        bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertEquals(copy.size(), bogies.size());
    }
}
