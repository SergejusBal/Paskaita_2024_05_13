package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FailoBazineInformacija {

    private String name;
    private String path;
    private String fileSize;


    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getFileSize() {
        return fileSize;
    }


    public static String getFileSizeInKB(Path path) {
        try {
            long sizeInBytes = Files.size(path);
            long sizeInKB = sizeInBytes / 1024;
            return sizeInKB + " KB";
        } catch (IOException e) {
            System.err.println("Unable to determine file size: " + e.getMessage());
            return "Error";
        }
    }

}
