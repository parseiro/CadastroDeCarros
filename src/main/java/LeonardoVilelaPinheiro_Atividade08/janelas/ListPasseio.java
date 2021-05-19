package LeonardoVilelaPinheiro_Atividade08.janelas;

import LeonardoVilelaPinheiro_Atividade08.BDVeiculos;
import LeonardoVilelaPinheiro_Atividade08.Passeio;
import LeonardoVilelaPinheiro_Atividade08.Veiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;

public class ListPasseio {
    private static ListPasseio instance;

    public JFrame tela = new JFrame("Imprimir / Excluir todosm PASSEIO");
    private JTable table;
    public static BDVeiculos bancoDeVeiculos = BDVeiculos.getBDVeiculos();

    private JButton btImprimirTodos = new JButton("Imprimir na Impressora");
    private static JButton btExcluirTodos = new JButton("Excluir Todos");
    private static JButton btSair = new JButton("Sair");

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
            int y = JOptionPane.showConfirmDialog(null, "Limpar tabela?", "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION);
            switch (y) {
                case 0:
                    BDVeiculos.getBDPasseio().clear();
                    tela.dispose();
                    break;
                case 1:
                case 2:
                    break;
            }
        });
    }

    public static JFrame getFrame() {
        // sempre cria nova tela a fim de atualizar a tabela
//        if (instance == null) {
        instance = new ListPasseio();
//        }

        return instance.tela;
    }


    private ListPasseio() {
        var beanModel = new BeanTableModel<Passeio>(Passeio.class, Veiculo.class, BDVeiculos.getBDPasseio());
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
