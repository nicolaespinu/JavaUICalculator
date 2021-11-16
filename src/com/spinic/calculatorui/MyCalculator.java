package com.spinic.calculatorui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyCalculator extends Frame {
    public boolean setClear = true;
     double number, memValue;
     char operator;

    String[] digitButtonText = {"1", "2", "3", "4", "5", "7", "6", "8", "9", "0", ".", "+/-"};
    String[] operatorButtonText = {"/", "*", "+", "-", "%", "sqrt", "=", "1/X"};
    String[] memoryButtonText = {"MC", "MR", "MS", "M+"};
    String[] specialButtonText = {"Backspc", "C", "CE"};

    MyDigitButton digitButtons[] = new MyDigitButton[digitButtonText.length];
    MyOperatorButton operatorButtons[] = new MyOperatorButton[operatorButtonText.length];
    MyMemoryButton[] memoryButtons = new MyMemoryButton[memoryButtonText.length];
    MySpecialButton[] specialButtons = new MySpecialButton[specialButtonText.length];

    Label displayLabel = new Label("0", Label.RIGHT);
    Label memLabel = new Label(" ", Label.RIGHT);

    final int FRAME_WIDTH = 325;
    final int FRAME_HEIGHT = 325;

    final int HEIGHT = 30;
    final int WIDTH = 30;

    final int H_SPACE = 10;
    final int V_SPACE = 10;

    final int TOPX = 30;
    final int TOPY = 50;

    MyCalculator(String frameText) {
        super(frameText);
        int tempX = TOPX;
        int tempY = TOPY;
        displayLabel.setBounds(tempX, tempY, 240, HEIGHT);
        displayLabel.setBackground(Color.BLUE);
        displayLabel.setForeground(Color.WHITE);
        add(displayLabel);
        memLabel.setBounds(tempX, tempY + HEIGHT + V_SPACE, WIDTH, HEIGHT);
        add(memLabel);

        //set Co-ordinates for Memory buttons
        tempX = TOPX;
        tempY = TOPY + 2 * (HEIGHT + V_SPACE);
        for (int i = 0; i < memoryButtons.length; i++) {
            memoryButtons[i] = new MyMemoryButton(tempX, tempY, WIDTH, HEIGHT, memoryButtonText[i], this);
            memoryButtons[i].setForeground(Color.RED);
            tempY += HEIGHT + V_SPACE;
        }

        //set Co-ordinates for Special buttons
        tempX = TOPX + 1 * (WIDTH + H_SPACE);
        tempY = TOPY + 1 * (HEIGHT + V_SPACE);
        for (int i = 0; i < specialButtons.length; i++) {
            specialButtons[i] = new MySpecialButton(tempX, tempY, WIDTH * 2, HEIGHT, specialButtonText[i], this);
            specialButtons[i].setForeground(Color.RED);
            tempX = tempX + 2 * WIDTH + H_SPACE;
        }

        //set Co-ordinates  for Digit Buttons
        int digitX = TOPX + WIDTH + H_SPACE;
        int digitY = TOPY + 2 * (HEIGHT + V_SPACE);
        tempX = digitX;
        tempY = digitY;
        for (int i = 0; i < digitButtons.length; i++) {
            digitButtons[i] = new MyDigitButton(tempX, tempY, WIDTH, HEIGHT, digitButtonText[i], this);
            digitButtons[i].setForeground(Color.BLUE);
            tempX += WIDTH + H_SPACE;
            if ((i + 1) % 3 == 0) {
                tempX = digitX;
                tempY += HEIGHT + V_SPACE;
            }
        }

        //set  Co-ordinates for operator Buttons
        int oprsX = digitX + 2 * (WIDTH + H_SPACE) + H_SPACE;
        int oprsY = digitY;

        tempX = oprsX;
        tempY = oprsY;
        for (int i = 0; i < operatorButtons.length; i++) {
            tempX += WIDTH + H_SPACE;
            operatorButtons[i] = new MyOperatorButton(tempX, tempY, WIDTH, HEIGHT, operatorButtonText[i], this);
            operatorButtons[i].setForeground(Color.RED);

            if ((i + 1) % 2 == 0) {
                tempX = oprsX;
                tempY += HEIGHT + V_SPACE;
            }
        }
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setLayout(null);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(true);
    }

    static String getFormattedText(double value) {
        String resText = "" + value;
        if (resText.lastIndexOf(".0") > 0) {
            resText = resText.substring(0, resText.length() - 2);
        }
        return resText;
    }
}



























