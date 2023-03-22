package modeController;

import layout.Canvas;
import shape.ShapeFactory;
import shape.UMLClass;
import shape.UMLShape;

import java.awt.*;
import java.awt.event.MouseEvent;

public class CreateObjectModeMouseListener implements ModeMouseListener {
    private final String objType;
    private final ShapeFactory factory = new ShapeFactory();
    private final Canvas canvas;
    public CreateObjectModeMouseListener(String objType, Canvas canvas) {
        this.objType = objType;
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
        UMLShape shape = factory.createUMLShape(objType, e.getPoint());
        System.out.println("shape info: " + shape.getX() + ", " + shape.getY());
        canvas.addShape(shape);
        canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
