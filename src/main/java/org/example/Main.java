package org.example;

public class Main {
    public static void main(String[] args) {

        final String ORIGINALPATH = "C:/Users/Sergejus/IdeaProjects//Paskaita_2024_05_13/src/main/java/org/example/Skaiciai.csv";
        final String ORDERPATH = "C:/Users/Sergejus/IdeaProjects//Paskaita_2024_05_13/src/main/java/org/example/OrderedSkaiciai.csv";
        final String STRINGORIGINAL ="C:/Users/Sergejus/IdeaProjects/Paskaita_2024_05_13/src/main/java/org/example/StringValues.csv";
        final String ORDERSTRINGORIGINAL ="C:/Users/Sergejus/IdeaProjects/Paskaita_2024_05_13/src/main/java/org/example/OrderStringValues.csv";

        final String DIRECTORY = "C:/Users/Sergejus/IdeaProjects//Paskaita_2024_05_13/src/main/java/org/example";


        //////////////////////////////////////////////////////////////////
        // Skaiciu rusiavimas
        int [] skaiciai = IntSort.nuskaitytiFaila(ORIGINALPATH);
        for(int i : skaiciai)  System.out.println(i);

        IntSort.sort(skaiciai);
        System.out.println("Sorted");
        for(int i : skaiciai)  System.out.println(i);
        IntSort.irasytiNaujaIFaila(skaiciai,ORDERPATH);
        ////////////////////////////////////////////////////////////////////
        // visu failu nuskaitymas

        String[] StringFailaiPATH = IntSort.getFailuSarasas(DIRECTORY);

        System.out.println();
        System.out.println("Directory List:");
        for(String s : StringFailaiPATH){
            System.out.println(s);
        }

        IntSort[] failai = IntSort.listTextAndCsvFiles(DIRECTORY);
        System.out.println();
        System.out.println("Nuskaityti:");
        for(IntSort p : failai) {
           System.out.println(p.getName());
           System.out.println(p.getFileSize());
           for (int i : p.getMasyvas()) System.out.print(i + " ");
           System.out.println();
           System.out.println("***********************************************************");

        }
        ////////////////////////////////////////////////////////////

        System.out.println();
        System.out.println("String darbas");
        String [] stringai = StringSort.nuskaitytiFaila(STRINGORIGINAL);

        for(String i : stringai)  System.out.println(i);

        StringSort.sort(stringai);
        System.out.println("Sorted");
        for(String i : stringai)  System.out.println(i);
        StringSort.irasytiNaujaIFaila(stringai,ORDERSTRINGORIGINAL);

        ////////////////////////////////////////////////////////////////

        String[] StringStringPath = StringSort.getFailuSarasas(DIRECTORY);

        System.out.println();
        System.out.println("String Directory List:");
        for(String s : StringStringPath){
            System.out.println(s);
        }

        StringSort[] StringFailai = StringSort.listTextAndCsvFiles(DIRECTORY);
        System.out.println();
        System.out.println("Nuskaityti:");
        for(StringSort p : StringFailai) {
            System.out.println(p.getName());
            System.out.println(p.getPath());
            System.out.println(p.getFileSize());
            for (String s : p.getMasyvas()) System.out.print(s + " ");
            System.out.println();
            System.out.println("***********************************************************");

        }


    }


}