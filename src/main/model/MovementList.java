package model;

import java.util.ArrayList;
import java.util.List;

/**
 * MovementList is a list to store all the fitness movements that are available to do
 */
public class MovementList {
    private List<FitnessMovement> movementList;
    public static final int MAX_SIZE = 10;

    // EFFECTS: create a movement list that can store the movements
    public MovementList() {
        movementList = new ArrayList<FitnessMovement>();
        FitnessMovement movement1 = new FitnessMovement("sit-ups","...","...",0);
        FitnessMovement movement2 = new FitnessMovement("squat","...","...",0);
        movementList.add(movement1);
        movementList.add(movement2);
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

    public FitnessMovement getMovement(int index) {
        return movementList.get(index);
    }

    public List<FitnessMovement> getMovementList() {
        return movementList;
    }
}
