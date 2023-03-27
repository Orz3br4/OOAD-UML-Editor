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

        Point v = new Point(startPoint.x - endPoint.x, startPoint.y- endPoint.y );
        int vLength = (int) Math.hypot(v.x, v.y);

        Point arrowEndPoint1 = endPoint;
        Point arrowStartPoint1 = new Point(
                (int) ((v.x * Math.cos(Math.PI / 6) - v.y * Math.sin(Math.PI / 6)) / vLength * 10 + endPoint.x),
                (int) ((v.x * Math.sin(Math.PI / 6) + v.y * Math.cos(Math.PI / 6)) / vLength * 10 + endPoint.y)
        );

        Point arrowEndPoint2 = endPoint;
        Point arrowStartPoint2 = new Point(
                (int) ((v.x * Math.cos(-Math.PI / 6) - v.y * Math.sin(-Math.PI / 6)) / vLength * 10 + endPoint.x),
                (int) ((v.x * Math.sin(-Math.PI / 6) + v.y * Math.cos(-Math.PI / 6)) / vLength * 10 + endPoint.y)
        );

        g.drawLine(arrowStartPoint1.x, arrowStartPoint1.y, arrowEndPoint1.x, arrowEndPoint1.y);
        g.drawLine(arrowStartPoint2.x, arrowStartPoint2.y, arrowEndPoint2.x, arrowEndPoint2.y);
    }
}
