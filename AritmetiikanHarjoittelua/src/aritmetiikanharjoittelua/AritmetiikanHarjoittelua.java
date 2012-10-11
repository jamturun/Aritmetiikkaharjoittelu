package aritmetiikanharjoittelua;


import gui.GraafinenOhjelma;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import tekstikayttoliittyma.Tekstikayttoliittyma;

/**
 * 
 * @author jamturun
 * @version 1.1
 * 
 * Pääluokka, joka luo graafisen ohjelman.
 */
public class AritmetiikanHarjoittelua {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        GraafinenOhjelma ohjelma = new GraafinenOhjelma();
        SwingUtilities.invokeLater(ohjelma);

    }
}