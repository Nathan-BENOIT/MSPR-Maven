package fr.epsi.generators;

import fr.epsi.tools.Parsing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateAccueil {

    public static void generateHtmlFileAccueil() throws IOException {

        List<String> listEmployes;

        File htmlSortant = new File("src/main/resources/index.html");
        FileWriter htmlWriter = new FileWriter(htmlSortant);

        try {
            listEmployes = Parsing.StaffParsing();

            htmlSortant.getParentFile().mkdirs();

            htmlWriter.write("<html>");
            htmlWriter.write("\n");
            htmlWriter.write("<head>");
            htmlWriter.write("\n");
            htmlWriter.write("<title>Go Secury | Accueil gestion des agents");
            htmlWriter.write("</title>");
            htmlWriter.write("\n");
            htmlWriter.write("<link rel='icon' href='assets/icon.png' type='image/x-icon'>");
            htmlWriter.write("\n");
            htmlWriter.write("<link href='CSS/style.css' rel='stylesheet'>");
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
            htmlWriter.write("<li><img src='assets/logo.png' alt='Logo'></li>");
            htmlWriter.write("\n");
            htmlWriter.write("</ul>");
            htmlWriter.write("\n");
            htmlWriter.write("<div class='Entete'>");
            htmlWriter.write("\n");
            htmlWriter.write("<img src='assets/logo.png' alt='Logo'>");
            htmlWriter.write("\n");
            htmlWriter.write("<h1>Portail de gestion des agents");
            htmlWriter.write("</h1>");
            htmlWriter.write("\n");
            htmlWriter.write("<h1>Accueil");
            htmlWriter.write("</h1>");
            htmlWriter.write("\n");
            htmlWriter.write("</div>");
            htmlWriter.write("\n");
            htmlWriter.write("<div class='listeEmployes'>");
            htmlWriter.write("\n");

            for (int i = 0; i < listEmployes.size(); i++) {
                List<String> listAgent = Parsing.personalParsing(listEmployes.get(i));
                htmlWriter.write("<a href='HTML/fiche_employe_" + listEmployes.get(i) + ".html' class='texte'>" + listAgent.get(1) + " " + listAgent.get(0) + "</a></br></br>");
                htmlWriter.write("\n");
            }

            htmlWriter.write("</div>");
            htmlWriter.write("\n");
            htmlWriter.write("</body>");
            htmlWriter.write("\n");
            htmlWriter.write("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            htmlWriter.close();
        }
    }
}
