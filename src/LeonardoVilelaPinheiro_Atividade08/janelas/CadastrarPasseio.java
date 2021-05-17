package LeonardoVilelaPinheiro_Atividade08.janelas;

import javax.swing.*;
import java.awt.*;

public class CadastrarPasseio {
    private static JFrame tela = new JFrame("Cadastrar passeio");

    private static JButton btCadastrar = new JButton("Salvar");
    private static JButton btLimpar = new JButton("Limpar");
    private static JButton btNovo = new JButton("Novo");
    private static JButton btSair = new JButton("Sair");

    public static void main(String... args) {
        EventQueue.invokeLater(() -> {
            coisar();
        });
    }

    private static void coisar() {
        tela.setSize(1000, 1000);
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btSair.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Obrigado por usar o nosso sistema", "Saindo", JOptionPane.INFORMATION_MESSAGE);
            tela.dispose();
        });

        var layout = new GridBagLayout();
        tela.setLayout(layout);

        int line = 0;

        tela.add(new JLabel("Qtde passageiros:"), new GBC(0, line))
        line++;

        tela.add(btCadastrar, new GBC(0, line).setAnchor(GridBagConstraints.CENTER));
        tela.add(btLimpar, new GBC(1, line).setAnchor(GridBagConstraints.CENTER));
        tela.add(btNovo, new GBC(2, line).setAnchor(GridBagConstraints.CENTER));
        tela.add(btSair, new GBC(3, line).setAnchor(GridBagConstraints.CENTER));
        line++;



//        jan1.pack();

        tela.setVisible(true);

    }
}
