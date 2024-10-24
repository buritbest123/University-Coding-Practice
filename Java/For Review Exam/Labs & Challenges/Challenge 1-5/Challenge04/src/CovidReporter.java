// 6488079 Burit Sihabut
public class CovidReporter {


    public static void main(String[] args) {
	    CovidProfile CovidCase1 = new CovidProfile(); // reference by create a reference variable (CovidCase1)

        // Instantiated by new CovidProfile() and set all the values using setter methods
        CovidCase1.setDate("2021-01-27");
        CovidCase1.setLocation("United States");
        CovidCase1.setAccumulatedCases(37939641);
        CovidCase1.setCuredCases(0);
        CovidCase1.setDeathCases(629411);

        CovidProfile CovidCase2 = new CovidProfile("2021-01-27","Thailand",2407022,2302164,22098);
        // Instance variables (_date,loc,noAcc,noCured,noDeath)

        // Print the information of those objects by calling their printCovidInfo() method.
        CovidCase1.printCovidInfo();
        System.out.println("___________________________________");
        CovidCase2.printCovidInfo();
        System.out.println("There are "+CovidProfile.count_profile+" countries");
    }
}