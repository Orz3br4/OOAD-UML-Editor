package component;

import javax.sound.sampled.Port;
import java.awt.*;
import java.util.ArrayList;

public class UMLClass extends UMLBasicObject {
    private ArrayList<String> attributes = new ArrayList<>();
    private ArrayList<String> methods = new ArrayList<>();

    public UMLClass(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.objName = "Class";
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);

        int portion = height / 3;
        g.drawLine(x, y + portion, x + width, y + portion);
        g.drawLine(x, y + portion * 2, x + width, y + portion * 2);

        int stringWidth = g.getFontMetrics().stringWidth(objName);
        int padding = (width-stringWidth) / 2;
        g.drawString(objName, x + padding, y + portion / 2);

        if (isSelected) {
            for (UMLPort port: ports) {
                port.draw(g);
            }
        }
    }
}
