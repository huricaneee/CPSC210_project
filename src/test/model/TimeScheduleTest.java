package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeScheduleTest {
    private TimeSchedule t;
    private FitnessMovement f = new FitnessMovement("a","b","c",0);
    private HourSchedule h = new HourSchedule(1,2,f);



    @Test
    public void testConstructor() {
        t = new TimeSchedule();
        assertEquals(new LinkedList<HourScheduleTest>(),t.getSchedules());
    }

    @Test
    public void testAddSchedule() {
        t = new TimeSchedule();
        t.addSchedule(h);
        assertEquals(h,t.getSchedules().get(0));
    }

}
