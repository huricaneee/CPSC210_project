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
        assertEquals(0,m.getMovementList().size());

    }

    @Test
    public void testAddMovement() {
        assertTrue(m.addMovement(f));
        assertEquals(1,m.getMovementList().size());
        for(int i=0; i<9;i++){
            assertTrue(m.addMovement(f));
        }
        assertFalse(m.addMovement(f));
    }

}
