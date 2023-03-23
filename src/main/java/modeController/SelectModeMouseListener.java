package modeController;

import component.UMLBasicObject;
import layout.Canvas;

import java.awt.*;
import java.awt.event.MouseEvent;

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
        if (canvas.getSelectedShape() != null) {
            canvas.getSelectedShape().setSelected(false);
            canvas.setSelectedShape(null);
        }
        UMLBasicObject object = canvas.getUmlObject(e.getPoint());
        if (object != null) {
            object.setSelected(true);
            canvas.setSelectedShape(object);
        }
        canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (canvas.getSelectedShape() != null) {
            Point currentLocation = e.getPoint();
            if (previousMouseLocation != null) {
                canvas.getSelectedShape().move(
                        currentLocation.x - previousMouseLocation.x,
                        currentLocation.y - previousMouseLocation.y);
            }
            previousMouseLocation = currentLocation;
            canvas.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        previousMouseLocation = e.getPoint();
    }
}
