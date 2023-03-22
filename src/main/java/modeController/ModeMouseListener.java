package modeController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public interface ModeMouseListener extends MouseListener {
    @Override
    void mouseClicked(MouseEvent e);

    @Override
    void mouseEntered(MouseEvent e);

    @Override
    void mouseExited(MouseEvent e);

    @Override
    void mousePressed(MouseEvent e);

    @Override
    void mouseReleased(MouseEvent e);
}
