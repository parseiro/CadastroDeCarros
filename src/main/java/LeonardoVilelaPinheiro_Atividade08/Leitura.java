package LeonardoVilelaPinheiro_Atividade08;

import java.util.Scanner;

public class Leitura {
    static Scanner sc = new Scanner(System.in);

    public static String entDados() {

        String line = sc.nextLine();

        return line;
    }

    public static String entDados(String message) {
        String leitura;
        while (true) {
            System.out.print(message);

            if ((leitura = Leitura.entDados()) != null) {
                return leitura;
            }
        }
    }

    public static float entDadosFloat(String message) {
        String leitura;
        float f;

        while (true) {
            System.out.print(message);

            if ((leitura = Leitura.entDados()) != null) {
                try {
                    f = Float.parseFloat(leitura);
                } catch (NumberFormatException e) {
                    System.out.println("Número não reconhecido. Tente novamente.");
                    continue;
                }
                return f;
            }
        }
    }

    public static int entDadosInt(String message) {
        String leitura;
        int f;

        while (true) {
            System.out.print(message);

            if ((leitura = Leitura.entDados()) != null) {
                try {
                    f = Integer.parseInt(leitura);
                } catch (NumberFormatException e) {
                    System.out.println("Número não reconhecido. Tente novamente.");
                    continue;
                }
                return f;
            }
        }
    }
}
