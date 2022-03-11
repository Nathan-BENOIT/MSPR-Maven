package fr.epsi;

import fr.epsi.generators.GenerateAccueil;
import fr.epsi.tools.MyThread;
import fr.epsi.tools.Parsing;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<String> listEmployes = Parsing.StaffParsing();

        Runnable runnable = new MyThread();
        Thread thread = new Thread(runnable);
        thread.start();

        GenerateAccueil.generateHtmlFileAccueil();
    }
}
