package modeController;

import layout.Canvas;
import component.ShapeFactory;
import component.UMLBasicObject;

import java.awt.event.MouseEvent;

public class CreateObjectModeMouseListener extends ModeMouseListener {
    private final String objType;
    private final ShapeFactory factory = new ShapeFactory();

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
        UMLBasicObject shape = factory.createUMLObject(objType, e.getPoint());
        canvas.addObject(shape);
        canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
