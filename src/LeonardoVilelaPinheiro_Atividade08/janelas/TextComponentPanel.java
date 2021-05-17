package LeonardoVilelaPinheiro_Atividade08.janelas;

import javax.swing.*;
import java.awt.*;

public class TextComponentPanel extends JPanel {
    public static final int TEXTAREA_ROWS = 8,
            TEXTAREA_COLUMNS = 20;

    public TextComponentPanel() {
        var textField = new JTextField();
        var passwordField = new JPasswordField();

        var northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,2));
        northPanel.add(new JLabel("User name: ", SwingConstants.RIGHT));
        northPanel.add(textField);
        northPanel.add(new JLabel("Password: ", SwingConstants.RIGHT));
        northPanel.add(passwordField);

        add(northPanel, BorderLayout.NORTH);

        // coisas

//        pack();
    }
}
