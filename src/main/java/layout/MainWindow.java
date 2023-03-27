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
    private ChangeObjectNameWindow changeObjectNameWindow;

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
        changeObjectNameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (canvas.getSelectedObjects().size() == 1) {
                    changeObjectNameWindow.setSelectedObject(canvas.getSelectedObjects().get(0));
                    changeObjectNameWindow.setVisible(true);
                }
            }
        });
        editMenu.add(changeObjectNameMenuItem);
        JMenuItem groupMenuItem = new JMenuItem("Group");
        groupMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UMLGroupObject groupObject = new UMLGroupObject(0, 0, 0, 0);
                for (UMLBasicObject object: canvas.getSelectedObjects()) {
                    groupObject.addObject(object);
                    object.setGroup(groupObject);
                    canvas.getObjects().remove(object);
                }
                canvas.getSelectedObjects().clear();
                canvas.addSelectedShape(groupObject);
                canvas.addObject(groupObject);
                canvas.repaint();
            }
        });
        editMenu.add(groupMenuItem);
        JMenuItem ungroupMenuItem = new JMenuItem("Ungroup");
        ungroupMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!canvas.getSelectedObjects().isEmpty() && canvas.isOnlyOneGroupSelected()) {
                    ArrayList<UMLBasicObject> tempGroup = new ArrayList<>(canvas.getSelectedGroup().getObjects());
                    canvas.getSelectedGroup().ungroup();
                    canvas.removeObject(canvas.getSelectedGroup());

                    for (UMLBasicObject object: tempGroup) {
                        canvas.addSelectedShape(object);
                        canvas.addObject((object));
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

        changeObjectNameWindow = new ChangeObjectNameWindow(canvas);
    }
}
