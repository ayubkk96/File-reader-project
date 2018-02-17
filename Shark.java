package task1;

public class Shark {

    private String sharkCommonName;
    private String latinName;
    private int maximumLength;
    private int maximumDepth;
    private String maximumNumberOfYoung;
    private int globalPresence;
    private String listOfOceanicRegions;

//Constructor
    public Shark(String sharkCommonName, String latinName, int maximumLength, int maximumDepth, String maximumNumberOfYoung, int globalPresence, String listOfOceanicRegions) {
        this.sharkCommonName = sharkCommonName;
        this.latinName = latinName;
        this.maximumLength = maximumLength;
        this.maximumDepth = maximumDepth;
        this.maximumNumberOfYoung = maximumNumberOfYoung;
        this.globalPresence = globalPresence;
        this.listOfOceanicRegions = listOfOceanicRegions;

    }

    public String getSharkCommonName() {
        return sharkCommonName;
    }

    public void setSharkCommonName(String sharkCommonName) {
        this.sharkCommonName = sharkCommonName;
    }

    public String getLatinName() {
        return latinName;
    }
//
    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public int getMaximumLength() {
        return maximumLength;
    }

    public void setMaximumLength(int maximumLength) {
        this.maximumLength = maximumLength;
    }

    public int getMaximumDepth() {
        return maximumDepth;
    }

    public void setMaximumDepth(int maximumDepth) {
        this.maximumDepth = maximumDepth;
    }

    public String getMaximumNumberOfYoung() {
        return maximumNumberOfYoung;
    }

    public void setMaximumNumberOfYoung(String maximumNumberOfYoung) {
        this.maximumNumberOfYoung = maximumNumberOfYoung;
    }

    public int getGlobalPresence() {
        return globalPresence;
    }

    public void setGlobalPresence(int globalPresence) {
        this.globalPresence = globalPresence;
    }

    public String getListOfOceanicRegions() {
        return listOfOceanicRegions;
    }

    public void setListOfOceanicRegions(String listOfOceanicRegions) {
        this.listOfOceanicRegions = listOfOceanicRegions;
    }
    
    public String toString(){
        return getSharkCommonName() + " " + getMaximumLength() + " cm.";
    }
    
    public int compareTo(Shark compareShark) {
        int compareQuantity = ((Shark) compareShark).getMaximumLength();

        //ascending order
        return this.maximumLength - compareQuantity;

        //descending order
        //return compareQuantity - this.quantity;

    }

}
