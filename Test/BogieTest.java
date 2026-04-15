import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BogieTest {

    @Test
    void testValidCapacityCreation() {
        assertDoesNotThrow(() -> {
            new Bogie("Sleeper", 72);
        });
    }

    @Test
    void testNegativeCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("AC Chair", -10);
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testZeroCapacityThrowsException() {
        assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("First Class", 0);
        });
    }

    @Test
    void testObjectIntegrityAfterCreation() throws InvalidCapacityException {
        Bogie bogie = new Bogie("Sleeper", 64);

        assertEquals("Sleeper", bogie.getName());
        assertEquals(64, bogie.getCapacity());
    }

    @Test
    void testMultipleValidBogiesCreation() {
        assertDoesNotThrow(() -> {
            new Bogie("Sleeper", 72);
            new Bogie("AC Chair", 45);
            new Bogie("First Class", 24);
        });
    }
}