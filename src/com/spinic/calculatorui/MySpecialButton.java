package com.spinic.calculatorui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MySpecialButton extends Button implements ActionListener {

    MyCalculator myCalculator;

    MySpecialButton(int x, int y, int width, int heigh, String label, MyCalculator clc) {
        super(label);
        setBounds(x, y, width, heigh);
        this.myCalculator = clc;
        this.myCalculator.add(this);
        addActionListener(this);
    }

    static String backSpace(String str) {
        String response = "";
        for (int i = 0; i < str.length() - 1; i++) {
            response += str.charAt(i);
        }
        return response;
    }

    public void actionPerformed(ActionEvent e) {
        String operatorText = ((MySpecialButton) e.getSource()).getLabel();

        // check for BackSpace button
        if (operatorText.equals("Backspc")) {
            String tempText = backSpace(myCalculator.displayLabel.getText());
            if (tempText.equals("")) {
                myCalculator.displayLabel.setText("0");
            } else {
                myCalculator.displayLabel.setText(tempText);
                return;
            }
        }

        // check for "C" button [Reset]
        if (operatorText.equals("C")) {
            myCalculator.number = 0.0;
            myCalculator.operator = ' ';
            myCalculator.memValue = 0.0;
            myCalculator.memLabel.setText(" ");
        }

        //it must be CE button pressed
        myCalculator.displayLabel.setText("0");
        myCalculator.setClear = true;
    }
}
