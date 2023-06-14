package layout.MenuItem;

import component.UMLBasicObject;
import component.UMLGroupObject;
import layout.Canvas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GroupMenuItem extends JMenuItem {
    public GroupMenuItem() {
        super("Group");
        Canvas canvas = Canvas.getInstance();
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UMLGroupObject groupObject = new UMLGroupObject(0, 0, 0, 0);
                for (UMLBasicObject object: canvas.getSelectedObjects()) {
                    groupObject.addObject(object);
                    object.setGroup(groupObject);
                    canvas.getObjects().remove(object);
                }
                canvas.getSelectedObjects().clear();
                canvas.addSelectedObject(groupObject);
                canvas.addObject(groupObject);
                canvas.repaint();
            }
        });
    }
}
