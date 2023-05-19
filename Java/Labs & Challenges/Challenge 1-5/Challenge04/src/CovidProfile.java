// 6488079 Burit Sihabut
public class CovidProfile { // Create a class CovidProfile to store the following attributes
        private String date; // date/time of the data, e.g., “2020-01-18”
        private String location; // : location where the data are collected, e.g., “Thailand”
        private int accumulatedCases; // the number of accumulated infected patients, e.g., 17023
        private int curedCases; // the number of cured cases, e.g., 11396
        private int deathCases; // the number of dead patients, e.g., 76
        public static int count_profile = 0;
        // every called +1 count_profile
        {
            count_profile+=1;
        }

        public CovidProfile() { //Constructor
            // This method set default values as: “none”, “none”, 0, 0, 0.
            date = "none";
            location = "none";
            accumulatedCases = 0;
            curedCases = 0;
            deathCases = 0;
        }

        public CovidProfile(String _date, String loc, int noACC, int noCured, int noDeath) { //Constructor
            // This method takes input parameters and assigns them to each corresponding attribute.

            date = _date;
            location = loc;
            accumulatedCases = noACC;
            curedCases = noCured;
            deathCases = noDeath;
        }

        //setters
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

        //getters
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
             System.out.println(location + " at: " + this.date + "\nAccumulative Patient: " + this.accumulatedCases + "\nCured Patient: " + this.curedCases + "\nDeath Case: " + this.deathCases+"\nDifferent Cured and Death: "+Diff_Current());
            if(isSevere()) {
                System.out.println("(Severe)");
            } else {
                System.out.println("(Not severe)");
            }
        }

        public boolean isSevere() {
            return deathCases > 10000;
        }

        public int Diff_Current(){
            return accumulatedCases = curedCases - deathCases;
        }
    }