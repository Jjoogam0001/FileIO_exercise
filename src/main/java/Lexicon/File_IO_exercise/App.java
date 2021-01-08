package Lexicon.File_IO_exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            CreateFile("newfile.txt");
            WriteToFile("newfile.txt", "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                    " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Accumsan lacus vel facilisis" +
                    " volutpat est. Tincidunt dui ut ornare lectus sit amet. Morbi tincidunt ornare massa eget egestas purus viverra accumsan."
                    );

            ReadFile("newfile.txt");
            //Task 2
            bufferedwriterlIST("newfile2.txt");
            List<String> names = new ArrayList<>();
            readBuffrdlinesintoList(names, "newfile2.txt");
            //Task 3
            List<String> strgs = new ArrayList<>();
            strgs.add("I");
            strgs.add("Love");
            strgs.add("You");
            writeStringObjects(strgs, "newfile3.txt");
            //Task 4
            File oldLocation = new File(
                    "C:\\Users\\Martin Mujemya J\\Desktop\\FileIO_exercise\\newfile.txt");
            File newLocation = new File("C:\\Users\\Martin Mujemya J\\Desktop\\FileIO_exercise\\target\\resources\\outedfiled.txt");
            copyFileToAnotherDirectory(oldLocation,newLocation);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void CreateFile(String filename) throws IOException {
        File file = new File(filename);
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
        } else {
            System.out.println("File already exists.");
        }

    }

    private static void WriteToFile(String filename, String randomText) throws IOException {
        FileWriter myWriter = new FileWriter(filename);
        myWriter.write(randomText);
        myWriter.close();
        System.out.println("Successfully wrote to the file.");

    }

    private static void ReadFile(String filepath) throws IOException {
        FileReader fr = new FileReader(filepath);
        int i;
        while ((i = fr.read()) != -1)
            System.out.print((char) i);
    }

    private static void bufferedwriterlIST(String filename) throws IOException {
        String name;
        FileWriter writer = new FileWriter(filename, true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        for (int i = 0; i < 10; i++) {
            name = input.nextLine();
            bufferedWriter.write(name);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    private static void readBuffrdlinesintoList(List<String> names, String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            names.add(line);
            for (int i = 0; i < names.size(); i++) {
                System.out.println(names.get(i));

            }
        }
    }

    private static void writeStringObjects(List<String> objects, String filename) throws IOException {
        FileOutputStream writeData = new FileOutputStream(filename);
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
        writeStream.writeObject(objects);
        writeStream.flush();
        writeStream.close();
    }

    private static void copyFileToAnotherDirectory(File oldLocation, File newLocation) throws IOException {
        byte[] buffer = new byte[100000];
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        bufferedInputStream = new BufferedInputStream(new FileInputStream(oldLocation));
        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(newLocation));
        int size;
        while ((size = bufferedInputStream.read(buffer)) > -1)
        {
            bufferedOutputStream.write(buffer, 0, size);
        }




    }
}