package com.nimishs;

import java.io.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by NMSH on 04-04-2016.
 */
public class DiceService implements Service{

    JLabel label;
    JComboBox numOfDice;

    public JPanel getGuiPanel()
    {
        JPanel panel=new JPanel();
        JButton button=new JButton("Roll `em!");
        String[] choices={"1","2","3","4","5"};
        numOfDice=new JComboBox(choices);
        label =new JLabel("Dice values here");

        button.addActionListener(new RollemListener());

        panel.add(numOfDice);
        panel.add(button);
        panel.add(label);

        return panel;
    }

    public class RollemListener implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String diceOutput="";
            String selection=(String)numOfDice.getSelectedItem();
            int numOfDiceToRoll=Integer.parseInt(selection);

            for(int i=0;i<numOfDiceToRoll;i++)
            {
                int r=(int)((Math.random()*6)+1);
                diceOutput+=(" "+r);
            }

            label.setText(diceOutput);
        }
    }


}
