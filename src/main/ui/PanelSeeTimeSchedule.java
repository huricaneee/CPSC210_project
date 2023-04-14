package ui;

import model.FitnessMovement;
import model.HourSchedule;
import model.TimeSchedule;

import javax.swing.*;
import java.util.List;

public class PanelSeeTimeSchedule extends JPanel {
    private List<HourSchedule> list;
    private JTextArea jtextArea = new JTextArea();
    private String listString = "";

    /**Provide the panel of the function of see HourSchedule*/

    // EFFECT: Put Swing Component on panel
    public PanelSeeTimeSchedule(TimeSchedule timeSchedule) {
        this.list = timeSchedule.getSchedules();
        setLayout(null);
        jtextArea.setLineWrap(true);//设置文本域自动换行
        jtextArea.setBounds(10, 10, 200, 100);//设置文本域大小
        add(jtextArea);
        // need edit here
        int i = 0;
        for (HourSchedule e: list) {

            System.out.println("\t" + i + ". At " + e.getMonth() + "month" + e.getDay() + "day for"
                    + e.getMovement().getName());
            i++;
            listString = listString + i + ": " + "At" + e.getMonth() + "month" + e.getDay() + "day for"
                    + e.getMovement().getName() + "\n";





        }
        jtextArea.setText(listString);

    }
}
