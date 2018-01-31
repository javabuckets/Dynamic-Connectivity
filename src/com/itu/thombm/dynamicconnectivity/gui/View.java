package com.itu.thombm.dynamicconnectivity.gui;

import com.itu.thombm.dynamicconnectivity.Address;

import javax.swing.*;
import java.awt.*;

public class View extends GuiScreen {
    public View() {
        super();
        setResizable(false);
        drawScreen();
    }

    private JPanel panelContents = new JPanel();

    private void drawScreen() {
        // Filler
        JPanel panelLeft, panelRight;
        panelLeft = new JPanel();
        panelRight = new JPanel();

        panelLeft.add(Box.createRigidArea(new Dimension(200, 600)));
        panelRight.add(Box.createRigidArea(new Dimension(200, 600)));

        rootPanel.add(panelLeft, BorderLayout.LINE_START);
        rootPanel.add(panelRight, BorderLayout.LINE_END);
        panelContents.setLayout(new BoxLayout(panelContents, BoxLayout.Y_AXIS));
        rootPanel.add(panelContents, BorderLayout.CENTER);

        // Components
        drawTitle();
        drawParser();
    }

    private void drawTitle() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Address Parser");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));
        panel.add(title);

        panelContents.add(panel);
    }

    private void drawParser() {
        panelContents.add(Box.createRigidArea(new Dimension(0, 50)));

        drawInput();
        panelContents.add(Box.createRigidArea(new Dimension(0, 20)));
        drawInfo();
    }

    private void drawInput() {
        JPanel panel = new JPanel(new FlowLayout());

        JLabel labelInput = new JLabel("Address:");
        JTextField fieldInput = new JTextField(20);
        JButton buttonParse = new JButton("Parse");

        buttonParse.addActionListener(new ButtonParseActionListener(this, fieldInput));

        panel.add(labelInput);
        panel.add(fieldInput);
        panel.add(buttonParse);

        panelContents.add(panel);
    }

    private Font infoFont = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
    private JLabel street, number;

    private void drawInfo() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(Box.createRigidArea(new Dimension(400, 0)));
        panel.setBackground(Color.white);

        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
        boxPanel.setBackground(Color.white);
        panel.add(boxPanel, BorderLayout.WEST);

        JPanel streetPanel = new JPanel(new FlowLayout());
        streetPanel.setBackground(Color.white);
        JPanel numberPanel = new JPanel(new FlowLayout());
        numberPanel.setBackground(Color.white);

        JLabel address = new JLabel("Address");
        JLabel streetLabel = new JLabel("Street: ");
        street = new JLabel("");
        JLabel numberLabel = new JLabel("Number: ");
        number = new JLabel("");
        address.setFont(infoFont.deriveFont(Font.BOLD));
        street.setFont(infoFont);
        number.setFont(infoFont);

        boxPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        boxPanel.add(address);
        boxPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        boxPanel.add(streetPanel);
        boxPanel.add(numberPanel);
        boxPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        streetLabel.add(Box.createRigidArea(new Dimension(5,5)));
        streetPanel.add(streetLabel);
        streetPanel.add(street);
        numberPanel.add(Box.createRigidArea(new Dimension(5,5)));
        numberPanel.add(numberLabel);
        numberPanel.add(number);

        panel.add(Box.createRigidArea(new Dimension(0, 100)));

        panelContents.add(panel);

        // ========= FILLER PANEL ========= \\
        JPanel fillerPanel = new JPanel();
        fillerPanel.add(Box.createRigidArea(new Dimension(0, 250)));
        panelContents.add(fillerPanel);
    }

    public void updateInfo(Address address) {
        street.setText(address.getStreet());
        number.setText(String.valueOf(address.getNumber()));
    }
}
