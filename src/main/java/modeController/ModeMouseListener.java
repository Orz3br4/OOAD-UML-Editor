package modeController;

import layout.Canvas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class ModeMouseListener implements MouseListener, MouseMotionListener {
    protected Canvas canvas;
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {};

    @Override
    public void mouseExited(MouseEvent e) {};

    @Override
    public void mousePressed(MouseEvent e) {};

    @Override
    public void mouseReleased(MouseEvent e) {};
}
