package de.neuefische;

import com.github.lalyos.jfiglet.FigletFont;

public class Main {
    public static void main(String[] args) {
        try {
            String asciiArt = FigletFont.convertOneLine("Password Validator & Generator");
            System.out.println(asciiArt);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}