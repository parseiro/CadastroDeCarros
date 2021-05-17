package LeonardoVilelaPinheiro_Atividade08.janelas;

import javax.swing.*;

public class CxMsg {
    public static void main(String... args) {
        // caixa de mensagem
        {

        }

        {// caixa de entrada de texto: retorna uma String
            String x = JOptionPane.showInputDialog(null, "Texto interno?", "título", JOptionPane.PLAIN_MESSAGE);
            System.out.println(x);
            JOptionPane.showMessageDialog(null, "Você digitou " + x, "Título: digitou " + x, JOptionPane.PLAIN_MESSAGE);
        }

        {
            // caixa de confirmação: retorna um int, dependendo do botão que escolher na caixa
            int y = JOptionPane.showConfirmDialog(null, "TXT interno", "Tituloooo", JOptionPane.YES_NO_CANCEL_OPTION);
            switch (y) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Clicou no SIM", "Clicou", JOptionPane.PLAIN_MESSAGE);
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Clicou no NÃO", "Clicou", JOptionPane.PLAIN_MESSAGE);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Clicou no CANCELAR", "Clicou", JOptionPane.PLAIN_MESSAGE);
                    break;
            }
        }

    }
}
