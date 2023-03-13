package ui;

import model.FitnessMovement;
import model.HourSchedule;
import model.MovementList;
import model.TimeSchedule;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FitnessSystem {
    private MovementList movementList;
    private TimeSchedule timeSchedule;
    private Scanner input;
    private static final String pathOfMovementList = "./data/myFile.json";
    private static final String pathOfHourSchedule = "./data/HourSchedule.json";
    private JsonWriter jsonWriterOfMovementList;
    private JsonReader jsonReaderOfMovementList;
    private JsonWriter jsonWriterOfHourSchedule;
    private JsonReader jsonReaderOfHourSchedule;

    public FitnessSystem() {
        runSystem();
    }

    private void runSystem() {
        boolean runSystem = true;
        String order = null;
        movementList = new MovementList();
        timeSchedule = new TimeSchedule();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        jsonWriterOfMovementList = new JsonWriter(pathOfMovementList);
        jsonReaderOfMovementList = new JsonReader(pathOfMovementList);
        jsonReaderOfHourSchedule = new JsonReader(pathOfHourSchedule);
        jsonWriterOfHourSchedule = new JsonWriter(pathOfHourSchedule);

        while (runSystem) {
            choose();
            order = input.next();

            if (order.equals("q")) {
                runSystem = false;
            } else {
                workOnOrder(order);
            }
        }

    }


    public void workOnOrder(String order) {
        if (order.equals("s")) {
            seeMovementList();
        } else if (order.equals("e")) {
            addToMovementList();
        } else if (order.equals("S")) {
            seeTimeSchedule();
        } else if (order.equals("E")) {
            addToTimeSchedule();
        } else if (order.equals("A")) {
            saveMovementList();
        } else if (order.equals("B")) {
            loadMovementList();
        } else if (order.equals("C")) {
            saveHourSchedule();
        } else if (order.equals("D")) {
            loadHourSchedule();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    public void saveHourSchedule() {
        try {
            jsonWriterOfHourSchedule.open();
            jsonWriterOfHourSchedule.writeTimeSchedule(timeSchedule);
            jsonWriterOfHourSchedule.close();
            System.out.println("Saved");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + pathOfHourSchedule);
        }
    }

    public void loadHourSchedule() {
        try {
            timeSchedule = jsonReaderOfHourSchedule.read1();
            System.out.println("Loaded ");
        } catch (IOException e) {
            System.out.println("Unable to read from file");
        }
    }

    public void saveMovementList() {
        try {
            jsonWriterOfMovementList.open();
            jsonWriterOfMovementList.writeMovementList(movementList);
            jsonWriterOfMovementList.close();
            System.out.println("Saved");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + pathOfMovementList);
        }
    }

    public void loadMovementList() {
        try {
            movementList = jsonReaderOfMovementList.read();
            System.out.println("Loaded ");
        } catch (IOException e) {
            System.out.println("Unable to read from file");
        }
    }



    public void seeMovementList() {
        List<FitnessMovement> list = new ArrayList<FitnessMovement>();
        int i = 0;
        list = movementList.getMovementList();
        for (FitnessMovement e: list) {
            System.out.println("\t" + i + ". " +  "name: " + e.getName());
            System.out.println("\t" + i + ". " + "function: " + e.getFunctions());
            i++;

        }
    }

    public void addToMovementList() {
        String name = null;
        String function = null;
        String picture = null;
        int time = 0;
        System.out.println("Please type the movement name");
        name = input.next();
        System.out.println("Please type the movement function");
        function = input.next();
        System.out.println("Please type the movement picture");
        picture = input.next();
        System.out.println("Please type the how much time you spent on it");
        time = Integer.parseInt(input.next());
        FitnessMovement f = new FitnessMovement(name,function,picture,time);
        movementList.addMovement(f);
    }

    public void seeTimeSchedule() {
        LinkedList<HourSchedule> schedules;
        int i = 0;
        schedules = timeSchedule.getSchedules();
        for (HourSchedule e: schedules) {
            System.out.println("\t" + i + ". At " + e.getMonth() + "month" + e.getDay() + "day for"
                    + e.getMovement().getName());
            i++;


        }
    }

    public void addToTimeSchedule() {
        int month;
        int day;
        int index;

        System.out.println("\tPlease type the month");
        month = Integer.parseInt(input.next());
        System.out.println("\tPlease type the day");
        day = Integer.parseInt(input.next());
        seeMovementList();
        System.out.println("\tPlease type the movement number");
        index = Integer.parseInt(input.next());
        FitnessMovement f = movementList.getMovement(index);
        HourSchedule h = new HourSchedule(day,month,f);
        timeSchedule.addSchedule(h);
    }


    private void choose() {
        System.out.println("\nSelect from:");
        System.out.println("\ts -> see MovementList");
        System.out.println("\te -> add movement to MovementList");
        System.out.println("\tS -> see TimeSchedule");
        System.out.println("\tE -> add HourSchedule to TimeSchedule");
        System.out.println("\tA -> save MovementList");
        System.out.println("\tB -> Load MovementList");
        System.out.println("\tC -> save TimeSchedule");
        System.out.println("\tD -> Load TimeSchedule");
        System.out.println("\tq -> quit");
    }
}
