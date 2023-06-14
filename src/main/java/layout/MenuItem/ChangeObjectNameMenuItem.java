package layout.MenuItem;

import layout.Canvas;
import layout.ChangeObjectNameWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeObjectNameMenuItem extends JMenuItem {
    public ChangeObjectNameMenuItem(ChangeObjectNameWindow changeObjectNameWindow) {
        super("Change Object Name");
        
        Canvas canvas = Canvas.getInstance();
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (canvas.getSelectedObjects().size() == 1) {
                    changeObjectNameWindow.setSelectedObject(canvas.getSelectedObjects().get(0));
                    changeObjectNameWindow.setVisible(true);
                }
            }
        });
    }
}
