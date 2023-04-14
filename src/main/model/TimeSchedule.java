package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * Time schedule represent all the HourSchedule as a schedule
 */
public class TimeSchedule implements Writable {
    private LinkedList<HourSchedule> schedules;

    // EFFECTS: create a new schedule
    public TimeSchedule() {
        schedules = new LinkedList<HourSchedule>();
    }

    // EFFECTS: add the given HourSchedule to the given TimeSchedule
    public void addSchedule(HourSchedule h) {
        schedules.add(h);
    }

    // EFFECTS: add the given HourSchedule to the given TimeSchedule
    public void addToSchedule(HourSchedule h) {
        schedules.add(h);
        EventLog.getInstance().logEvent(new Event("a new HourSchedule added"));
    }

    public LinkedList<HourSchedule> getSchedules() {
        return schedules;
    }

    // EFFECTS: returns schedules as a JSON array
    public JSONArray schedulesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (HourSchedule t : schedules) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("TimeSchedule", schedulesToJson());
        return json;
    }
}
