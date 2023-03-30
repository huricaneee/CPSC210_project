package ui;

import model.FitnessMovement;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelSeeFitnessMovementList extends JPanel {
    private List<FitnessMovement> list;
    private JTextArea jtextArea;
    private String listString = "";


    public PanelSeeFitnessMovementList(List<FitnessMovement> list) {
        this.list = list;
        setLayout(null);

        int i = 0;
        for (FitnessMovement e: list) {
            listString = listString + i + ". " +  "name: " + e.getName() + "\n" + i + ". "
                    + "function: " + e.getFunctions() + "\n";

            i++;


        }
        jtextArea = new JTextArea(listString);//创建文本域
        jtextArea.setLineWrap(true);//设置文本域自动换行
        jtextArea.setBounds(60, 10, 300, 200);//设置文本域大小
        add(jtextArea);//将文本域加入到窗口

    }








}

