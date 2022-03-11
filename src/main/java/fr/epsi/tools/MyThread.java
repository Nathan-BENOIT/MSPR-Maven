package fr.epsi.tools;

import fr.epsi.generators.GenerateFicheEmploye;

public class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < Parsing.listEmployes.size(); i++) {
            try {
                GenerateFicheEmploye.generateHtmlFileEmploye(Parsing.listEmployes.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
