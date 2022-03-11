package fr.epsi.tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Parsing {

    public static final ArrayList<String> listEmployes = new ArrayList<>();

    public static ArrayList<String> StaffParsing() {
        FileReader fileReader = null;
        BufferedReader read = null;

        File file = new File("src/main/resources/txt/staff.txt");

        try {
            fileReader = new FileReader(file);
            read = new BufferedReader(fileReader);
            String line;
            listEmployes.clear();
            while ((line = read.readLine()) != null) {
                listEmployes.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                read.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listEmployes;
    }

    public static final List<String> stuffLabel = new ArrayList<>();
    public static final List<String> stuffCode = new ArrayList<>();

    public static void listeParsing() {
        FileReader fileReader = null;
        BufferedReader read = null;

        File file = new File("src/main/resources/txt/liste.txt");

        try {
            fileReader = new FileReader(file);
            read = new BufferedReader(fileReader);
            String line;
            stuffLabel.clear();
            stuffCode.clear();
            while ((line = read.readLine()) != null){
                String[] tabl = line.split("    ");
                stuffCode.add(tabl[0]);
                stuffLabel.add(tabl[1]);
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                read.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> personalParsing(String nom) {
        FileReader fileReader = null;
        BufferedReader read = null;

        List<String> listAgent = new ArrayList<>();

        File file = new File("src/main/resources/txt/" + nom  + "/" + nom + ".txt");

        try {
            fileReader = new FileReader(file);
            read = new BufferedReader(fileReader);

            String line;
            listAgent.clear();
            while ((line = read.readLine()) != null){
                listAgent.add(line);
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                read.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listAgent;
    }

    public static List<String> getInfo(String nom) {
        List<String> listeAgent = personalParsing(nom);

        int index = 0;
        for(int i = 0; i < 4; i++){
            listeAgent.remove(index);
        }
        return listeAgent;
    }

    public static final ArrayList<String> isChecked = new ArrayList<>();

    public static ArrayList<String> compareMatos(String nom) {
        List<String> matosAgent = getInfo(nom);
        List<String> allMatos = stuffCode;
        String isStringChecked = "checked";

        isChecked.clear();
        for(int i = 0; i < allMatos.size(); i++){
            if(matosAgent.contains(allMatos.get(i))){
                isChecked.add(isStringChecked);
            } else {
                isChecked.add("");
            }
        }
        return isChecked;
    }

    public static final class globals {
        public static String staffList;
        public static String agentSheet;
    }
}


