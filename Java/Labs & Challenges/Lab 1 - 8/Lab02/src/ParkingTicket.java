import java.util.Scanner;

public class ParkingTicket {

    public static void main(String[] args) {

        // Task 1
        // Input enter parking
        Scanner in = new Scanner(System.in);
        System.out.println("Entering time -> ");
        int entering_time = in.nextInt();
        // Input leaving parking
        System.out.println("Leaving time -> ");
        int leaving_time = in.nextInt();

        int entering_hour = entering_time / 100; //ex. 950 / 100 = 9
        int leaving_hour = leaving_time / 100; // ex. 1715 / 100 = 17

        int entering_minute = entering_time % 100; // ex. 950 % 100 = 50
        int leaving_minute = leaving_time % 100; // ex. 1715 % 100 = 15

        if(entering_minute > leaving_minute){ // ex. 50 > 15
            leaving_hour -= 1; // ex. 17-1 = 16
            leaving_minute += 60; // ex. 15+60 = 75
        }

        int Difference_hour = leaving_hour - entering_hour, Difference_minute = leaving_minute - entering_minute;
        // ex. 16 - 9 = 7 hour and // ex. 75 - 50 = 25 minutes

        System.out.println("Parking duration: "+ Difference_hour+" hours and "+ Difference_minute+" minutes");

        // Task 2
        for(int count = 1; count <= Difference_hour; count++) {
            System.out.println("|***************|***************|***************|*************** "+count+" hr");
        }
        if(Difference_minute > 0) {
            for(int min = 0 ; min < Difference_minute; min++) {
                if(min % 15 == 0) {
                    System.out.print('|');
                }
                System.out.print('*');
            }
            System.out.print(" ");
            System.out.println(Difference_minute + " min");
        }

        // Task 3
        int fee = 0;
        int hourFee = Difference_hour;

        if(Difference_minute >= (0)) {
            hourFee += 1;
        }
        for(int count = 1 ; count <= hourFee; count++) {
            if(count == 1 || count == 2) {
                fee += 10;
                count += 1; // First 2 hour = 10 baht total First 2 hours = 10 Baht
            }
            else {
                fee += 40; // Every next hours = 40 Baht
            }
        }
        //Minute difference
        System.out.println("Parking fee: " + fee + " Baht");
        in.close(); // Scanner Close
    }
}