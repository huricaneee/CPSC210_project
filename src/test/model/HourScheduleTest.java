package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class HourScheduleTest {
    private FitnessMovement f = new FitnessMovement("1","2","3",0);
    private HourSchedule h;
    @Test
    public void testConstructor() {
        h = new HourSchedule(1,2,f);
        assertEquals(1,h.getDay());
        assertEquals(2,h.getMonth());
        assertEquals(f,h.getMovement());
    }
}
