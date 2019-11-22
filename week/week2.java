import static javax.swing.JOptionPane.*;
import java.util.ArrayList;

public class Week2 {
    public static void main(String[] args) {
        while (true) {
            String input = showInputDialog("Enter a date with format yyyy-mm-dd");
            if(input == null) {
                break;
            }
            int year = Integer.valueOf(input.substring(0,4));
            int month = Integer.valueOf(input.substring(5,7));
            int day = Integer.valueOf(input.substring(8,10));
            System.out.println("Year: " + year + " Month: " + month + " Day: " + day);
            showMessageDialog(null, "Days of year " + daysOfYear(year, month, day));
            
        }
    }

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
            System.out.println("Month: " + months.get(i));
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