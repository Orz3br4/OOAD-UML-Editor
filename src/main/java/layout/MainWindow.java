package layout;

import component.UMLBasicObject;
import component.UMLGroupObject;

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
        groupMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UMLGroupObject groupObject = new UMLGroupObject(0, 0, 0, 0);
                for (UMLBasicObject object: canvas.getSelectedShapes()) {
                    groupObject.addObject(object);
                    object.setGroup(groupObject);
                    canvas.getShapes().remove(object);
                }
                canvas.getSelectedShapes().clear();
                canvas.addSelectedShape(groupObject);
                canvas.addShape(groupObject);
                canvas.repaint();
            }
        });
        editMenu.add(groupMenuItem);
        JMenuItem ungroupMenuItem = new JMenuItem("Ungroup");
        ungroupMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!canvas.getSelectedShapes().isEmpty() && canvas.isOnlyOneGroupSelected()) {
                    ArrayList<UMLBasicObject> tempGroup = new ArrayList<>(canvas.getSelectedGroup().getObjects());
                    canvas.getSelectedGroup().ungroup();
                    canvas.removeShape(canvas.getSelectedGroup());

                    for (UMLBasicObject object: tempGroup) {
                        canvas.addSelectedShape(object);
                        canvas.addShape((object));
                    }
                    canvas.repaint();
                }
            }
        });
        editMenu.add(ungroupMenuItem);
        menuBar.add(editMenu);

        canvas = new Canvas();
        toolBar = new ToolBar(canvas);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(toolBar, BorderLayout.WEST);
        getContentPane().add(canvas, BorderLayout.CENTER);
    }
}
