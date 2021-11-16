package com.spinic.calculatorui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyDigitButton extends Button implements ActionListener {

    MyCalculator myCalculator;

    public MyDigitButton(int x, int y, int width, int heigh, String label, MyCalculator clc) {
        super(label);
        setBounds(x, y, width, heigh);
        this.myCalculator = clc;
        this.myCalculator.add(this);
        addActionListener(this);
    }

    static boolean isInString(String string, char ch) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ch) {
                return true;
            }
        }
        return false;
    }

    public void actionPerformed(ActionEvent event) {
        String tempString = ((MyDigitButton) event.getSource()).getLabel();
        if (tempString.equals(".")) {
            if (myCalculator.setClear) {
                myCalculator.displayLabel.setText("0.");
                myCalculator.setClear = false;
            } else if (!isInString(myCalculator.displayLabel.getText(), '.')) {
                myCalculator.displayLabel.setText(myCalculator.displayLabel.getText() + ".");
                return;
            }
        }
        int index = 0;
        try {
            index = Integer.parseInt(tempString);

        } catch (NumberFormatException exception) {
            return;
        }
        if (index == 0 && myCalculator.displayLabel.getText().equals("0")) {
            return;
        }
        if (myCalculator.setClear) {
            myCalculator.displayLabel.setText("" + index);
            myCalculator.setClear = false;
        } else {
            myCalculator.displayLabel.setText(myCalculator.displayLabel.getText() + index);
        }
    }
}
