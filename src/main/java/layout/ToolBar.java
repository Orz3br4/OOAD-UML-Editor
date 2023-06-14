package layout;

import component.UMLBasicLine;
import modeController.CreateLineModeMouseListener;
import modeController.CreateObjectModeMouseListener;
import modeController.ModeMouseListener;
import modeController.SelectModeMouseListener;
import component.UMLBasicObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JToolBar {

    private ToolButton selectModeButton;
    private ToolButton associationModeButton;
    private ToolButton generalizationModeButton;
    private ToolButton compositionModeButton;
    private ToolButton createClassButton;
    private ToolButton createUseCaseButton;
    private ToolButton selectedButton = null;
    private ModeMouseListener currentModeMouseListener;
    private Canvas canvas = Canvas.getInstance();

    public ToolBar() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        ImageIcon selectIcon = new ImageIcon("src/main/resources/icons/select.png");
        selectModeButton            = new ToolButton("Select", selectIcon, new SelectModeMouseListener(canvas));
        add(selectModeButton);

        ImageIcon associationIcon = new ImageIcon("src/main/resources/icons/association_line.png");
        associationModeButton       = new ToolButton("Association", associationIcon, new CreateLineModeMouseListener(UMLBasicLine.ASSOCIATION, canvas));
        add(associationModeButton);

        ImageIcon generalizationIcon = new ImageIcon("src/main/resources/icons/generalization_line.png");
        generalizationModeButton    = new ToolButton("Generalization", generalizationIcon, new CreateLineModeMouseListener(UMLBasicLine.GENERALIZATION, canvas));
        add(generalizationModeButton);

        ImageIcon compositionIcon = new ImageIcon("src/main/resources/icons/composition_line.png");
        compositionModeButton       = new ToolButton("Composition", compositionIcon, new CreateLineModeMouseListener(UMLBasicLine.COMPOSITION, canvas));
        add(compositionModeButton);

        ImageIcon classIcon = new ImageIcon("src/main/resources/icons/class.png");
        createClassButton           = new ToolButton("Class", classIcon, new CreateObjectModeMouseListener(UMLBasicObject.CLASS, canvas));
        add(createClassButton);

        ImageIcon useCaseIcon = new ImageIcon("src/main/resources/icons/use_case.png");
        createUseCaseButton         = new ToolButton("Use Case", useCaseIcon, new CreateObjectModeMouseListener(UMLBasicObject.USE_CASE, canvas));
        add(createUseCaseButton);
    }

    private class ToolButton extends JButton {
        private final ModeMouseListener modeMouseListener;

        public ToolButton(String toolName, ImageIcon icon, ModeMouseListener modeMouseListener) {
            setToolTipText(toolName);
            setIcon(icon);
            setBackground(Color.WHITE);
            setOpaque(true);
            setBorderPainted(false);
            this.modeMouseListener = modeMouseListener;
            addActionListener(new ToolListener());
        }

        private class ToolListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedButton != null) {
                    selectedButton.setBackground(Color.WHITE);
                }
                selectedButton = (ToolButton) e.getSource();
                selectedButton.setBackground(Color.GRAY);
                currentModeMouseListener = selectedButton.modeMouseListener;
                canvas.setCurrentModeController(currentModeMouseListener);
            }
        }
    }
}
