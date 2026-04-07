import org.junit.jupiter.api.Test;
import java.util.regex.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private boolean isValidTrainID(String trainId) {
        Pattern pattern = Pattern.compile("TRN-\\d{4}");
        return pattern.matcher(trainId).matches();
    }

    private boolean isValidCargoCode(String cargoCode) {
        Pattern pattern = Pattern.compile("PET-[A-Z]{2}");
        return pattern.matcher(cargoCode).matches();
    }

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(isValidTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(isValidTrainID("TRAIN12"));
        assertFalse(isValidTrainID("TRN12A"));
        assertFalse(isValidTrainID("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(isValidCargoCode("PET-ab"));
        assertFalse(isValidCargoCode("PET123"));
        assertFalse(isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(isValidTrainID("TRN-123"));
        assertFalse(isValidTrainID("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(isValidCargoCode("pet-AB"));
        assertFalse(isValidCargoCode("Pet-AB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(isValidTrainID(""));
        assertFalse(isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(isValidTrainID("TRN-1234XYZ"));
        assertFalse(isValidCargoCode("PET-AB123"));
    }
}
