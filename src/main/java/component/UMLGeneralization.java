package component;

import java.awt.*;

public class UMLGeneralization extends UMLBasicLine {
    public UMLGeneralization(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
    }

    @Override
    public void draw(Graphics g) {
        Point v = new Point(startPoint.x - endPoint.x, startPoint.y - endPoint.y);
        int vLength = (int) Math.hypot(v.x, v.y);

        g.setColor(Color.BLACK);
        g.drawLine(startPoint.x, startPoint.y,
                endPoint.x + v.x / vLength * 12,
                endPoint.y + v.y / vLength * 12);

        double rotatedX1 = (v.x * Math.cos(Math.PI / 6) - v.y * Math.sin(Math.PI / 6)) / vLength * 12;
        double rotatedY1 = (v.x * Math.sin(Math.PI / 6) + v.y * Math.cos(Math.PI / 6)) / vLength * 12;

        Point arrowStartPoint1 = new Point(
                (int) (rotatedX1 + endPoint.x),
                (int) (rotatedY1 + endPoint.y)
        );

        double rotatedX2 = (v.x * Math.cos(-Math.PI / 6) - v.y * Math.sin(-Math.PI / 6)) / vLength * 12;
        double rotatedY2 = (v.x * Math.sin(-Math.PI / 6) + v.y * Math.cos(-Math.PI / 6)) / vLength * 12;

        Point arrowStartPoint2 = new Point(
                (int) (rotatedX2 + endPoint.x),
                (int) (rotatedY2 + endPoint.y)
        );

        g.setColor(Color.WHITE);
        g.fillPolygon(
                new int[] {arrowStartPoint1.x, arrowStartPoint2.x, endPoint.x},
                new int[] {arrowStartPoint1.y, arrowStartPoint2.y, endPoint.y},
                3);

        g.setColor(Color.BLACK);
        g.drawPolygon(
                new int[] {arrowStartPoint1.x, arrowStartPoint2.x, endPoint.x},
                new int[] {arrowStartPoint1.y, arrowStartPoint2.y, endPoint.y},
                3);
    }
}
