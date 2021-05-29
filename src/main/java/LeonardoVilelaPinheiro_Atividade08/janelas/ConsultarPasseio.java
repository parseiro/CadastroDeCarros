package LeonardoVilelaPinheiro_Atividade08.janelas;

import LeonardoVilelaPinheiro_Atividade08.BDVeiculos;
import LeonardoVilelaPinheiro_Atividade08.Carga;
import LeonardoVilelaPinheiro_Atividade08.Passeio;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

public class ConsultarPasseio {
    private static ConsultarPasseio instance;

    private Passeio veiculoAtivo;

    private JFrame tela = new JFrame("Consultar / excluir passeio");

    private JButton btConsultar = new JButton("Consultar");
    private JButton btExcluir = new JButton("Excluir");
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

    public static JFrame getJFrame() {
        if (instance == null) {
            instance = new ConsultarPasseio();
        }

        return instance.tela;
    }

    private ConsultarPasseio() {
        make_editable(false);
        btExcluir.setEnabled(false);

        tela.setSize(1000, 1000);
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btSair.addActionListener(e -> tela.dispose());

        var layout = new GridBagLayout();
        tela.setLayout(layout);

        int line = 0;

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

        tela.add(new JLabel("Qtde passageiros:"), new GBC(0, line));
        tela.add(txtQdePassageiros, new GBC(1, line, 3, 1));
        line++;

        tela.add(btConsultar, new GBC(0, line).setAnchor(GridBagConstraints.CENTER));
        tela.add(btExcluir, new GBC(1, line).setAnchor(GridBagConstraints.CENTER));
        tela.add(btSair, new GBC(3, line).setAnchor(GridBagConstraints.CENTER));
//        line++;


        tela.pack();
        tela.setVisible(true);

        btConsultar.addActionListener(e -> consultar());

        btExcluir.addActionListener(e -> {

            int y = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar o veículo?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (y == 0) {
                var veiculo = this.veiculoAtivo;

                if (BDVeiculos.getBDPasseio().contains(veiculo)) {
                    BDVeiculos.getBDPasseio().remove(veiculo);
                    tela.dispose();
                }
                tela.dispose();
            }

        });


    }

    private boolean consultar() {
        final String placa = txtPlaca.getText();
        Optional<Passeio> veicOpt = BDVeiculos.getBDPasseio().stream().filter(s -> s.getPlaca().equalsIgnoreCase(placa)).findAny();

        btExcluir.setEnabled(true);

        this.veiculoAtivo = veicOpt.orElseGet(() -> {
            var a = new Passeio();
            a.setPlaca(placa);
            a.setMarca("NÃO ENCONTREI");
            btExcluir.setEnabled(false);
            return a;
        });

        var veiculo = this.veiculoAtivo;

        try {
            txtMarca.setText(veiculo.getMarca());
            txtModelo.setText(veiculo.getModelo());
            txtCor.setText(veiculo.getCor());
            txtQdeRodas.setText(String.valueOf(veiculo.getQtdRodas()));
            txtVelocidade.setText(String.valueOf(veiculo.getVelocMax()));
            txtQdePistoes.setText(String.valueOf(veiculo.getPistoes()));
            txtPotencia.setText(String.valueOf(veiculo.getPotencia()));

            txtQdePassageiros.setText(String.valueOf(veiculo.getQtdePassageiros()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private void make_editable(boolean editable) {
        txtMarca.setEditable(editable);
        txtModelo.setEditable(editable);
        txtCor.setEditable(editable);
        txtQdeRodas.setEditable(editable);
        txtVelocidade.setEditable(editable);
        txtQdePistoes.setEditable(editable);
        txtPotencia.setEditable(editable);

        txtQdePassageiros.setEditable(editable);
    }
}
