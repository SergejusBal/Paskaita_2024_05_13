package org.example;


import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class IntSort extends FailoBazineInformacija {


    private int[] masyvas;

    public IntSort() {
    }


    public void setMasyvas(int[] masyvas) {
        this.masyvas = masyvas;
    }

    public int[] getMasyvas() {
        return masyvas;
    }

    public static void sort(int[] array) {
        boolean swapped;
        int n = array.length;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    public static void irasytiNaujaIFaila(int[] array, String path) {
        try {
            FileWriter fileWriter = new FileWriter(path, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(int i = 0; i < array.length;i++) {
                bufferedWriter.write("" + array[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            System.err.println("Nepavyko įrašyti į failą! Klaida: " + e.getMessage());
        }
    }

    public static int[] nuskaitytiFaila(String path) {
        int[] nuskaitytosEilutes = new int[10000];
        int[] trumpasMasyvas = null;
        String line;
        int index = 0;

        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                nuskaitytosEilutes[index] = Integer.parseInt(line);
                index++;
            }

            trumpasMasyvas = new int[index];
            for(int i = 0; i < trumpasMasyvas.length;i++)  trumpasMasyvas[i] = nuskaitytosEilutes[i];

            fileReader.close();
            bufferedReader.close();

        } catch (IOException e) {
            System.err.println("Nepavyko nuskaityti failą! Klaida: " + e.getMessage());
        }
        return trumpasMasyvas;
    }

    public static String[] getFailuSarasas(String directoryPath){
        IntSort[] intSorts = listTextAndCsvFiles(directoryPath);
        String[] stringai = new String[intSorts.length];
        for (int i = 0; i < stringai.length; i ++) stringai[i] = intSorts[i].getPath();
        return stringai;
    }

    public static IntSort[] listTextAndCsvFiles(String directoryPath) {
        List<Path> fileList = new ArrayList<>();
        IntSort[] pavadinimuMasyvas = null;

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(directoryPath), "*.{txt,csv}")) {
            for (Path entry : stream) {
                try{
                    nuskaitytiFaila(entry.toString());
                }catch(NumberFormatException e){
                    continue;
                }
                fileList.add(entry);
            }

            pavadinimuMasyvas = new IntSort[fileList.size()];
            for(int i = 0; i < pavadinimuMasyvas.length;i++){
                pavadinimuMasyvas[i] = new IntSort();
                pavadinimuMasyvas[i].setPath(fileList.get(i).toString());
                pavadinimuMasyvas[i].setName(fileList.get(i).getFileName().toString());
                pavadinimuMasyvas[i].setMasyvas(nuskaitytiFaila(fileList.get(i).toString()));
                pavadinimuMasyvas[i].setFileSize(FailoBazineInformacija.getFileSizeInKB(fileList.get(i)));

            }

        } catch (IOException | DirectoryIteratorException ex) {
            System.err.println("Error occurred: " + ex.getMessage());
        }
        return pavadinimuMasyvas;
    }


}
