package ui;

import model.FitnessMovement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelAddFitnessMovement extends JPanel {
    private String name;
    private String function;
    private String picture;
    private int time;

    /**Provide the panel of the function of adding TimeSchedule*/

    // EFFECT: Put Swing Component on panel and add actionEvent of the button to update

    @SuppressWarnings("methodlength")
    public PanelAddFitnessMovement(List<FitnessMovement> list) {
        JButton inputButton = new JButton("Update");
        setLayout(null);
        JTextField inputName = new JTextField("name");
        JTextField inputFunction = new JTextField("function");
        JTextField inputPicture = new JTextField("picture");
        JTextField inputTime = new JTextField("time");

        inputName.setBounds(10,0,100,25);
        inputFunction.setBounds(10,35,100,25);
        inputPicture.setBounds(10,70,100,25);
        inputTime.setBounds(10,105,100,25);

        inputButton.setBounds(150,60,150,30);

        add(inputName);
        add(inputFunction);
        add(inputPicture);
        add(inputTime);

        add(inputButton,BorderLayout.EAST);

        inputButton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {

                // MA - Using the class field myString to receive text from text area

                name = inputName.getText();
                function = inputFunction.getText();
                picture = inputPicture.getText();
                time = Integer.parseInt(inputTime.getText());
                FitnessMovement f = new FitnessMovement(name,function,picture,time);
                list.add(f);



            }
        });



    }
}
