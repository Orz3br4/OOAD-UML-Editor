package component;

import java.awt.*;

public class UMLAssociation extends UMLBasicLine {
    public UMLAssociation(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);

//        g.
    }
}
