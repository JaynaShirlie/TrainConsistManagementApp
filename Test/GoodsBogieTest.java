import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GoodsBogieTest {

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("B001", "Cylindrical");
        bogie.assignCargo("Petroleum");
        assertEquals("Petroleum", bogie.getCurrentCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("B002", "Rectangular");
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("B003", "Rectangular");
        bogie.assignCargo("Petroleum");
        assertNull(bogie.getCurrentCargo());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie bogie1 = new GoodsBogie("B004", "Rectangular");
        GoodsBogie bogie2 = new GoodsBogie("B005", "Cylindrical");

        bogie1.assignCargo("Petroleum");
        bogie2.assignCargo("Grain");

        assertEquals("Grain", bogie2.getCurrentCargo());
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie = new GoodsBogie("B006", "Rectangular");
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }
}