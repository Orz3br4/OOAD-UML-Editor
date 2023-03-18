package layout;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private final JSplitPane mainPane;
    private ToolkitPane toolkitPane;
    private CanvasPane canvasPane;

    public MainWindow(String title) {
        super(title);

        toolkitPane = new ToolkitPane();
        toolkitPane.setLayout(new BoxLayout(toolkitPane, BoxLayout.PAGE_AXIS));
        toolkitPane.setVisible(true);
//        toolkitPane.setPreferredSize(new Dimension(getWidth(), getHeight()));

        canvasPane = new CanvasPane();
        canvasPane.setVisible(true);
//        canvasPane.setPreferredSize(new Dimension(getWidth(), getHeight()));
        add(canvasPane);

        mainPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, toolkitPane, canvasPane);
        add(mainPane);
    }
}
