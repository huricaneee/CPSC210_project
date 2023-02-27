package model;

public class HourSchedule {
    private int day;
    private int month;
    private FitnessMovement movement;

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
