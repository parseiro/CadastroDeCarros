package LeonardoVilelaPinheiro_Atividade08.janelas;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class CriaJan {
    private static JFrame jan1 = new JFrame("Título inicial");

    private static ButtonGroup btGroup = new ButtonGroup();
    private static JRadioButton passeioButton;
    private static JRadioButton cargaButton;
    private static CarType selectedCarType;

    static {
        passeioButton = new JRadioButton("Passeio", true);
        cargaButton = new JRadioButton("Carga", false);
        selectedCarType =  CarType.PASSEIO;
        passeioButton.addActionListener(e -> selectedCarType = CarType.PASSEIO);
        cargaButton.addActionListener(e -> selectedCarType = CarType.CARGA);

        btGroup.add(passeioButton);
        btGroup.add(cargaButton);
    }

    enum CarType {
        PASSEIO, CARGA;
    }

    private static JButton btCadastrar = new JButton("C");
    private static JLabel lbCadastrar = new JLabel("Cadastrar");

    private static JButton btConsultar = new JButton("C");
    private static JLabel lbConsultar = new JLabel("Consultar");

    private static JButton btImprimir = new JButton("I");
    private static JLabel lbImprimir = new JLabel("Imprimir");

    private static JButton btSair = new JButton("S");
//    private static JMenuItem itMenuSair = new JMenuItem("Sair");
//    private static JMenu menuPrincipal = new JMenu("Principal");
//    private static JMenuBar barraMenu = new JMenuBar();

    public static void main(String... args) {
        EventQueue.invokeLater(() -> {
            coisar();
        });

    }

    public static void coisar() {

        jan1.setSize(1000, 1000);
        jan1.setTitle("Sistema de janelas");

        jan1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


//        cxCod.setColumns(10);

//        jan1.add(cxCod);



        btSair.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "É o botão SAIR", "Item de Menu", JOptionPane.WARNING_MESSAGE);
            jan1.dispose();
        });

/*        itMenuSair.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "É o item de menu sair", "item de menu", JOptionPane.INFORMATION_MESSAGE);

            jan1.dispose();
        });*/

 /*       itMenuSair.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse entrou");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });*/


//        menuPrincipal.add(itMenuSair);
//        barraMenu.add(menuPrincipal);
//        jan1.setJMenuBar(barraMenu);

        var layout = new GridBagLayout();
//        jan1.setLayout(new FlowLayout());
        jan1.setLayout(layout);

        int line = 0;

        jan1.add(passeioButton, new GBC(0, line, 2, 1));
        line++;

        jan1.add(cargaButton, new GBC(0, line, 2, 1));
        line++;

        jan1.add(btCadastrar, new GBC(0, line).setAnchor(GridBagConstraints.CENTER));
        jan1.add(lbCadastrar, new GBC(1, line));
        line++;

        jan1.add(btConsultar, new GBC(0, line).setAnchor(GridBagConstraints.CENTER));
        jan1.add(lbConsultar, new GBC(1, line));
        line++;

        jan1.add(btImprimir, new GBC(0, line).setAnchor(GridBagConstraints.CENTER));
        jan1.add(lbImprimir, new GBC(1, line));
        line++;


        jan1.add(btSair, new GBC(0, line).setAnchor(GridBagConstraints.CENTER));
        jan1.add(new JLabel("Sair"), new GBC(1, line));
        line++;


//        jan1.add(new NotHelloWorldComponent());
//        jan1.pack();

//        jan1.add(new DrawComponent());

//        jan1.add(new TextComponentPanel());
        jan1.pack();

        jan1.setVisible(true);
    }

    static private void updateLabels(String a) {

    }

}

class NotHelloWorldComponent extends JComponent {
    public static final int MESSAGE_X = 75, MESSAGE_Y = 100;
    private static final int DEFAULT_WIDTH = 300, DEFAULT_HEIGHT = 200;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_WIDTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawString("Not a Hello World program", MESSAGE_X, MESSAGE_Y);
    }
}

class DrawComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 400, DEFAULT_HEIGHT = 400;

    @Override
    protected void paintComponent(Graphics g) {
        var g2 = (Graphics2D) g;

        // draw a rectangle
        double leftX = 100,
                topY = 100,
                width = 200,
                heigth = 150;

        var rect = new Rectangle2D.Double(leftX, topY, width, heigth);
        g2.draw(rect);
//        g2.setPaint(Color.RED);
//        g2.fill(rect);

        // dran an enclosed ellipse
        var ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.draw(ellipse);

        // draw a diagonal line
        g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + heigth));

        //draw a circle with the same center
        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius = heigth;

        var circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
        g2.draw(circle);

        var sansbold14 = new Font("SansSerif", Font.BOLD, 14);
        g2.setFont(sansbold14);
        var message = "Hello World!";
        g2.drawString(message, 75, 100);
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}