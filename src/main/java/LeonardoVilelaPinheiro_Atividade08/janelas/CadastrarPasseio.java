package LeonardoVilelaPinheiro_Atividade08.janelas;

import LeonardoVilelaPinheiro_Atividade08.BDVeiculos;
import LeonardoVilelaPinheiro_Atividade08.Passeio;
import LeonardoVilelaPinheiro_Atividade08.VelocException;

import javax.swing.*;
import java.awt.*;

public class CadastrarPasseio {
    private static CadastrarPasseio instance;

    private JFrame tela = new JFrame("Cadastrar passeio");

    private JButton btCadastrar = new JButton("Salvar");
    private JButton btLimpar = new JButton("Limpar");
    private JButton btNovo = new JButton("Novo");
    private JButton btSair = new JButton("Sair");

    private JTextField txtPlaca = new JTextField(10);
    private JTextField txtMarca = new JTextField(10);
    private JTextField txtModelo = new JTextField(10);
    private JTextField txtCor = new JTextField(10);
    private JTextField txtQdeRodas = new JTextField(10);
    private JTextField txtVelocidade = new JTextField(10);
    private JTextField txtQdePistoes = new JTextField(10);
    private JTextField txtPotencia = new JTextField(10);

    private JTextField txtQdePassageiros = new JTextField(10);

    private JLabel lbErro = new JLabel("");

    {
        btSair.addActionListener(e -> {
            tela_editavel(false);
            limpa_campos();
            tela.dispose();
        });

        btNovo.addActionListener(e -> {
            tela_editavel(true);
            limpa_campos();
        });

        btLimpar.addActionListener(e -> {
            tela_editavel(true);
            limpa_campos();
        });
    }

    public static JFrame getJFrame() {
        if (instance == null) {
            instance = new CadastrarPasseio();
        }

        return instance.tela;
    }

    private CadastrarPasseio() {
        tela_editavel(false);

        tela.setSize(1000, 1000);
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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

        tela.add(new JLabel("Erro (se presente):"), new GBC(0, line));
        tela.add(lbErro, new GBC(1, line, 3, 1));
        line++;

        tela.add(btCadastrar, new GBC(0, line).setAnchor(GridBagConstraints.CENTER));
        tela.add(btLimpar, new GBC(1, line).setAnchor(GridBagConstraints.CENTER));
        tela.add(btNovo, new GBC(2, line).setAnchor(GridBagConstraints.CENTER));
        tela.add(btSair, new GBC(3, line).setAnchor(GridBagConstraints.CENTER));
//        line++;


        tela.pack();
        tela.setVisible(true);

        btCadastrar.addActionListener(e -> {
            if (salvar()) {
                //tela_editavel(true);
                tela.dispose();
            }
        });
    }

    private boolean salvar() {
        var novoPasseio = new Passeio();

        try {
            String placa = txtPlaca.getText();
            novoPasseio.setPlaca(placa);

            String marca = txtMarca.getText();
            novoPasseio.setMarca(marca);

            String modelo = txtModelo.getText();
            novoPasseio.setModelo(modelo);

            String cor = txtCor.getText();
            novoPasseio.setCor(cor);

            int qtdRodas = Integer.parseInt(txtQdeRodas.getText());
            novoPasseio.setQtdRodas(qtdRodas);

            try {
                novoPasseio.setVelocMax(Float.parseFloat(txtVelocidade.getText()));
            } catch (VelocException e) {

            }

            novoPasseio.setPistoes(Integer.parseInt(txtQdePistoes.getText()));
            novoPasseio.setPotencia(Integer.parseInt(txtPotencia.getText()));
            novoPasseio.setQtdePassageiros(Integer.parseInt(txtQdePassageiros.getText()));

            BDVeiculos.getBDPasseio().add(novoPasseio);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            this.lbErro.setText("Verifique os dados");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private void tela_editavel(boolean enabled) {
        txtPlaca.setEditable(enabled);
        txtMarca.setEditable(enabled);
        txtModelo.setEditable(enabled);
        txtCor.setEditable(enabled);
        txtQdeRodas.setEditable(enabled);
        txtVelocidade.setEditable(enabled);
        txtQdePistoes.setEditable(enabled);
        txtPotencia.setEditable(enabled);

        // campo que muda entre Passeio e Carga
        txtQdePassageiros.setEditable(enabled);

        btLimpar.setEnabled(enabled);
        btCadastrar.setEnabled(enabled);
        btNovo.setEnabled(!enabled);
    }

    void limpa_campos() {
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtCor.setText("");
        txtQdeRodas.setText("");
        txtVelocidade.setText("");
        txtQdePistoes.setText("");
        txtPotencia.setText("");

        // campo que muda entre Passeio e Carga
        txtQdePassageiros.setText("");
    }
}
