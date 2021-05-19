package LeonardoVilelaPinheiro_Atividade08.janelas;

import LeonardoVilelaPinheiro_Atividade08.BDVeiculos;
import LeonardoVilelaPinheiro_Atividade08.Carga;
import LeonardoVilelaPinheiro_Atividade08.VelocException;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

public class CadastrarCarga {
    private static CadastrarCarga instance;

    private JFrame tela = new JFrame("Cadastrar carga");

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

    private JTextField txtTara = new JTextField(10);
    private JTextField txtCargaMaxima = new JTextField(10);

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
            instance = new CadastrarCarga();
        }

        return instance.tela;
    }

    private CadastrarCarga() {
        tela_editavel(false);

        tela.setSize(1000, 1000);
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        var layout = new GridBagLayout();
        tela.setLayout(layout);

        int line = 0;

        tela.add(new JLabel("Tara:"), new GBC(0, line));
        tela.add(txtTara, new GBC(1, line, 3, 1));
        line++;

        tela.add(new JLabel("Carga máxima:"), new GBC(0, line));
        tela.add(txtCargaMaxima, new GBC(1, line, 3, 1));
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
            if (salvar())
                tela.dispose();
        });
    }

    private boolean salvar() {
        var novoCarga = new Carga();

        try {
            String placa = txtPlaca.getText();
            novoCarga.setPlaca(placa);

            String marca = txtMarca.getText();
            novoCarga.setMarca(marca);

            String modelo = txtModelo.getText();
            novoCarga.setModelo(modelo);

            String cor = txtCor.getText();
            novoCarga.setCor(cor);

            int qtdRodas = Integer.parseInt(txtQdeRodas.getText());
            novoCarga.setQtdRodas(qtdRodas);

            try {
                novoCarga.setVelocMax(Float.parseFloat(txtVelocidade.getText()));
            } catch (VelocException e) {

            }

            novoCarga.setPistoes(Integer.parseInt(txtQdePistoes.getText()));
            novoCarga.setPotencia(Integer.parseInt(txtPotencia.getText()));
            novoCarga.setTara(Integer.parseInt(txtTara.getText()));
            novoCarga.setCargaMax(Integer.parseInt(txtCargaMaxima.getText()));

            BDVeiculos.getBDCarga().add(novoCarga);
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
        txtTara.setEditable(enabled);
        txtCargaMaxima.setEditable(enabled);

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
        txtTara.setText("");
        txtCargaMaxima.setText("");
    }
}
