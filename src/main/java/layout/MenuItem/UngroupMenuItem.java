package layout.menuItem;

import component.UMLBasicObject;
import layout.Canvas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UngroupMenuItem extends JMenuItem {
    public UngroupMenuItem() {
        super("Ungroup");

        Canvas canvas = Canvas.getInstance();
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (canvas.getSelectedObjects().size() == 1) {
                    canvas.getSelectedObjects().get(0).ungroup();
                }
                canvas.repaint();
            }
        });
    }
}
