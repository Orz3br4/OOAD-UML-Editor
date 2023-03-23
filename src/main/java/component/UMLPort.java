package component;

import java.awt.*;

public class UMLPort extends UMLShape {
    public UMLPort(Point location) {
        x = location.x;
        y = location.y;
        width = 5;
        height = 5;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x - width / 2, y - height / 2, width, height);
    }
}
