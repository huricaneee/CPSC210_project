package persistence;

import model.FitnessMovement;
import model.HourSchedule;
import model.MovementList;
import model.TimeSchedule;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * represent a reader to read MovementList and TimeSchedule in the stored file
 * based on the JsonSerializationDemo
 */

public class JsonReader {
    private String source;

    // EFFECTS: construct a reader with given source
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads movement list from file and returns it;
    // throws IOException if an error occurs reading data from file
    public MovementList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return readAsMovementList(jsonObject);
    }

    // EFFECTS: read source file as TimeSchedule and return it
    // throws IOException if an error occurs reading data from file
    public TimeSchedule read1() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return readAsTimeSchedule(jsonObject);
    }

    // EFFECTS: read source file as string and return it
    public String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8);
        stream.forEach(s -> contentBuilder.append(s));
        return contentBuilder.toString();

    }

    //EFFECTS: parse given JSONObject to a MovementList and return it
    public MovementList readAsMovementList(JSONObject object) {
        MovementList ml = new MovementList();
        JSONArray jsonArray = object.getJSONArray("MovementList");
        for (Object j:jsonArray) {
            JSONObject m = (JSONObject) j;
            addMovement(ml,m);
        }
        return ml;
    }

    // EFFECTS: parse given JSonObject into a Movement and add it into given time MovementList
    // MODIFIES: ml
    public void addMovement(MovementList ml, JSONObject object) {
        String name = object.getString("name");
        String functions = object.getString("functions");
        String picture = object.getString("picture");
        int time = object.getInt("time");
        FitnessMovement movement = new FitnessMovement(name,functions,picture,time);
        ml.addMovement(movement);
    }

    //EFFECTS: parse given JSONObject to a TimeSchedule and return it
    public TimeSchedule readAsTimeSchedule(JSONObject object) {
        TimeSchedule ts = new TimeSchedule();
        JSONArray jsonArray = object.getJSONArray("TimeSchedule");
        for (Object j:jsonArray) {
            JSONObject m = (JSONObject) j;
            addHourSchedule(ts,m);
        }
        return ts;
    }

    // EFFECTS: parse given JSonObject into a hourSchedule and add it into given time schedule
    // MODIFIES: ts
    public void addHourSchedule(TimeSchedule ts, JSONObject object) {
        int day = object.getInt("day");
        int month = object.getInt("month");
        JSONObject ft = object.getJSONObject("movement");
        String name = ft.getString("name");
        String functions = ft.getString("functions");
        int time = ft.getInt("time");
        String picture = ft.getString("picture");

        FitnessMovement ftt = new FitnessMovement(name,functions,picture,time);
        HourSchedule hourSchedule = new HourSchedule(day,month,ftt);
        ts.addSchedule(hourSchedule);
    }


}
