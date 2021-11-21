package com.pb.sharin.hw9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class FileNumbers {
    //==========================================================================
    //Медот createNumbersFile - создает текстовый файл "numbers.txt"
    //заполненный случайными целыми числами от 1 до 99.
    //10 строк и по 10 чисел в каждой строке. Числа разделять пробелами.
    //==========================================================================
    static void createNumbersFile() {
        Path path = Paths.get("files/numbers.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {

            for (int qtyStr = 0; qtyStr < 10; qtyStr++) {
                int[] arrayBase = new int[10];
                Random random = new Random();
                for (int qtyElem = 0; qtyElem < 10; qtyElem++) {
                    arrayBase[qtyElem] = random.nextInt(100); //(int) (Math.random() * 100);
                    if(arrayBase[qtyElem] >= 10) writer.write(arrayBase[qtyElem] + " ");
                    else writer.write("0"+arrayBase[qtyElem] + " ");
                }
                writer.newLine();
            }

        } catch (Exception ex) {
            System.out.println("Error with file write: " + ex);
        }
        System.out.println("Write to file \"" + path.toAbsolutePath() + "\" done!");
    }

    //==========================================================================
    // Метод - createOddNumbersFile - читает файл "numbers.txt",
    // и создает на основе него новый файл "odd-numbers.txt"
    // в который входят все числа из "numbers.txt" только все четные заменены на 0.
    //==========================================================================
    static void createOddNumbersFile() {
        Path pathLoad = Paths.get("files/numbers.txt");
        Path pathRes = Paths.get("files/odd-numbers.txt");
        int qtyIntReplace = 0;
        try (BufferedReader reader = Files.newBufferedReader(pathLoad);
             BufferedWriter writer = Files.newBufferedWriter(pathRes)) {

            String line;
            while ((line = reader.readLine()) != null) {
                // System.out.println(line);

                String[] strArray = line.split(" ");
                int[] intArray = new int[strArray.length];
                for (int i = 0; i < strArray.length; i++) {
                    int intVal = Integer.parseInt(strArray[i]);
                    if (intVal % 2 == 0) {
                        intArray[i] = 0;
                        qtyIntReplace++;
                    } else intArray[i] = intVal;
                    if(intArray[i]>=10) writer.write(intArray[i] + " ");
                    else writer.write("0" + intArray[i] + " ");
                }
                writer.newLine();
            }
        } catch (Exception ex) {
            System.out.println("Error with file read: " + ex);
        }
        System.out.println("Read from \"numbers.txt\" and " +
                           "Write to \"odd-numbers.txt\" is done! " +
                           "Replace " + qtyIntReplace + " values." );
    }

    //==========================================================================
    // Метод - readResultFile - читает результирующий файл "odd-numbers.txt"
    //==========================================================================
    static void readResultFile() {
        // read from file
        Path pathRes = Paths.get("files/odd-numbers.txt");
        System.out.println("--===================================================================================");
        System.out.println("Read text from file \"" + pathRes.toAbsolutePath() + "\":");
        try (BufferedReader reader = Files.newBufferedReader(pathRes)) {

            System.out.println("----------------------------------");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("----------------------------------");

        } catch (Exception ex) {
            System.out.println("Error with file read: " + ex);
        }
        System.out.println("Read from file done!");
    }

    //==========================================================================
    //Переопределение метода для считывания файла по Path
    //==========================================================================
    static void readFile(Path pathRes) {
        // read from file
        Path path = pathRes;
        System.out.println("--===================================================================================");
        System.out.println("Read text from file \"" + path.toAbsolutePath() + "\":");
        try (BufferedReader reader = Files.newBufferedReader(path)) {

            System.out.println("----------------------------------");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("----------------------------------");

        } catch (Exception ex) {
            System.out.println("Error with file read: " + ex);
        }
        System.out.println("Read from file <<" + pathRes.toString() + ">> done!");
    }

    public static void main(String[] args) {
        //=================================================
        createNumbersFile();
        //=================================================
        Path path = Paths.get("files/numbers.txt");
        readFile(path);
        //=================================================
        createOddNumbersFile();
        //=================================================
        readResultFile();

    }
}
