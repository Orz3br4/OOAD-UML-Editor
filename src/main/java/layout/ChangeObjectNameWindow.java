package layout;

import component.UMLBasicObject;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class ChangeObjectNameWindow extends JFrame {
    private static final Dimension changeObjectNameWindowSize = new Dimension(400, 100);
    private String newName;
    private UMLBasicObject selectedObject = null;
    private final Canvas canvas = Canvas.getInstance();

    ChangeObjectNameWindow() {

        setTitle("Change Object Name");
        setPreferredSize(changeObjectNameWindowSize);
        pack();

        JTextField nameTextField = new JTextField();
        nameTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFieldState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFieldState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateFieldState();
            }

            private void updateFieldState() {
                newName = nameTextField.getText();
            }
        });

        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(e -> {
            if (selectedObject != null) {
                selectedObject.setObjName(newName);
                selectedObject = null;
                nameTextField.setText(null);
                closeWindow();
                this.canvas.repaint();
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
            selectedObject = null;
            nameTextField.setText(null);
            closeWindow();
        });

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(nameTextField, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(confirmButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(cancelButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void closeWindow() {
        this.setVisible(false);
    }

    public void setSelectedObject(UMLBasicObject umlBasicObject) {
        selectedObject = umlBasicObject;
    }
}
