package ui;

import model.FitnessMovement;
import model.HourSchedule;
import model.MovementList;
import model.TimeSchedule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelAddHourSchedule extends JPanel {
    private int month;
    private int day;
    private FitnessMovement fitnessMovement;


    /**Provide the panel of the function of adding MovementList*/

    // MODIFIES : this, movementList, timeSchedule
    // EFFECTS: Put Swing Component on panel and add actionEvent of the button to update movementList, timeSchedule
    @SuppressWarnings("methodlength")
    public PanelAddHourSchedule(MovementList movementList, TimeSchedule timeSchedule) {
        JButton inputButton = new JButton("Update");
        setLayout(null);
        JTextField inputMonth = new JTextField("month");
        JTextField inputDay = new JTextField("day");
        JTextField inputMovement = new JTextField("movement");


        inputMonth.setBounds(10,0,100,25);
        inputDay.setBounds(10,35,100,25);
        inputMovement.setBounds(10,70,100,25);

        inputButton.setBounds(150,60,150,30);

        add(inputMonth);
        add(inputDay);
        add(inputMovement);

        add(inputButton, BorderLayout.EAST);

        inputButton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {

                // MA - Using the class field myString to receive text from text area

                month = Integer.parseInt(inputMonth.getText());
                day = Integer.parseInt(inputDay.getText());
                String movementText = inputMovement.getText();
                FitnessMovement ff = new FitnessMovement("10","11","12",13);
                for (FitnessMovement f: movementList.getMovementList()) {
                    if (f.getName().equals(movementText)) {
                        ff = f;
                    }
                }

                HourSchedule h = new HourSchedule(day,month,ff);
                timeSchedule.addToSchedule(h);



            }
        });

    }
}
