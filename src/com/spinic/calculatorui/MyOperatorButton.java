package com.spinic.calculatorui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyOperatorButton extends Button implements ActionListener {

    MyCalculator myCalculator;

    MyOperatorButton(int x, int y, int width, int heigh, String label, MyCalculator clc) {
        super(label);
        setBounds(x, y, width, heigh);
        this.myCalculator = clc;
        this.myCalculator.add(this);
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {

        String operatorText = ((MyOperatorButton) event.getSource()).getLabel();
        myCalculator.setClear = true;
        double temp = Double.parseDouble(myCalculator.displayLabel.getText());

        if (operatorText.equals("1/X")) {
            try {
                double tempD = 1 / (double) temp;
                myCalculator.displayLabel.setText(MyCalculator.getFormattedText(tempD));
            } catch (ArithmeticException exc) {
                myCalculator.displayLabel.setText("Divide by 0.");
                return;
            }
        }
        if (operatorText.equals("sqrt")) {
            try {
                double tempD = Math.sqrt(temp);
                myCalculator.displayLabel.setText(MyCalculator.getFormattedText(tempD));
            } catch (ArithmeticException exc) {
                myCalculator.displayLabel.setText("???sqrt");
                return;
            }
        }
        if (!operatorText.equals("=")) {
            myCalculator.number = temp;
            myCalculator.operator = operatorText.charAt(0);
            return;
        }
        switch (myCalculator.operator) {
            case '+':
                temp += myCalculator.number;
                break;
            case '-':
                temp = myCalculator.number - temp;
                break;
            case '*':
                temp *= myCalculator.number;
                break;
            case '%':
                try {
                    temp = myCalculator.number % temp;
                } catch (ArithmeticException e) {
                    myCalculator.displayLabel.setText("???%%%");
                    return;
                }
                break;
            case '/':
                try {
                    temp = myCalculator.number / temp;
                } catch (ArithmeticException e) {
                    myCalculator.displayLabel.setText("???///");
                    return;
                }
                break;
        }
        myCalculator.displayLabel.setText(MyCalculator.getFormattedText(temp));
    }
}
















