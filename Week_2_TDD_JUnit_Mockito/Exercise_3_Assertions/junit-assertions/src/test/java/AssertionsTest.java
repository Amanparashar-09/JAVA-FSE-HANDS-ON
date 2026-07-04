import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    MathUtils mathUtils = new MathUtils();

    @Test
    public void testAssertEquals() {
        assertEquals(5, mathUtils.add(2, 3));
    }

    @Test
    public void testAssertTrue() {
        assertTrue(mathUtils.isPositive(5));
    }

    @Test
    public void testAssertFalse() {
        assertFalse(mathUtils.isPositive(-3));
    }

    @Test
    public void testAssertNull() {
        assertNull(mathUtils.getNullValue());
    }

    @Test
    public void testAssertNotNull() {
        assertNotNull(mathUtils.getNonNullValue());
    }
}
