
import java.io.*;
import java.util.*;

public class Task3 {

   

    public static ArrayList<Shark> readThroughFileAndAddShark() {
        ArrayList<Shark> sharkList = new ArrayList<>();
        
 File file = new File("shark-data.txt");
 
        Scanner sc;//read the file
        try {
            sc = new Scanner(file);
            //read the file by each line
            while (sc.hasNextLine()) {
                String lines = sc.nextLine();//read line
                //split line by ":"
                String line[] = lines.split(":");
                //set vars to array indexes in order
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
                
                //create new shark object
                Shark shark = new Shark(line[0], line[1], maximumLength, maximumDepth, maximumNumberOfYoung, globalPresence, line[6].split(","));
                sharkList.add(shark);//add this shark object into the arraylist
            }

        } catch (FileNotFoundException e) {
            System.out.println("There is something wrong.");
        }
        return sharkList;
    }

    
    public static Map<String, String> match(ArrayList<Shark> sharkList, String searchStr) {
        
        Map<String, String> result = new TreeMap<>();
        sharkList.forEach((Shark shark) -> {
            String latinName = shark.getLatinName();
            if (latinName.toLowerCase().contains(searchStr.toLowerCase())) {  
                int index = 0;
                while ((index = latinName.toLowerCase().indexOf(searchStr.toLowerCase(), index)) != -1) {
                    latinName = latinName.substring(0, index) + searchStr.toUpperCase() + latinName.substring(index + searchStr.length());
                    index++;
                }
                result.put(shark.getSharkCommonName(), latinName);
            }
        });
        return result;
    }
     public static void main(String[] args) {
        ArrayList<Shark> sharkList = readThroughFileAndAddShark();
     
        if(sharkList==null){
            System.exit(0);
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter search string for Latin names: > ");
        String searchStr = sc.nextLine();
        
        System.out.println("You entered string \""+searchStr+"\"");
        System.out.println("The following matches have been found:-");
        Map<String,String> matchedName=match(sharkList, searchStr);
        matchedName.entrySet().forEach((entry) -> {
            String sharkCommonName = entry.getKey();
            String latinName;
            latinName = entry.getValue();
            System.out.println(sharkCommonName+" - Latin name: "+latinName);
        });
    }
    
}
