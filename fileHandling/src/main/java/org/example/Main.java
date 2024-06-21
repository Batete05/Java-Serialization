package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.print(" enter absolute path of file you want to read its content : ");
//        String path = scanner.nextLine();
        File file = new File("content.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            ArrayList<String> sentence = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String reversedLine = new StringBuilder(line).reverse().toString();

                sentence.add(reversedLine);
            }
            System.out.print(" enter  name of new file you want to create : ");
            String fileName = scanner.nextLine();
            FileWriter myWriter = new FileWriter(fileName);
            for (String word : sentence) {
                myWriter.write(word);
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}