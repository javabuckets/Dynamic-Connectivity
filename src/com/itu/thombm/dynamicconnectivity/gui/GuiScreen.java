package com.itu.thombm.dynamicconnectivity.gui;

import javax.swing.*;
import java.awt.*;

public class GuiScreen extends JFrame {
    public JPanel rootPanel = new JPanel(new BorderLayout());

    public GuiScreen() {
        super();
        setVisible(true);
        add(rootPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public GuiScreen withTitle(String title) {
        setTitle(title);
        return this;
    }

    public GuiScreen withDimension(Dimension dimension) {
        setSize(dimension);
        return this;
    }
}
