// 6488079 Burit Sihabut

public class CovidProfile { // Create a class CovidProfile to store the following attributes
    private String date; // date/time of the data, e.g., “2020-01-18”
    private String location; // : location where the data are collected, e.g., “Thailand”
    private int accumulatedCases; // the number of accumulated infected patients, e.g., 17023
    private int curedCases; // the number of cured cases, e.g., 11396
    private int deathCases; // the number of dead patients, e.g., 76

    public CovidProfile() { // Constructor
        // This method set default values as: “none”, “none”, 0, 0, 0.
        date = "none";
        location = "none";
        accumulatedCases = 0;
        curedCases = 0;
        deathCases = 0;
    }

    public CovidProfile(String _date, String loc, int noACC, int noCured, int noDeath) { //Constructor
        // This method takes input parameters and assigns them to each corresponding attribute.
        // If you want to use same name. YOU Need TO USE KEYWORD "this." e.g. this.date = date

        date = _date;
        location = loc;
        accumulatedCases = noACC;
        curedCases = noCured;
        deathCases = noDeath;

    }

    //setters method "void"
    public void setDate(String _date) {
        date = _date;
    }

    public void setLocation(String loc) {
        location = loc;
    }

    public void setAccumulatedCases(int people) {
        accumulatedCases = people;
    }

    public void setCuredCases(int people) {
        curedCases = people;
    }

    public void setDeathCases(int people) {
        deathCases = people;
    }

    //getters method means return ค่านั้น
    // Warning don't use static on getters because programs will get confuse
    // You cas use in main, but you must call by use name.get...
    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public int getACC() {
        return accumulatedCases;
    }

    public int getCured() {
        return curedCases;
    }

    public int getDeath() {
        return deathCases;
    }

    public void printCovidInfo(){
        System.out.println(location + " at: " + date + "\nAccumulative Patient: " + accumulatedCases + "\nCured Patient: " + curedCases + "\nDeath Case: " + deathCases);
    }
}