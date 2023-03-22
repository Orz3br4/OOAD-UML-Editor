package modeController;

import layout.Canvas;

import java.awt.event.MouseEvent;

public class CreateLineModeMouseListener implements ModeMouseListener {
    public static final String ASSOCIATION = "association";
    public static final String GENERALIZATION = "generalization";
    public static final String COMPOSITION = "composition";
    private final String lineType;
    private Canvas canvas;

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

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
