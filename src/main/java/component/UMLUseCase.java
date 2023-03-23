package component;

import java.awt.*;

public class UMLUseCase extends UMLBasicObject {
    public UMLUseCase(int x, int y, int width, int height) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval(x, y, width, height);

        int stringWidth = g.getFontMetrics().stringWidth(objName);
        int padding = (width-stringWidth) / 2;
        g.drawString(objName, x + padding, y + height / 2);
    }
}
