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
                for (UMLBasicObject umlBasicObject: canvas.getSelectedShapes()) {
                    umlBasicObject.setSelected(false);
                }
                canvas.getSelectedShapes().clear();
                object.setSelected(true);
                canvas.addSelectedShape(object);
            }
        } else {
            for (UMLBasicObject selectedShape: canvas.getSelectedShapes()) {
                selectedShape.setSelected(false);
            }
            canvas.getSelectedShapes().clear();
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
        if (!canvas.getSelectedShapes().isEmpty() && canvas.getSelectedArea() == null) {
            if (previousMouseLocation != null) {
                for (UMLBasicObject selectedShape: canvas.getSelectedShapes()) {
                    selectedShape.move(
                            currentLocation.x - previousMouseLocation.x,
                            currentLocation.y - previousMouseLocation.y);
                }
            }
        } else {
            if (canvas.getSelectedArea() != null) {
                updateSelectedArea(currentLocation);
                for (UMLBasicObject object: canvas.getShapes()) {
                    if (canvas.getSelectedArea().contains(object.getBounds())) {
                        if (!object.isSelected()) {
                            object.setSelected(true);
                            canvas.addSelectedShape(object);
                        }
                    }
                }
            } else {
                canvas.setSelectedArea(new Rectangle(currentLocation));
                canvas.setStartX(currentLocation.x);
                canvas.setStartY(currentLocation.y);
            }
        }
        previousMouseLocation = currentLocation;
        canvas.repaint();
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
