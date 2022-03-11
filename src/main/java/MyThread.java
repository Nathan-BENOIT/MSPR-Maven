import Generate.GenerateFicheEmploye;

import static Parsing.Parsing.listEmployes;

public class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread running");
        for (int i = 0; i < listEmployes.size(); i++) {
            try {
                GenerateFicheEmploye.generateHtmlFileEmploye(listEmployes.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
