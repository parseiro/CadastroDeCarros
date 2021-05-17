package LeonardoVilelaPinheiro_Atividade08.janelas;

import javax.swing.*;
import java.awt.*;

public class CadastrarPasseio {
    private static JFrame tela = new JFrame("Cadastrar passeio");

    private static JButton btCadastrar = new JButton("Salvar");
    private static JButton btLimpar = new JButton("Limpar");
    private static JButton btNovo = new JButton("Novo");
    private static JButton btSair = new JButton("Sair");

    private static JTextField txtQdePassageiros = new JTextField(10);
    private static JTextField txtPlaca = new JTextField(10);
    private static JTextField txtMarca = new JTextField(10);
    private static JTextField txtModelo = new JTextField(10);
    private static JTextField txtCor = new JTextField(10);
    private static JTextField txtQdeRodas = new JTextField(10);
    private static JTextField txtVelocidade = new JTextField(10);
    private static JTextField txtQdePistoes = new JTextField(10);
    private static JTextField txtPotencia = new JTextField(10);

    public static void main(String... args) {
        EventQueue.invokeLater(CadastrarPasseio::coisar);
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

        tela.add(new JLabel("Qtde passageiros:"), new GBC(0, line));
        tela.add(txtQdePassageiros, new GBC(1, line, 3, 1));
        line++;

        tela.add(new JLabel("Placa:"), new GBC(0, line));
        tela.add(txtPlaca, new GBC(1, line, 3, 1));
        line++;

        tela.add(new JLabel("Marca:"), new GBC(0, line));
        tela.add(txtMarca, new GBC(1, line, 3, 1));
        line++;

        tela.add(new JLabel("Modelo:"), new GBC(0, line));
        tela.add(txtModelo, new GBC(1, line, 3, 1));
        line++;

        tela.add(new JLabel("Cor:"), new GBC(0, line));
        tela.add(txtCor, new GBC(1, line, 3, 1));
        line++;

        tela.add(new JLabel("Qtd rodas:"), new GBC(0, line));
        tela.add(txtQdeRodas, new GBC(1, line, 3, 1));
        line++;

        tela.add(new JLabel("Veloc max (km/h):"), new GBC(0, line));
        tela.add(txtVelocidade, new GBC(1, line, 3, 1));
        line++;

        tela.add(new JLabel("Qtd pistões:"), new GBC(0, line));
        tela.add(txtQdePistoes, new GBC(1, line, 3, 1));
        line++;

        tela.add(new JLabel("Potência:"), new GBC(0, line));
        tela.add(txtPotencia, new GBC(1, line, 3, 1));
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
