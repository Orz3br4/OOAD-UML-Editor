package layout;

import modeController.ModeMouseListener;
import component.UMLBasicObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JPanel {
    private ModeMouseListener currentModeMouseListener = null;
    private ArrayList<UMLBasicObject> shapes = new ArrayList<>();
    private UMLBasicObject selectedShape = null;
    public Canvas() {
        setBackground(Color.WHITE);
    }

    public void setCurrentModeController(ModeMouseListener currentModeMouseListener) {
        if (this.currentModeMouseListener != null) {
            removeMouseListener(this.currentModeMouseListener);
        }
        this.currentModeMouseListener = currentModeMouseListener;
        addMouseListener(this.currentModeMouseListener);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (UMLBasicObject shape: shapes) {
            shape.draw(g);
        }

    }

    public void addShape(UMLBasicObject umlBasicObject) {
        shapes.add(umlBasicObject);
        repaint();
    }
}
