package model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * Time schedule represent all the HourSchedule as a schedule
 */
public class TimeSchedule {
    private LinkedList<HourSchedule> schedules;

    // EFFECTS: create a new schedule
    public TimeSchedule() {
        schedules = new LinkedList<HourSchedule>();
    }

    // EFFECTS: add the given HourSchedule to the given TimeSchedule
    public void addSchedule(HourSchedule h) {
        schedules.add(h);
    }

    public LinkedList<HourSchedule> getSchedules() {
        return schedules;
    }


}
