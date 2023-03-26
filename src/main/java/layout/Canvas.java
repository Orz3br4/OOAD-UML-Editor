package layout;

import component.UMLBasicLine;
import component.UMLGroupObject;
import component.UMLPort;
import modeController.ModeMouseListener;
import component.UMLBasicObject;

import javax.swing.*;
import javax.xml.crypto.dsig.XMLSignature;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JPanel {
    private ModeMouseListener currentModeMouseListener = null;
    private final ArrayList<UMLBasicObject> shapes = new ArrayList<>();
    private final ArrayList<UMLBasicLine> lines = new ArrayList<>();
    private final ArrayList<UMLBasicObject> selectedShapes = new ArrayList<>();
    private Rectangle selectedArea = null;
    protected int startX, startY;

    public Canvas() {
        setBackground(Color.WHITE);
    }

    public void setCurrentModeController(ModeMouseListener currentModeMouseListener) {
        if (this.currentModeMouseListener != null) {
            removeMouseListener(this.currentModeMouseListener);
            removeMouseMotionListener(this.currentModeMouseListener);
        }

        for (UMLBasicObject selectedShape: selectedShapes){
                selectedShape.setSelected(false);
        }
        selectedShapes.clear();

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

        if (selectedArea != null) {
            drawSelectedArea(g);
        }
    }

    public void drawSelectedArea(Graphics g) {
        g.setColor(new Color(51, 153, 255));
        g.drawRect(selectedArea.x, selectedArea.y, selectedArea.width, selectedArea.height);
        int alpha = 127; // 50% transparency
        g.setColor(new Color(51, 153, 255, alpha));
        g.fillRect(selectedArea.x, selectedArea.y, selectedArea.width, selectedArea.height);
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

    public ArrayList<UMLBasicObject> getSelectedShapes() {
        return selectedShapes;
    }

    public void addSelectedShape(UMLBasicObject selectedShape) {
        this.selectedShapes.add(selectedShape);
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

    public ArrayList<UMLBasicObject> getShapes() {
        return shapes;
    }

    public Rectangle getSelectedArea() {
        return selectedArea;
    }

    public void setSelectedArea(Rectangle selectedArea) {
        this.selectedArea = selectedArea;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public ModeMouseListener getCurrentModeMouseListener() {
        return currentModeMouseListener;
    }

    public boolean isOnlyOneGroupSelected() {
        return (selectedShapes.size() == 1 &&
            selectedShapes.get(0).getClass().getName().equals("component.UMLGroupObject"));
    }

    public UMLGroupObject getSelectedGroup() {
        if (isOnlyOneGroupSelected()) {
            return (UMLGroupObject) selectedShapes.get(0);
        } else return null;
    }
}
