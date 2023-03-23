package modeController;

import component.ShapeFactory;
import component.UMLBasicLine;
import component.UMLPort;
import layout.Canvas;

import java.awt.*;
import java.awt.event.MouseEvent;

public class CreateLineModeMouseListener extends ModeMouseListener {
    private final ShapeFactory factory = new ShapeFactory();
    private final String lineType;
    private Point startPoint;
    private Point endPoint;
    private UMLBasicLine currentLine = null;

    public CreateLineModeMouseListener(String lineType, Canvas canvas) {
        this.lineType = lineType;
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
        UMLPort closestPort = canvas.getUmlObjectPort(e.getPoint());
        if (closestPort != null) {
            UMLBasicLine line = factory.createUMLLine(lineType, closestPort.getLocation(), e.getPoint());
            currentLine = line;
            canvas.addLine(currentLine);
            canvas.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        UMLPort closestPort = canvas.getUmlObjectPort(e.getPoint());
        if (currentLine != null && closestPort != null) {
            currentLine.setEndPoint(closestPort.getLocation());
            canvas.repaint();
        } else if (currentLine != null && closestPort == null){
            canvas.removeLine(currentLine);
            canvas.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (currentLine != null) {
            System.out.println(e.getPoint());
            currentLine.setEndPoint(e.getPoint());
            canvas.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
