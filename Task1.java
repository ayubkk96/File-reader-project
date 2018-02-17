/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

import java.io.*;
import java.util.*;

public class Task1 {

    static ArrayList<Shark> sharkList = new ArrayList<Shark>();
    static ArrayList<Integer> maxLengths = new ArrayList<>();

    public static void main(String[] args) {
        //File type path
        File file = new File("shark-data.txt");

        File results = new File("results.txt");

        //Try catch clause in case BufferedReader falls over
        try (BufferedReader br = new BufferedReader(new FileReader(file)); PrintWriter printOutput = new PrintWriter(results)) {
            String line;
            //loop through until there is no longer a next line in file
            while ((line = br.readLine()) != null) {
                //split string by delimiter
                String[] lineSplit = line.split(":");

                //set vars to array indexes in order
                String sharkCommonName = lineSplit[0];
                String latinName = lineSplit[1];
                int maximumLength = Integer.parseInt(lineSplit[2]);
                int maximumDepth = Integer.parseInt(lineSplit[3]);
                String maximumNumberOfYoung = lineSplit[4];
                int globalPresence = Integer.parseInt(lineSplit[5]);
                String listOfOceanicRegions = lineSplit[6];

                //create shark object for new line
                Shark shark = new Shark(sharkCommonName, latinName, maximumLength, maximumDepth, maximumNumberOfYoung, globalPresence, listOfOceanicRegions);

                //add the shark object into the list
                sharkList.add(shark);
                maxLengths.add(maximumLength);

                //sort sharkList collection by max length
                Collections.sort(sharkList, new Comparator<Shark>() {
                    @Override
                    public int compare(Shark s1, Shark s2) {
                        return s2.getMaximumLength() - (s1.getMaximumLength());
                    }
                });
            }

            printLargestThreeSharksByLength(printOutput);
            printShortestThreeSharksByLength(printOutput);
            printTotalNumberOfLatinChars(printOutput);
            printNoOfOddAndEvenUniqueLatinNames(printOutput);

            printOutput.close();
        } catch (Exception e) {
            System.out.println("There is something wrong, stacktrace below");
            e.printStackTrace();
        }
    }

    // Print top 3 longest sharks
    public static void printLargestThreeSharksByLength(PrintWriter printOutput) {
        System.out.println("------ Three largest sharks ------");
        printOutput.println("------ Three largest sharks ------");
        for (int i = 0; i < 3; i++) {
            System.out.println(sharkList.get(i).toString());
            printOutput.println(sharkList.get(i).toString());
        }
    }

    //Print top 3 shortest sharks
    public static void printShortestThreeSharksByLength(PrintWriter printOutput) {
        System.out.println("------ Three smallest sharks ------");
        printOutput.println("------ Three smallest sharks ------");
        for (int i = sharkList.size() - 1; i > sharkList.size() - 4; i--) {
            System.out.println(sharkList.get(i).toString());
            printOutput.println(sharkList.get(i).toString());
        }
    }
    
    
    //Print total number of latin characters
    public static void printTotalNumberOfLatinChars(PrintWriter printOutput) {
        int counter = 0;
        for (Shark shark : sharkList) {
            String sharkLatinNameWithoutSpace = shark.getLatinName().replaceAll(" ", "");
            counter += sharkLatinNameWithoutSpace.length();

        }
        System.out.println("Total number of letters in Latin names = " + counter);
        printOutput.println("Total number of letters in Latin names = " + counter);
    }

    public static void printNoOfOddAndEvenUniqueLatinNames(PrintWriter printOutput) {
        System.out.println("-------------------------------------");
        printOutput.println("------------------------------------");
        HashSet<String> totalOfUniquewords = new HashSet<String>();
        
        for (int i = 0; i < sharkList.size(); i++) {
            for (String s : sharkList.get(i).getLatinName().split(" ")) {
                totalOfUniquewords.add(s);

            }
        }
        int evenCount = 0;
        int oddCount = 0;

        for (String word : totalOfUniquewords) {
            if (word.length() % 2 == 0) {
                evenCount += 1;
            } else {
                oddCount += 1;
            }
        }
        System.out.println("The total number of unique even words is:" + " " + evenCount);
        printOutput.println("The total number of unique even words is:" + " " + evenCount);
        System.out.println("The total number of unique odd words is:" + " " + oddCount);
        printOutput.println("The total number of unique odd words is:" + " " + oddCount);
    }

}
