package model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class TimeSchedule {
    private LinkedList<HourSchedule> schedules;

    public TimeSchedule() {
        schedules = new LinkedList<HourSchedule>();
    }

    public LinkedList<HourSchedule> getSchedules() {
        return schedules;
    }

    public void addSchedule(HourSchedule h) {
        schedules.add(h);
    }
}
