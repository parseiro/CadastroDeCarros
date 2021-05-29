package LeonardoVilelaPinheiro_Atividade08;

import LeonardoVilelaPinheiro_Atividade08.janelas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class TestGUI {
    private static JFrame tela = new JFrame("Título inicial");

    private static ButtonGroup btGroup = new ButtonGroup();
    private static JRadioButton passeioButton = new JRadioButton("Passeio", true);
    private static JRadioButton cargaButton = new JRadioButton("Carga", false);
    private static CarType selectedCarType;

    enum CarType {
        PASSEIO, CARGA
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
            if (TestGUI.selectedCarType == CarType.CARGA) {
                CadastrarCarga.getJFrame().setVisible(true);
            } else {
                CadastrarPasseio.getJFrame().setVisible(true);
            }
        });

        btConsultar.addActionListener(e -> {
            if (TestGUI.selectedCarType == CarType.CARGA) {
                ConsultarCarga.getJFrame().setVisible(true);
            } else {
                ConsultarPasseio.getJFrame().setVisible(true);
            }
        });

        btImprimir.addActionListener(e -> {
            if (TestGUI.selectedCarType == CarType.CARGA) {
                ListCarga.getFrame().setVisible(true);
            } else {
                ListPasseio.getFrame().setVisible(true);
            }
        });
    }

    public static void main(String... args) {
        EventQueue.invokeLater(TestGUI::coisar);
    }


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
//        line++;


        tela.pack();

        tela.setVisible(true);
    }


}
