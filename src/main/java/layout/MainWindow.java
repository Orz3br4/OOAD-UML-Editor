package layout;

import component.UMLBasicObject;
import component.UMLGroupObject;
import layout.MenuItem.ChangeObjectNameMenuItem;
import layout.MenuItem.GroupMenuItem;
import layout.MenuItem.UngroupMenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    private static final Dimension mainWindowSize = new Dimension(800, 600);
    private final JMenuBar menuBar;
    private ToolBar toolBar;
    private Canvas canvas;
    private ChangeObjectNameWindow changeObjectNameWindow;

    public MainWindow(String title) {
        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(mainWindowSize);
        pack();

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Initialize Edit Menu
        JMenu editMenu = new JMenu("Edit");

        // Add "change object name" menu item
        ChangeObjectNameMenuItem changeObjectNameMenuItem = new ChangeObjectNameMenuItem(changeObjectNameWindow);
        editMenu.add(changeObjectNameMenuItem);

        // Add "Group" menu item
        GroupMenuItem groupMenuItem = new GroupMenuItem();
        editMenu.add(groupMenuItem);

        // Add "Ungroup" menu item
        UngroupMenuItem ungroupMenuItem = new UngroupMenuItem();
        editMenu.add(ungroupMenuItem);

        menuBar.add(editMenu);

        // Initialize Canvas
        canvas = Canvas.getInstance();

        // Initialize ToolBar
        toolBar = new ToolBar();

        // Initialize UI layout
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(toolBar, BorderLayout.WEST);
        getContentPane().add(canvas, BorderLayout.CENTER);

        changeObjectNameWindow = new ChangeObjectNameWindow();
    }
}
