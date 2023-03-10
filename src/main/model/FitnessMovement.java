package model;

/**
 * FitnessMovement class represent a kind of fitness movement that can be added into the to-do list. FitnessMovements
 * should have names, function descriptions, and pictures.
 */
public class FitnessMovement {
    private static int number = 0;
    private String name;
    private String functions;
    private String picture;
    private int time;

    // EFFECTS：create a new fitness movement with the given name, functions, and name
    public FitnessMovement(String name,String functions,String picture,int time) {
        number++;
        this.functions = functions;
        this.name = name;
        this.picture = picture;
        this.time = time;
    }

    public String getFunctions() {
        return functions;
    }

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    public int getTime() {
        return time;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}