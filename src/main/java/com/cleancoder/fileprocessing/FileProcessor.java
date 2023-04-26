package com.cleancoder.fileprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

public class FileProcessor
{
    public static void processLines(File inputFile, Consumer<String> businessMethod) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                businessMethod.accept(line);
            }
        }
        catch (IOException e)
        {
            System.err.println("An error happened while reading file : " + inputFile.getName() + ", " + e.getMessage());
        }
    }
}
