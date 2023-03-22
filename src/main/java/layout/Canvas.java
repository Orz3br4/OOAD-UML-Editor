package layout;

import modeController.ModeMouseListener;
import shape.UMLShape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JPanel {
    private ModeMouseListener currentModeMouseListener = null;
    private ArrayList<UMLShape> Shapes = new ArrayList<>();
    private UMLShape selectedShape = null;
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

    public ModeMouseListener getCurrentModeMouseListener() {
        return currentModeMouseListener;
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

        for (UMLShape shape: Shapes) {
            shape.paint(g);
        }

    }

    public void addShape(UMLShape umlShape) {
        Shapes.add(umlShape);
        repaint();
        System.out.println("Shapes: " + Shapes.toString());
    }
}
