package layout;

import component.UMLBasicLine;
import component.UMLGroupObject;
import component.UMLPort;
import modeController.ModeMouseListener;
import component.UMLBasicObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JPanel {
    private  static Canvas instance = null;
    private ModeMouseListener currentModeMouseListener = null;
    private final ArrayList<UMLBasicObject> objects = new ArrayList<>();
    private final ArrayList<UMLBasicLine> lines = new ArrayList<>();
    private final ArrayList<UMLBasicObject> selectedObjects = new ArrayList<>();
    private Rectangle selectedArea = null;
    protected int startX, startY;

    private Canvas() {
        setBackground(Color.WHITE);
    }

    public  static Canvas getInstance() {
        if (Canvas.instance == null) {
            Canvas.instance = new Canvas();
        }
        return Canvas.instance;
    }

    public void setCurrentModeController(ModeMouseListener currentModeMouseListener) {
        if (this.currentModeMouseListener != null) {
            removeMouseListener(this.currentModeMouseListener);
            removeMouseMotionListener(this.currentModeMouseListener);
        }

        for (UMLBasicObject selectedShape: selectedObjects){
                selectedShape.setSelected(false);
        }
        selectedObjects.clear();

        this.currentModeMouseListener = currentModeMouseListener;
        addMouseListener(this.currentModeMouseListener);
        addMouseMotionListener(this.currentModeMouseListener);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (UMLBasicObject shape: objects) {
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

    public void addObject(UMLBasicObject umlBasicObject) {
        for (UMLBasicObject obj: objects) {
            obj.setDepth(obj.getDepth() + 1);
        }
        objects.add(umlBasicObject);
    }

    public void removeObject(UMLBasicObject umlBasicObject) {
        objects.remove(umlBasicObject);
    }

    public void addLine(UMLBasicLine line) {
        lines.add(line);
    }

    public UMLPort getUmlObjectPort(Point point) {
        UMLPort closestPort = null;
        for (UMLBasicObject object: objects) {
            if (object.contains(point)) {
                closestPort = object.getClosestPort(point);
            }
        }
        return closestPort;
    }

    public void removeLine(UMLBasicLine currentLine) {
        lines.remove(currentLine);
    }

    public ArrayList<UMLBasicObject> getSelectedObjects() {
        return selectedObjects;
    }

    public void addSelectedObject(UMLBasicObject selectedShape) {
        this.selectedObjects.add(selectedShape);
    }

    public void removeSelectedObject(UMLBasicObject selectedShape) {
        this.selectedObjects.remove(selectedShape);
    }

    public UMLBasicObject getUmlObject(Point point) {
        UMLBasicObject topMostObject = null;
        for (UMLBasicObject object: objects) {
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

    public ArrayList<UMLBasicObject> getObjects() {
        return objects;
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

}
