package LeonardoVilelaPinheiro_Atividade08.janelas;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class CreateMainWindow {
    private static JFrame tela = new JFrame("Título inicial");

    private static ButtonGroup btGroup = new ButtonGroup();
    private static JRadioButton passeioButton = new JRadioButton("Passeio", true);
    private static JRadioButton cargaButton = new JRadioButton("Carga", false);
    private static CarType selectedCarType;

    enum CarType {
        PASSEIO, CARGA;
    }

    private static void updateLabels(CarType a) {
        selectedCarType = a;

        lbCadastrar.setText("Cadastrar " + a.name());
        lbConsultar.setText("Consultar / excluir por placa " + a.name());
        lbImprimir.setText("Imprimir / excluir todos " + a.name());
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

    static {
        passeioButton.addActionListener(e -> updateLabels(CarType.PASSEIO));
        cargaButton.addActionListener(e -> updateLabels(CarType.CARGA));
        updateLabels(CarType.PASSEIO); // set the default labels

        btGroup.add(passeioButton);
        btGroup.add(cargaButton);

        btCadastrar.addActionListener(e -> {
            if (CreateMainWindow.selectedCarType == CarType.CARGA) {
                CadastrarCarga.getJFrame().setVisible(true);
            } else {
                CadastrarPasseio.getJFrame().setVisible(true);
            }
        });

        btConsultar.addActionListener(e -> {
            if (CreateMainWindow.selectedCarType == CarType.CARGA) {
                ConsultarCarga.getJFrame().setVisible(true);
            } else {
                ConsultarPasseio.getJFrame().setVisible(true);
            }
        });

        btImprimir.addActionListener(e -> {
            if (CreateMainWindow.selectedCarType == CarType.CARGA) {
                ListCarga.getFrame().setVisible(true);
            } else {
                ListPasseio.getFrame().setVisible(true);
            }
        });
    }

    public static void main(String... args) {
        EventQueue.invokeLater(CreateMainWindow::coisar);

//        teste(null);
    }

/*    static private void teste(@NonNull String argumento) {
        if (argumento.equalsIgnoreCase("oi")) System.out.println("É um \"oi\"");
        else System.out.println("Que nada...");
    }*/

    public static void coisar() {

        tela.setSize(1000, 1000);
        tela.setTitle("Sistema de janelas");

        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


//        cxCod.setColumns(10);

//        jan1.add(cxCod);


        btSair.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Obrigado por usar o nosso sistema", "Saindo", JOptionPane.INFORMATION_MESSAGE);
            tela.dispose();
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
        tela.setLayout(layout);

        int line = 0;

        tela.add(passeioButton, new GBC(0, line, 2, 1));
        line++;

        tela.add(cargaButton, new GBC(0, line, 2, 1));
        line++;

        tela.add(btCadastrar, new GBC(0, line).setAnchor(GridBagConstraints.CENTER));
        tela.add(lbCadastrar, new GBC(1, line));
        line++;

        tela.add(btConsultar, new GBC(0, line).setAnchor(GridBagConstraints.CENTER));
        tela.add(lbConsultar, new GBC(1, line));
        line++;

        tela.add(btImprimir, new GBC(0, line).setAnchor(GridBagConstraints.CENTER));
        tela.add(lbImprimir, new GBC(1, line));
        line++;

        tela.add(btSair, new GBC(0, line).setAnchor(GridBagConstraints.CENTER));
        tela.add(new JLabel("Sair"), new GBC(1, line));
        line++;


        tela.pack();

        tela.setVisible(true);
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