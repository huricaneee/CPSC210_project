package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class FitnessMovementTest {
    private FitnessMovement f;

    @Test
    public void TestConstructor() {
        f = new FitnessMovement ("abc", "def","ghi",0);
        assertEquals("abc",f.getName());
        assertEquals(0,f.getTime());
        assertEquals("def",f.getFunctions());
        assertEquals("ghi",f.getPicture());
    }

}