package model;

import java.util.ArrayList;
import java.util.List;

public class MovementList {
    private List<FitnessMovement> movementList;
    public static final int MAX_SIZE = 10;

    public MovementList() {
        movementList = new ArrayList<FitnessMovement>();
        FitnessMovement movement1 = new FitnessMovement("sit-ups","...","...",0);
        FitnessMovement movement2 = new FitnessMovement("squat","...","...",0);
        movementList.add(movement1);
        movementList.add(movement2);
    }

    public boolean addMovement(FitnessMovement f) {

        if (movementList.size() == MAX_SIZE) {
            return false;
        } else {
            movementList.add(f);
            return true;
        }
    }

    public FitnessMovement getMovement(int index) {
        return getMovement(index);
    }

    public List<FitnessMovement> getMovementList() {
        return movementList;
    }
}
