package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;
import model.EventLog;
import model.Event;

/**
 * MovementList is a list to store all the fitness movements that are available to do
 */
public class MovementList implements Writable {
    private List<FitnessMovement> movementList;
    public static final int MAX_SIZE = 10;

    // EFFECTS: create a movement list that can store the movements
    public MovementList() {
        movementList = new ArrayList<FitnessMovement>();

    }

    // MODIFIES: this
    // EFFECTS: add the given movement to the movement list
    public boolean addMovement(FitnessMovement f) {

        if (movementList.size() == MAX_SIZE) {
            return false;
        } else {
            movementList.add(f);
            return true;
        }


    }

    // MODIFIES: this
    // EFFECTS: add the given movement to the movement list
    public boolean addToMovement(FitnessMovement f) {

        if (movementList.size() == MAX_SIZE) {
            EventLog.getInstance().logEvent(new Event("the movement can't be added because the list if full"));
            return false;
        } else {
            movementList.add(f);
            EventLog.getInstance().logEvent(new Event("a new movement added"));
            return true;
        }


    }

    public FitnessMovement getMovement(int index) {
        return movementList.get(index);
    }

    public List<FitnessMovement> getMovementList() {
        return movementList;
    }

    // EFFECTS: returns movementList as a JSON array
    public JSONArray movementsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (FitnessMovement t : movementList) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("MovementList", movementsToJson());
        return json;
    }
}
