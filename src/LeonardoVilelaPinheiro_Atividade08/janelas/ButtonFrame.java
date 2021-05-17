package LeonardoVilelaPinheiro_Atividade08.janelas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class ButtonFrame extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300,
            DEFAULT_HEIGHT = 200;

    public ButtonFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        buttonPanel = new JPanel();

        //create buttons



        var yellowButton = makeButton("Yellow", Color.YELLOW);
/*        var yellowButton = new JButton("Yellow");
        var yellowAction = new ColorAction(Color.YELLOW);
        yellowButton.addActionListener(yellowAction);*/
        buttonPanel.add(yellowButton);

        var blueAction = new ColorAction("Blue", new ImageIcon("blue-ball.gif"), Color.BLUE);
        var blueButton = new JButton(blueAction);
        //var blueButton = makeButton("Blue", Color.BLUE);
/*        var blueButton = new JButton("Blue");
        var blueAction = new ColorAction(Color.BLUE);
        blueButton.addActionListener(blueAction);*/
        buttonPanel.add(blueButton);

        var redButton = makeButton("Red", Color.RED);
/*        var redButton = new JButton("Red");
        var redAction = new ColorAction(Color.RED);
        redButton.addActionListener(redAction);*/
        buttonPanel.add(redButton);

        add(buttonPanel);
    }

    JButton makeButton(final String name, final Color backgroundColor) {
        var button = new JButton(name);
        buttonPanel.add(button);
        button.addActionListener(event -> buttonPanel.setBackground(backgroundColor));
        return button;
    }

 /*   class ColorAction implements ActionListener {
        private Color backgroundColor;

        public ColorAction(Color c) {
            backgroundColor = c;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPanel.setBackground(backgroundColor);
        }
    }*/

    class ColorAction extends AbstractAction {

        public ColorAction(String name, Icon icon, Color c) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue("color", c);
            putValue(SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("color");
            buttonPanel.setBackground(c);
        }
    }
}