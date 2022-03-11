package fr.epsi.generators;

import fr.epsi.tools.Parsing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerateFicheEmploye {

    public static void generateHtmlFileEmploye(String nom) throws IOException {

        String filePath = String.format("src/main/resources/HTML/fiche_employe_%s.html", nom);

        List<String> listAgent;


        File htmlSortant = new File(filePath);
        FileWriter htmlWriter = new FileWriter(htmlSortant);

        try {
            listAgent = Parsing.personalParsing(nom);
            Parsing.listeParsing();
            ArrayList<String> matosIsChecked = Parsing.compareMatos(nom);

            htmlSortant.getParentFile().mkdirs();

            htmlWriter.write("<html>");
            htmlWriter.write("\n");
            htmlWriter.write("<head>");
            htmlWriter.write("\n");
            htmlWriter.write("<title>Go Secury | Accueil gestion des agents");
            htmlWriter.write("</title>");
            htmlWriter.write("\n");
            htmlWriter.write("<link rel='icon' href='../assets/icon.png' type='image/x-icon'>");
            htmlWriter.write("\n");
            htmlWriter.write("<link href='../CSS/style.css' rel='stylesheet'>");
            htmlWriter.write("\n");
            htmlWriter.write("<link rel='preconnect' href='https://fonts.googleapis.com'>");
            htmlWriter.write("\n");
            htmlWriter.write("<link rel='preconnect' href='https://fonts.gstatic.com' crossorigin>");
            htmlWriter.write("\n");
            htmlWriter.write("<link href='https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap' rel='stylesheet'>");
            htmlWriter.write("\n");
            htmlWriter.write("</head>");
            htmlWriter.write("\n");
            htmlWriter.write("<body>");
            htmlWriter.write("\n");
            htmlWriter.write("<ul>");
            htmlWriter.write("\n");
            htmlWriter.write("<li><img src='../assets/logo.png' alt='Logo'></li>");
            htmlWriter.write("\n");
            htmlWriter.write("<li><a href='../index.html' class='accueil'>Accueil</a></li>");
            htmlWriter.write("\n");
            htmlWriter.write("</ul>");
            htmlWriter.write("\n");
            htmlWriter.write("<div class='Entete'>");
            htmlWriter.write("\n");
            htmlWriter.write("<img src='../assets/logo.png' alt='Logo'>");
            htmlWriter.write("\n");
            htmlWriter.write("<h1>Fiche employe");
            htmlWriter.write("</h1>");
            htmlWriter.write("\n");
            htmlWriter.write("<img src='../assets/" + nom + ".png' alt='Id'>");
            htmlWriter.write("\n");
            htmlWriter.write("<p class='texte'>" + listAgent.get(1) + " " + listAgent.get(0) + "</p>");
            htmlWriter.write("\n");
            htmlWriter.write("<p class='texte'>" + listAgent.get(2) + "</p>");
            htmlWriter.write("\n");
            for (int i = 0; i < Parsing.stuffLabel.size(); i++) {
                htmlWriter.write("<div class=''>");
                htmlWriter.write("\n");
                htmlWriter.write("<br>");
                htmlWriter.write("\n");
                htmlWriter.write("<input type='checkbox' class='checkbox' disabled " + matosIsChecked.get(i) + ">");
                htmlWriter.write("\n");
                htmlWriter.write("<label class='texte liste'>" + Parsing.stuffLabel.get(i) + "</label>");
                htmlWriter.write("\n");
                htmlWriter.write("</div>");
                htmlWriter.write("\n");
            }
            htmlWriter.write("\n");
            htmlWriter.write("</div>");
            htmlWriter.write("\n");
            htmlWriter.write("<div class=''>");
            htmlWriter.write("\n");
            htmlWriter.write("</div>");
            htmlWriter.write("\n");
            htmlWriter.write("</body>");
            htmlWriter.write("\n");
            htmlWriter.write("</html>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            htmlWriter.close();
        }
    }
}
