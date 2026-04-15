import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class GoodsBogieTest{

    // Helper method (same logic as Main)
    public boolean isTrainSafe(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        !b.getType().equals("Cylindrical") ||
                                b.getCargo().equals("Petroleum")
                );
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal")
        );

        assertTrue(isTrainSafe(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(isTrainSafe(bogies));
    }

    @Test
    void testSafety_NonCylindricalAllowed() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Box", "Grain"),
                new GoodsBogie("Open", "Coal")
        );

        assertTrue(isTrainSafe(bogies));
    }

    @Test
    void testSafety_MixedWithViolation() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal"), // violation
                new GoodsBogie("Box", "Iron")
        );

        assertFalse(isTrainSafe(bogies));
    }

    @Test
    void testSafety_EmptyList() {
        List<GoodsBogie> bogies = new ArrayList<>();

        assertTrue(isTrainSafe(bogies));
    }
}