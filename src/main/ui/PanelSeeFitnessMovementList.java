package ui;

import model.FitnessMovement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class PanelSeeFitnessMovementList extends JPanel {
    private List<FitnessMovement> list;
    JComboBox comboBox;
    JLabel jtaName = new JLabel();
    JLabel jtaFunction = new JLabel();
    ImageIcon ic;
    JLabel jl2 = new JLabel();

    /**Provide the panel of the function of see MovementList*/

    // EFFECT: Put Swing Component on panel and add actionEvent of ComboBox
    @SuppressWarnings("methodlength")
    public PanelSeeFitnessMovementList(List<FitnessMovement> list) {
        this.list = list;
        setLayout(null);

        jl2.setBounds(150,0,100,100);

        comboBox = new JComboBox();
        comboBox.setBounds(10, 10, 100, 21);

        if (!list.isEmpty()) {
            for (FitnessMovement f : list) {
                comboBox.addItem(f);
            }
        }


        this.add(comboBox);

        comboBox.addItemListener(new ItemListener() { // 给下拉框添加一个点击监听器
            public void itemStateChanged(ItemEvent e) { // 下拉框被选择
                FitnessMovement movement = (FitnessMovement) comboBox.getSelectedItem();
                jtaName.setText("name: " + ((FitnessMovement) comboBox.getSelectedItem()).getName());
                //jtaName.setLineWrap(true);//设置文本域自动换行
                jtaName.setBounds(20, 40, 100, 50);//设置文本域大小
                add(jtaName);//将文本域加入到窗口
                jtaFunction.setText("Function: " + movement.getFunctions());
                jtaFunction.setBounds(20,70,100,50);
                add(jtaFunction);
                ic = new ImageIcon(((FitnessMovement) comboBox.getSelectedItem()).getPicture());
                //ic = new ImageIcon("./data/tobs.jpg");
                ic.setImage(ic.getImage().getScaledInstance(100,100,Image.SCALE_AREA_AVERAGING));
                jl2.setIcon(ic);
                add(jl2);

            }

        });







    }
}

