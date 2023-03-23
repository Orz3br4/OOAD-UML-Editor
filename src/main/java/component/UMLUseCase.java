package component;

import java.awt.*;

public class UMLUseCase extends UMLBasicObject {
    public UMLUseCase(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.objName = "Use Case";
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval(x, y, width, height);

        int stringWidth = g.getFontMetrics().stringWidth(objName);
        int padding = (width-stringWidth) / 2;
        g.drawString(objName, x + padding, y + height / 2);

        if (isSelected) {
            for (UMLPort port: ports) {
                port.draw(g);
            }
        }
    }
}
