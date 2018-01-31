package com.itu.thombm.dynamicconnectivity.gui;

import com.itu.thombm.dynamicconnectivity.Address;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonParseActionListener implements ActionListener {
    private View view;
    private JTextField input;

    public ButtonParseActionListener(View view, JTextField input) {
        this.view = view;
        this.input = input;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Address address = Address.parse(input.getText());
            view.updateInfo(address);
        } catch (NullPointerException npe) {
            System.err.println("Could not parse input: " + input + " to type: Address");
            npe.printStackTrace();
        }

    }
}
