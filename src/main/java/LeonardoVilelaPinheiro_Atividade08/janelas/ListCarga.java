package LeonardoVilelaPinheiro_Atividade08.janelas;

import LeonardoVilelaPinheiro_Atividade08.BDVeiculos;
import LeonardoVilelaPinheiro_Atividade08.Carga;
import LeonardoVilelaPinheiro_Atividade08.Veiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;

public class ListCarga {
    private static ListCarga instance;

    public JFrame tela = new JFrame("Imprimir / Excluir todos CARGA");
    private JTable table;

    private JButton btImprimirTodos = new JButton("Imprimir na Impressora");
    private JButton btExcluirTodos = new JButton("Excluir Todos");
    private JButton btSair = new JButton("Sair");

    {
        btSair.addActionListener(e -> {
            tela.dispose();
        });

        btImprimirTodos.addActionListener(e -> {
            try {
                table.print();
            } catch (SecurityException | PrinterException ex) {
                ex.printStackTrace();
            }
        });

        btExcluirTodos.addActionListener(e -> {
            int y = JOptionPane.showConfirmDialog(null, "Limpar tabela?", "Confirmação", JOptionPane.YES_NO_OPTION);
            switch (y) {
                case 0:
                    BDVeiculos.getBDCarga().clear();
                    tela.dispose();
                    break;
            }
        });
    }

    public static JFrame getFrame() {
        // sempre cria nova tela a fim de atualizar a tabela

//        if (instance == null) {
            instance = new ListCarga();
//        }

        return instance.tela;
    }


    private ListCarga() {

        var beanModel = new BeanTableModel<Carga>(Carga.class, Veiculo.class, BDVeiculos.getBDCarga());
        table = new JTable(beanModel);


        table.setAutoCreateRowSorter(true);
        tela.add(new JScrollPane(table), BorderLayout.CENTER);

        var buttonPanel = new JPanel();
        buttonPanel.add(btImprimirTodos);
        buttonPanel.add(btExcluirTodos);
        buttonPanel.add(btSair);

        tela.add(buttonPanel, BorderLayout.SOUTH);
        tela.pack();
    }

}
