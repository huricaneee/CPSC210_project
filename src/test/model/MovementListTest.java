package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovementListTest {
    private MovementList m;
    private FitnessMovement f = new FitnessMovement("a","b","c",0);
    @BeforeEach
    void runbefore() {
        m= new MovementList();
    }
    @Test
    public void testConstructor() {
        assertEquals(2,m.getMovementList().size());

    }

    @Test
    public void testAddMovement() {
        assertTrue(m.addMovement(f));
        assertEquals(3,m.getMovementList().size());
    }

}
