package modeController;

import component.UMLBasicObject;
import layout.Canvas;

import java.awt.*;
import java.awt.event.MouseEvent;

import static java.lang.Math.abs;

public class SelectModeMouseListener extends ModeMouseListener {
    private Point previousMouseLocation = null;

    public SelectModeMouseListener(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        UMLBasicObject object = canvas.getUmlObject(e.getPoint());
        if (object != null) {
            if (!object.isSelected()) {
                for (UMLBasicObject umlBasicObject: canvas.getSelectedObjects()) {
                    umlBasicObject.setSelected(false);
                }
                canvas.getSelectedObjects().clear();
                object.setSelected(true);
                canvas.addSelectedObject(object);
            }
        } else {
            for (UMLBasicObject selectedShape: canvas.getSelectedObjects()) {
                selectedShape.setSelected(false);
            }
            canvas.getSelectedObjects().clear();
        }
        previousMouseLocation = e.getPoint();
        canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (canvas.getSelectedArea() != null) {
            canvas.setSelectedArea(null);
        }
        canvas.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point currentLocation = e.getPoint();
        if (!canvas.getSelectedObjects().isEmpty() && canvas.getSelectedArea() == null) {
            if (previousMouseLocation != null) {
                moveSelectedObjects(currentLocation);
            }
        } else {
            if (canvas.getSelectedArea() != null) {
                updateSelectedArea(currentLocation);
                updateSelectedObjects();
            } else {
                canvas.setSelectedArea(new Rectangle(currentLocation));
                canvas.setStartX(currentLocation.x);
                canvas.setStartY(currentLocation.y);
            }
        }
        previousMouseLocation = currentLocation;
        canvas.repaint();
    }

    private void moveSelectedObjects(Point currentLocation) {
        for (UMLBasicObject selectedShape: canvas.getSelectedObjects()) {
            selectedShape.move(
                    currentLocation.x - previousMouseLocation.x,
                    currentLocation.y - previousMouseLocation.y);
        }
    }

    private void updateSelectedObjects() {
        for (UMLBasicObject object: canvas.getObjects()) {
            if (canvas.getSelectedArea().contains(object.getBounds())) {
                if (!object.isSelected()) {
                    object.setSelected(true);
                    canvas.addSelectedObject(object);
                }
            } else {
                if (object.isSelected()) {
                    object.setSelected(false);
                    canvas.removeSelectedObject(object);
                }
            }
        }
    }

    private void updateSelectedArea(Point currentLocation) {
        int x, y, width, height;
        int x1 = canvas.getStartX(),
            x2 = currentLocation.x,
            y1 = canvas.getStartY(),
            y2 = currentLocation.y;
        width = abs(x1 - x2);
        x = Math.min(x1, x2);
        height = abs(y1 - y2);
        y = Math.min(y1, y2);
        canvas.getSelectedArea().setLocation(x, y);
        canvas.getSelectedArea().setSize(width, height);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        previousMouseLocation = e.getPoint();
    }
}
