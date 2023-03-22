package layout;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final Dimension mainWindowSize = new Dimension(800, 600);
    private final JMenuBar menuBar;
    private ToolBar toolBar;
    private Canvas canvas;

    public MainWindow(String title) {
        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(mainWindowSize);
        pack();

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenu editMenu = new JMenu("Edit");
        JMenuItem changeObjectNameMenuItem = new JMenuItem("Change Object Name");
        editMenu.add(changeObjectNameMenuItem);
        JMenuItem groupMenuItem = new JMenuItem("Group");
        editMenu.add(groupMenuItem);
        JMenuItem ungroupMenuItem = new JMenuItem("Ungroup");
        editMenu.add(ungroupMenuItem);
        menuBar.add(editMenu);

        canvas = new Canvas();
        toolBar = new ToolBar(canvas);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(toolBar, BorderLayout.WEST);
        getContentPane().add(canvas, BorderLayout.CENTER);
    }
}
