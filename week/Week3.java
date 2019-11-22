import static javax.swing.JOptionPane.*;
import java.util.ArrayList;

public class Week3 {

        /*
        Huvuduppgift: kolla vilken veckodag det var eller kommer att bli 1754 ->
        
        1 2020 kolla om det är skottår eller inte, alal skottår som är jämnt delbara med 4 är skottår 
        med undantag för sådana som är jämnt delbara med 100
        
        2 2020-11-11 nyttt prog beräkna en dags nummer inom året ta hänsyn för skottår

        3 2020-11-11 Kolla veckodag beräkna dagar från 1754 tills idag 1 jan 1754 var en tisdag 
        dela med 7 och kolla vilken rest man får med modulus
        */
    public static void main(String[] args) {
        while (true) {
            String input = showInputDialog("Enter a date with format yyyy-mm-dd");
            if(input == null) {
                break;
            }
            int year = Integer.valueOf(input.substring(0,4));
            int month = Integer.valueOf(input.substring(5,7));
            int day = Integer.valueOf(input.substring(8,10));
            
           
            int days = daysSinceBeginningOfTime(year, month, day);
           // showMessageDialog(null, "Days since the beginning of time " + days);
            
            showMessageDialog(null, input + " is a  " + weekDay(days));
            System.out.println(input);
            System.out.println("Weekday: " + weekDay(days));
            System.out.println("------------------------");
            
        }
    }
    static String weekDay(int days) {

        System.out.println("modulus " + days % 7);
        System.out.println("days: " + days);
        switch (days % 7) {
            case 0:
                return "monday";
            case 1:
                return "tuesday";
            case 2:
                return "wednesday";
            case 3:
                return "thursday";
            case 4:
                return "friday";
            case 5:
                return "saturday";
            case 6:
                return "sunday";
            default:
            return "tuesday";
        }
    }
    static int daysSinceBeginningOfTime(int year, int month, int day) {
        int days = 0;
        for (int i = 1754; i < year; i++) {
            if (isLeapYear(i)) {
                //System.out.println("adding year: " + days + " -> " + 366);
                days += 366;
            } else {
                
                //System.out.println("adding year: " + days + " -> " + 365);
                days += 365;
                
            }
            //System.out.println("Year: " + year + " total days: " + days);
        }
        
        
        System.out.println("adding days: " + days + " -> " + daysOfYear(year, month, day));
        days += daysOfYear(year, month, day);
        return days;
    }
    /*
    jan 1 1754 tuesday
    jan 1 1755 wednesday
    dec 31 1755 wednesday
    jan 1 1756 thursday
    jan 1 1757 saturday
    */
    static int daysOfYear(int year, int month, int day) {
        int days = 0;

        ArrayList<Integer> months = new ArrayList<>();
        months.add(31); // jan
        months.add(28); // feb
        months.add(31); // mars
        months.add(30); // april
        months.add(31); // maj
        months.add(30); // jun
        months.add(31); // jul
        months.add(31); // aug
        months.add(30); // sept
        months.add(31); // okt
        months.add(30); // nov
        months.add(31); // dec
    
        if(isLeapYear(year)) {
            months.set(1, 29);
        }

        for (int i = 0; i < month - 1; i++ ) {
           // System.out.println("Month: " + months.get(i));
            days += months.get(i);
        }
        days += day;

        return days;
    }



    static boolean isLeapYear(int year) {
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }
}