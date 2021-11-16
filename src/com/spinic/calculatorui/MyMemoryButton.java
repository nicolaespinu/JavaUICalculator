package com.spinic.calculatorui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMemoryButton extends Button implements ActionListener {

    MyCalculator myCalculator;

    public MyMemoryButton(int x, int y, int width, int heigh, String label, MyCalculator clc) {
        super(label);
        setBounds(x, y, width, heigh);
        this.myCalculator = clc;
        this.myCalculator.add(this);
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {

        char operatorText = ((MyMemoryButton) event.getSource()).getLabel().charAt(1);
        myCalculator.setClear = true;
        double temp = Double.parseDouble(myCalculator.displayLabel.getText());
        switch (operatorText) {
            case 'C':
                myCalculator.memLabel.setText(" ");
                myCalculator.memValue = 0.0;
                break;
            case 'R':
                myCalculator.displayLabel.setText(MyCalculator.getFormattedText(myCalculator.memValue));
                break;
            case 'S':
                myCalculator.memValue = 0.0;
            case '+':
                myCalculator.memValue = Double.parseDouble(myCalculator.displayLabel.getText());
                if (myCalculator.displayLabel.getText().equals("0") || myCalculator.displayLabel.getText().equals("0.0")) {
                    myCalculator.memLabel.setText(" ");
                } else {
                    myCalculator.memLabel.setText("M");
                }
                break;
        }
    }
}
