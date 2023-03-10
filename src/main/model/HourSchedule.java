package model;

/**
 * HourSchedule represent that a schedule at a specific time to do a fitness movement
 */
public class HourSchedule {
    private int day;
    private int month;
    private FitnessMovement movement;

    // EFFECTS: create a small HourSchedule to store the plan to do the movement with the given day, month, and movement
    public HourSchedule(int day,int month, FitnessMovement movement) {
        this.day = day;
        this.month = month;
        this.movement = movement;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }


    public FitnessMovement getMovement() {
        return movement;
    }
}
