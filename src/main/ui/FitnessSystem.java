package ui;

import model.FitnessMovement;
import model.HourSchedule;
import model.MovementList;
import model.TimeSchedule;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * FitnessSystem application
 */
public class FitnessSystem extends JFrame {
    private MovementList movementList;
    private TimeSchedule timeSchedule;
    private Scanner input;
    private static final String pathOfMovementList = "./data/myFile.json";
    private static final String pathOfHourSchedule = "./data/HourSchedule.json";
    private JsonWriter jsonWriterOfMovementList;
    private JsonReader jsonReaderOfMovementList;
    private JsonWriter jsonWriterOfHourSchedule;
    private JsonReader jsonReaderOfHourSchedule;
    private JPanel contentPane;
    private JMenuItem item11 = new JMenuItem("Load FitnessMovementList");
    private JMenuItem item12 = new JMenuItem("Load TimeSchedule");
    private JMenuItem item21 = new JMenuItem("Save FitnessMovementList");
    private JMenuItem item22 = new JMenuItem("Save TimeSchedule");
    private JMenuItem item31 = new JMenuItem("See FitnessMovementList");
    private JMenuItem item32 = new JMenuItem("See TimeSchedule");
    private JMenuItem item41 = new JMenuItem("Add FitnessMovementList");
    private JMenuItem item42 = new JMenuItem("Add TimeSchedule");
    PanelSeeFitnessMovementList p1;

    // EFFECTS: runs the Fitness System
    public FitnessSystem() {
        super("Fitness System");
        init();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(false);
        setBounds(100, 100, 450, 300);


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setVisible(true);

        addMenu();

        JPanel panel = new JPanel();
        panel.setBounds(60, 10, 300, 200);
        contentPane.add(panel);
        CardLayout cardLayout = new CardLayout();
        panel.setLayout(cardLayout);

        p1 = new PanelSeeFitnessMovementList(movementList.getMovementList());
        panel.add(p1,"p1");
        cardLayout.show(panel,"p1");

        // Panel:see movementList

        item31.addActionListener(e -> {
            p1 = new PanelSeeFitnessMovementList(movementList.getMovementList());
            panel.add(p1,"p1");
            cardLayout.show(panel,"p1");
            seeMovementList();
        });

        runSystem();

    }

    @SuppressWarnings("methodlength")
    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        JMenu menu1 = new JMenu("Load");
        JMenu menu2 = new JMenu("Save");
        JMenu menu3 = new JMenu("See");
        JMenu menu4 = new JMenu("Add");

        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        menu1.add(item11);
        menu1.add(item12);
        menu2.add(item21);
        menu2.add(item22);
        menu3.add(item31);
        menu3.add(item32);
        menu4.add(item41);
        menu4.add(item42);

        item11.addActionListener(e -> {
            loadMovementList();
        });
        item12.addActionListener(e -> {
            loadHourSchedule();
        });
        item21.addActionListener(e -> {
            saveMovementList();
        });
        item22.addActionListener(e -> {
            saveHourSchedule();
        });

    }

    private void init() {
        movementList = new MovementList();
        timeSchedule = new TimeSchedule();
        jsonWriterOfMovementList = new JsonWriter(pathOfMovementList);
        jsonReaderOfMovementList = new JsonReader(pathOfMovementList);
        jsonReaderOfHourSchedule = new JsonReader(pathOfHourSchedule);
        jsonWriterOfHourSchedule = new JsonWriter(pathOfHourSchedule);
    }

    // MODIFIES: this
    // EFFECTS: process the user input
    private void runSystem() {



        boolean runSystem = true;
        String order = null;

        input = new Scanner(System.in);
        input.useDelimiter("\n");


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

    // EFFECTS: process user command
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

    // MODIFIES: this
    // EFFECTS: write the current schedule to the file
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

    // MODIFIES: this
    // EFFECTS: load the previous state of TimeSchedule last time the user leave
    public void loadHourSchedule() {
        try {
            timeSchedule = jsonReaderOfHourSchedule.read1();
            System.out.println("Loaded ");
        } catch (IOException e) {
            System.out.println("Unable to read from file");
        }
    }

    // MODIFIES: this
    // EFFECTS: write the current MovementList to the file
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

    // MODIFIES: this
    // EFFECTS: load the previous state of MovementList last time the user leave
    public void loadMovementList() {
        try {
            movementList = jsonReaderOfMovementList.read();
            System.out.println("Loaded ");
        } catch (IOException e) {
            System.out.println("Unable to read from file");
        }
    }


    // EFFECTS: print the movementList
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

    // EFFECTS: add new movement to the MovementList
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

    // EFFECTS: print the TimeSchedule
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

    // EFFECTS: add new movement to the TimeSchedule
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


    // EFFECTS: display the menu
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
