package layout;

import javax.swing.*;
import java.awt.*;

public class ToolkitPane extends JPanel {

    private JButton selectModeButton;
    private JButton associationModeButton;
    private JButton generalizationModeButton;
    private JButton compositionModeButton;
    private JButton createClassButton;
    private JButton createUseCaseButton;

    public ToolkitPane(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
        _init();
    }

    public ToolkitPane(LayoutManager layout) {
        super(layout);
        _init();
    }

    public ToolkitPane(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        _init();
    }

    public ToolkitPane() {
        super();
        _init();
    }

    private void _init() {
        selectModeButton            = new JButton(new ImageIcon("src/main/resources/icons/select.png"));
        add(selectModeButton);

        associationModeButton       = new JButton(new ImageIcon("src/main/resources/icons/association_line.png"));
        add(associationModeButton);

        generalizationModeButton    = new JButton(new ImageIcon("src/main/resources/icons/generalization_line.png"));
        add(generalizationModeButton);

        compositionModeButton       = new JButton(new ImageIcon("src/main/resources/icons/composition_line.png"));
        add(compositionModeButton);

        createClassButton           = new JButton(new ImageIcon("src/main/resources/icons/class.png"));
        add(createClassButton);

        createUseCaseButton         = new JButton(new ImageIcon("src/main/resources/icons/use_case.png"));
        add(createUseCaseButton);
    }
}
