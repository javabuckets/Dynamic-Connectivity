package com.itu.thombm.dynamicconnectivity;

import com.itu.thombm.dynamicconnectivity.gui.View;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        View view = (View) new View()
                .withTitle("Address Parser")
                .withDimension(new Dimension(800, 600));
    }
}
