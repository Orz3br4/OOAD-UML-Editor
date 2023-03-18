package main;

import layout.MainWindow;

import java.awt.*;

public class UMLEditor {

    private static final Dimension mainWindowSize = new Dimension(800, 600);

    public static void main(String[] args) {

        MainWindow mainWindow = new MainWindow("UML Editor");
        mainWindow.setPreferredSize(mainWindowSize);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
}