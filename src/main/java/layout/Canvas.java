package layout;

import component.UMLBasicLine;
import component.UMLPort;
import modeController.ModeMouseListener;
import component.UMLBasicObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JPanel {
    private ModeMouseListener currentModeMouseListener = null;
    private ArrayList<UMLBasicObject> shapes = new ArrayList<>();
    private ArrayList<UMLBasicLine> lines = new ArrayList<>();

    private UMLBasicObject selectedShape = null;
    public Canvas() {
        setBackground(Color.WHITE);
    }

    public void setCurrentModeController(ModeMouseListener currentModeMouseListener) {
        if (this.currentModeMouseListener != null) {
            removeMouseListener(this.currentModeMouseListener);
            removeMouseMotionListener(this.currentModeMouseListener);
        }
        if (selectedShape != null) {
            selectedShape.setSelected(false);
            selectedShape = null;
        }
        this.currentModeMouseListener = currentModeMouseListener;
        addMouseListener(this.currentModeMouseListener);
        addMouseMotionListener(this.currentModeMouseListener);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (UMLBasicObject shape: shapes) {
            shape.draw(g);
        }

        for (UMLBasicLine line: lines) {
            line.draw(g);
        }

    }

    public void addShape(UMLBasicObject umlBasicObject) {
        for (UMLBasicObject obj: shapes) {
            obj.setDepth(obj.getDepth() + 1);
        }
        shapes.add(umlBasicObject);
    }

    public void removeShape(UMLBasicObject umlBasicObject) {
        shapes.remove(umlBasicObject);
    }

    public void addLine(UMLBasicLine line) {
        lines.add(line);
    }

    public UMLPort getUmlObjectPort(Point point) {
        UMLPort closestPort = null;
        for (UMLBasicObject object: shapes) {
            if (object.contains(point)) {
                closestPort = object.getClosestPort(point);
            }
        }
        return closestPort;
    }

    public void removeLine(UMLBasicLine currentLine) {
        lines.remove(currentLine);
    }

    public UMLBasicObject getSelectedShape() {
        return selectedShape;
    }

    public void setSelectedShape(UMLBasicObject selectedShape) {
        this.selectedShape = selectedShape;
    }

    public UMLBasicObject getUmlObject(Point point) {
        UMLBasicObject topMostObject = null;
        for (UMLBasicObject object: shapes) {
            if (object.contains(point)) {
                if (topMostObject == null) {
                    topMostObject = object;
                } else {
                    topMostObject = (topMostObject.getDepth() < object.getDepth())
                            ? topMostObject: object;
                }
            }
        }
        return topMostObject;
    }
}
