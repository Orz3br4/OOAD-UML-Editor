package modeController;

import layout.Canvas;
import shape.UMLClass;

import java.awt.*;
import java.awt.event.MouseEvent;

public class CreateObjectModeMouseListener implements ModeMouseListener {
    public static final String CLASS = "class";
    public static final String USE_CASE = "useCase";
    private final String objType;
    private Canvas canvas;
    public CreateObjectModeMouseListener(String objType, Canvas canvas) {
        this.objType = objType;
        this.canvas = canvas;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (objType.equals(CLASS)) {
            Point currentPosition = MouseInfo.getPointerInfo().getLocation();
            UMLClass umlClass = new UMLClass(currentPosition.x, currentPosition.y, 50, 100);
            canvas.addShape(umlClass);
            canvas.repaint();
            System.out.println(canvas.getCurrentModeMouseListener().getClass() + ": Mouse CLicked");

        } else if (objType.equals(USE_CASE)) {

        } else {
            System.out.println("No such object type.");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
