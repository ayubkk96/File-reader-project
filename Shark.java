public class Shark {

    private String sharkCommonName;
    private String latinName;
    private int maximumLength;
    private int maximumDepth;
    private int maximumNumberOfYoung;
    private int globalPresence;
    private String listOfOceanicRegions[];
    
    
    //Constructor
    public Shark(String sharkCommonName, String latinName, int maximumLength, int maximumDepth, int maximumNumberOfYoung, int globalPresence, String[] listOfOceanicRegions) {
        this.sharkCommonName = sharkCommonName;
        this.latinName = latinName;
        this.maximumLength = maximumLength;
        this.maximumDepth = maximumDepth;
        this.maximumNumberOfYoung = maximumNumberOfYoung;
        this.globalPresence = globalPresence;
        this.listOfOceanicRegions = listOfOceanicRegions;
    }

    public Shark() {
    }

    public String getSharkCommonName() {
        return sharkCommonName;
    }


    public void setSharkCommonName(String name) {
        this.sharkCommonName = sharkCommonName;
    }


    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }


    public int getMaximumLength() {
        return maximumLength;
    }

    public void setMaximumlength(int maximumlength) {
        this.maximumLength = maximumlength;
    }


    public int getMaximumDepth() {
        return maximumDepth;
    }

    public void setMaxDepth(int maximumDepth) {
        this.maximumDepth = maximumDepth;
    }

  
    public int getMaximumNumberOfYoung() {
        return maximumNumberOfYoung;
    }

    public void setMaxNumberLifetime(int maximumNumberOfYoung) {
        this.maximumNumberOfYoung = maximumNumberOfYoung;
    }

    public int getGlobalPresence() {
        return globalPresence;
    }

    public void setGlobalPresence(int globalPresence) {
        this.globalPresence = globalPresence;
    }

    public String[] getListOfOceanicRegions() {
        return listOfOceanicRegions;
    }

    public void setListOfOceanicRegions(String[] listOfOceanicRegions) {
        this.listOfOceanicRegions = listOfOceanicRegions;
    }

    @Override
    public String toString() {
        return sharkCommonName + " " + getMaximumLength() + " cm.";
    }
    
    public int compareTo(Shark compareShark) {
        int compareQuantity = ((Shark) compareShark).getMaximumLength();

        //ascending order
        return this.maximumLength - compareQuantity;

        //descending order
        //return compareQuantity - this.quantity;


}
    
}
