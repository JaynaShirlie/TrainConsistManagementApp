import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] arr = {};
        assertThrows(IllegalStateException.class, () -> {
            Main.searchBogie(arr, "BG101");
        });
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] arr = {"BG101","BG205"};
        assertDoesNotThrow(() -> {
            Main.searchBogie(arr, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};
        assertTrue(Main.searchBogie(arr, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};
        assertFalse(Main.searchBogie(arr, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] arr = {"BG101"};
        assertTrue(Main.searchBogie(arr, "BG101"));
    }
}