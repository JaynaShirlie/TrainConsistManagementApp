import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] arr = {"Sleeper","AC Chair","First Class","General","Luxury"};
        Arrays.sort(arr);
        assertArrayEquals(new String[]{"AC Chair","First Class","General","Luxury","Sleeper"}, arr);
    }

    @Test
    void testSort_UnsortedInput() {
        String[] arr = {"Luxury","General","Sleeper","AC Chair"};
        Arrays.sort(arr);
        assertArrayEquals(new String[]{"AC Chair","General","Luxury","Sleeper"}, arr);
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] arr = {"AC Chair","First Class","General"};
        Arrays.sort(arr);
        assertArrayEquals(new String[]{"AC Chair","First Class","General"}, arr);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] arr = {"Sleeper","AC Chair","Sleeper","General"};
        Arrays.sort(arr);
        assertArrayEquals(new String[]{"AC Chair","General","Sleeper","Sleeper"}, arr);
    }

    @Test
    void testSort_SingleElementArray() {
        String[] arr = {"Sleeper"};
        Arrays.sort(arr);
        assertArrayEquals(new String[]{"Sleeper"}, arr);
    }
}