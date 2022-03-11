import java.util.ArrayList;
import Generate.GenerateAccueil;
import Parsing.Parsing;

public class Main {
    public static void main(String[] args) throws Exception {

        ArrayList<String> listEmployes = Parsing.StaffParsing();
        
        /*for (int i = 0; i < listEmployes.size(); i++) {
            GenerateFicheEmploye.generateHtmlFileEmploye(listEmployes.get(i));
        }*/

        Runnable runnable = new MyThread();
        Thread thread = new Thread(runnable);
        thread.start();

        GenerateAccueil.generateHtmlFileAccueil();
    }
}