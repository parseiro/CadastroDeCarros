package LeonardoVilelaPinheiro_Atividade08.janelas;

import java.awt.*;

public class ListFonts {
    public static void main(String... args) {
        String[] fontNames = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();

        for (final String font : fontNames) {
            System.out.println(font);
        }
    }
}
