package aritmetiikanharjoittelua;

import gui.AritmetiikanHarjoitteluaUI;
import gui.GraafinenOhjelma;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.*;
import tekstikayttoliittyma.Tekstikayttoliittyma;

public class AritmetiikanHarjoittelua {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        GraafinenOhjelma ohjelma = new GraafinenOhjelma();
        SwingUtilities.invokeLater(ohjelma);

    }
}