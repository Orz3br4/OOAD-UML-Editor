package layout;

import modeController.CreateLineModeMouseListener;
import modeController.CreateObjectModeMouseListener;
import modeController.ModeMouseListener;
import modeController.SelectModeMouseListener;
import shape.UMLShape;

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
    private Canvas canvas;

    public ToolBar(Canvas controlledCanvas) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        canvas = controlledCanvas;

        ImageIcon selectIcon = new ImageIcon("src/main/resources/icons/select.png");
        selectModeButton            = new ToolButton("Select", selectIcon, new SelectModeMouseListener(canvas));
        add(selectModeButton);

        ImageIcon associationIcon = new ImageIcon("src/main/resources/icons/association_line.png");
        associationModeButton       = new ToolButton("Association", associationIcon, new CreateLineModeMouseListener(CreateLineModeMouseListener.ASSOCIATION, canvas));
        add(associationModeButton);

        ImageIcon generalizationIcon = new ImageIcon("src/main/resources/icons/generalization_line.png");
        generalizationModeButton    = new ToolButton("Generalization", generalizationIcon, new CreateLineModeMouseListener(CreateLineModeMouseListener.GENERALIZATION, canvas));
        add(generalizationModeButton);

        ImageIcon compositionIcon = new ImageIcon("src/main/resources/icons/composition_line.png");
        compositionModeButton       = new ToolButton("Composition", compositionIcon, new CreateLineModeMouseListener(CreateLineModeMouseListener.COMPOSITION, canvas));
        add(compositionModeButton);

        ImageIcon classIcon = new ImageIcon("src/main/resources/icons/class.png");
        createClassButton           = new ToolButton("Class", classIcon, new CreateObjectModeMouseListener(UMLShape.CLASS, canvas));
        add(createClassButton);

        ImageIcon useCaseIcon = new ImageIcon("src/main/resources/icons/use_case.png");
        createUseCaseButton         = new ToolButton("Use Case", useCaseIcon, new CreateObjectModeMouseListener(UMLShape.USE_CASE, canvas));
        add(createUseCaseButton);
    }

    private class ToolButton extends JButton {
        private final ModeMouseListener modeMouseListener;

        public ToolButton(String toolName, ImageIcon icon, ModeMouseListener modeMouseListener) {
            setToolTipText(toolName);
            setIcon(icon);
            setBackground(Color.WHITE);
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
                selectedButton.setBackground(Color.BLUE);
                currentModeMouseListener = selectedButton.modeMouseListener;
                canvas.setCurrentModeController(currentModeMouseListener);
                System.out.println("currentModeController: " + currentModeMouseListener.getClass());
            }
        }
    }
}
