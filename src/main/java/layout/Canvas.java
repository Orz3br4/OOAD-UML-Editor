package layout;

import modeController.ModeMouseListener;
import shape.UMLShape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JPanel {
    private ModeMouseListener currentModeMouseListener = null;
    private ArrayList<UMLShape> shapes = new ArrayList<>();
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

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (UMLShape shape: shapes) {
            shape.draw(g);
        }

    }

    public void addShape(UMLShape umlShape) {
        shapes.add(umlShape);
        repaint();
        System.out.println("Shapes: " + shapes.toString());
    }
}
