
import java.io.*;
import java.util.*;

public class Task2 {

    public static ArrayList<Shark> readThroughTheFileAndAddShark() {
        ArrayList<Shark> sharkList = new ArrayList<>();
        //creating the file and its path
        File file = new File("shark-data.txt");
        Scanner sc;
        try {
            sc = new Scanner(file);
            //scanner instruction to read the file line by line
            while (sc.hasNextLine()) {
                String lines = sc.nextLine();//read all the lines in the file
                //split the line by ':' so that it can read each array by its own
                String line[] = lines.split(":");
                int maximumLength = -1;
                try {
                    maximumLength = Integer.parseInt(line[2]);
                } catch (Exception e) {
                }
                int maximumDepth = -1;
                try {
                    maximumDepth = Integer.parseInt(line[3]);
                } catch (Exception e) {
                }
                int maximumNumberOfYoung = -1;
                try {
                    maximumNumberOfYoung = Integer.parseInt(line[4]);
                } catch (Exception e) {
                }
                int globalPresence = Integer.parseInt(line[5]);
                //this shark object will hold the information received from scanning the file
                Shark shark = new Shark(line[0], line[1], maximumLength, maximumDepth, maximumNumberOfYoung, globalPresence, line[6].split(","));
                sharkList.add(shark);//add object in 
            }

        } catch (Exception e) {
            System.out.println("Something is wrong with the line scanning");
        }
        return sharkList;
    }
    
    
    
    public static void main(String[] args) {
        ArrayList<Shark> sharkList = 
                readThroughTheFileAndAddShark();
        //Protocol for the file to exit if there is nothing more to be read
        if (sharkList == null) {
            System.exit(0);
        } 
        //treeMap to sort the sharks to their respected regions
        Map<String, ArrayList<String>> listofregionMap = new TreeMap<>();
        sharkList.forEach((Shark sharkobject) -> {
            String[] listofregions = sharkobject.getListOfOceanicRegions();
            for (String region : listofregions) {
                ArrayList<String> sharks = listofregionMap.get(region.trim());
                if (sharks == null) {
                    sharks = new ArrayList<>();
                }
                sharks.add(sharkobject.getSharkCommonName());
                listofregionMap.put(region.trim(), sharks);
            }
        });
//Write input into results.txt
        FileWriter result;
        try {
            result = new FileWriter("results.txt"); 
            for (Map.Entry<String, ArrayList<String>> listofregionEntry : listofregionMap.entrySet()) {
                String listofregion = listofregionEntry.getKey();
                ArrayList<String> sharks = listofregionEntry.getValue();
                Collections.sort(sharks);
                
                System.out.println("These are the type of sharks that roam this region.");
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println(listofregion + " -> " + sharks);
                result.write("These are the type of sharks that roam this region.");
                result.write("-------------------------------------------------------------------------------");
                result.write(listofregion + " -> " + sharks + "\r\n");
            }
            result.close();
        } catch (IOException e) {
            System.out.println("An error has occured with the FileWriter");
        }

    }

    

}
