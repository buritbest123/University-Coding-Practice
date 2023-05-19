import java.util.Scanner; // Import Input Scanner

public class ParkingTicket {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Input enter parking and Input leaving parking
        String entering_time = in.nextLine();
        System.out.println("Entering time -> "+ entering_time);
        String leaving_time = in.nextLine();
        System.out.println("Leaving time -> "+ leaving_time);
         // Scan 2 things with datatype (int)
        ParkingTicket.printParkingDuration(entering_time,leaving_time); // Sending 2 variable to method printParkingDuration
    }

    public static void printParkingDuration (String enterTime, String leaveTime) {
        // Strings Conversion ex. Convert to number (String to Int)
        int entering_Time = Integer.parseInt(enterTime), entering_Time2 = Integer.parseInt(enterTime);
        //ex. 950 / 100 = 9 and 950 % 100 = 50
        int entering_hour = entering_Time / 100, entering_minute = entering_Time2 % 100;

        // Strings Conversion ex. Convert to number
        int leaving_Time = Integer.parseInt(leaveTime), leaving_Time2 = Integer.parseInt(leaveTime);
        // ex. 1715 / 100 = 17 and 1715 % 100 = 15
        int leaving_hour = leaving_Time / 100, leaving_minute = leaving_Time2 % 100;

        // Same Day
        if (entering_hour < leaving_hour) { // ex. 9 < 17 hours
            if (entering_minute > leaving_minute) { // ex. 50 > 15 minute
                leaving_hour -= 1; // ex. 17 - 1 = 16 do this leaving_hour
                leaving_minute += 60; // ex. 15 + 60 = 75 do this leaving_minute
                int Difference_hour = leaving_hour - entering_hour, Difference_minute = leaving_minute - entering_minute;
                // ex. 16 - 9 = 7 hour and // ex. 75 - 50 = 25 minutes

                // Print Task 1 Different hours and minute
                System.out.println("Parking duration: " + Difference_hour + " hours and " + Difference_minute + " minutes");
                task2_pure(Difference_hour,Difference_minute);
            }
        } else { // Not Same Day (Overnight)
            if (entering_minute > leaving_minute) {
                leaving_hour -= 1;
                leaving_minute += 60;
            }
            int overnight_hour = Math.abs((entering_hour - leaving_hour) - 24); // ex. |((17-9)-24)| = 16
            int overnight_minute = Math.abs((entering_minute-leaving_minute)); // ex. |(15-50)| = 35

            System.out.println("Entering time -> "+ enterTime);
            System.out.println("Leaving time -> "+ leaveTime + " (overnight)");
            System.out.println("Parking duration: " +overnight_hour+" hours and " +overnight_minute+" minutes");
            task2_pure(overnight_hour,overnight_minute);
        }
    }

    public static void task2_pure(int Difference_hour, int Difference_minute){
        for(int count = 1; count <= Difference_hour; count++) {
            System.out.println("|***************|***************|***************|*************** "+count+" hr");
        }

        if(Difference_minute > 0) {
            for(int min = 0 ; min < Difference_minute; min++) {
                if(min%15 == 0) {
                    System.out.print('|');
                }
                System.out.print('*');
            }
            System.out.print(" ");
            System.out.println(Difference_minute + " min");
        }
        printParkingFee(Difference_hour,Difference_minute);
    }

    public static void printParkingFee (int hour, int min){
        int fee = 0;
        if(hour != 0 || min != 0){  // First 2 hour = 10 baht total First 2 hours = 10 Baht
            fee += 10;
        }
        if(hour > 2){ /// Every next hours = 40 Baht
            fee += 40 * ((hour -2) + (min > 0 ? 1 : 0));
        }
        System.out.println("Total parking fee: "+fee+" Baht");
    }
}