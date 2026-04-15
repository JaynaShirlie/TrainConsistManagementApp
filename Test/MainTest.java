import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testBubbleSort_NormalCase() {
        int[] arr = {72, 56, 24, 70, 60};
        Main.bubbleSort(arr);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, arr);
    }

    @Test
    void testBubbleSort_AlreadySorted() {
        int[] arr = {10, 20, 30, 40};
        Main.bubbleSort(arr);
        assertArrayEquals(new int[]{10, 20, 30, 40}, arr);
    }

    @Test
    void testBubbleSort_ReverseOrder() {
        int[] arr = {90, 80, 70, 60};
        Main.bubbleSort(arr);
        assertArrayEquals(new int[]{60, 70, 80, 90}, arr);
    }

    @Test
    void testBubbleSort_WithDuplicates() {
        int[] arr = {50, 20, 50, 10};
        Main.bubbleSort(arr);
        assertArrayEquals(new int[]{10, 20, 50, 50}, arr);
    }

    @Test
    void testBubbleSort_SingleElement() {
        int[] arr = {5};
        Main.bubbleSort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    void testBubbleSort_EmptyArray() {
        int[] arr = {};
        Main.bubbleSort(arr);
        assertArrayEquals(new int[]{}, arr);
    }
}