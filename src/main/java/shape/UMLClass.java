package shape;

import java.awt.*;

public class UMLClass extends UMLShape{
    public UMLClass(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.draw(super.getBounds());
    }
}
