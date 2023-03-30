package ui;

import model.FitnessMovement;
import model.HourSchedule;

import javax.swing.*;
import java.util.List;

public class PanelSeeTimeSchedule extends JPanel {
    private List<HourSchedule> list;
    private JTextArea jtextArea;
    private String listString = "";

    public PanelSeeTimeSchedule(List<HourSchedule> list) {
        this.list = list;
        setLayout(null);

        // need edit here
        int i = 0;
        for (HourSchedule e: list) {


            i++;


        }
        jtextArea = new JTextArea(listString);//创建文本域
        jtextArea.setLineWrap(true);//设置文本域自动换行
        jtextArea.setBounds(60, 10, 300, 200);//设置文本域大小
        add(jtextArea);//将文本域加入到窗口
    }
}
