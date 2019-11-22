import static javax.swing.JOptionPane.*;

public class Week {
    public static void main(String[] args) {
        /*
        Huvuduppgift: kolla vilken veckodag det var eller kommer att bli 1754 ->
        
        1 2020 kolla om det är skottår eller inte, alal skottår som är jämnt delbara med 4 är skottår 
        med undantag för sådana som är jämnt delbara med 100
        
        2 2020-11-11 nyttt prog beräkna en dags nummer inom året ta hänsyn för skottår

        3 2020-11-11 Kolla veckodag beräkna dagar från 1754 tills idag 1 jan 1754 var en tisdag 
        dela med 7 och kolla vilken rest man får med modulus
        */

        while (true) {
            String input = showInputDialog("Enter the year");
            int year = Integer.valueOf(input.trim());

            if(isLeapYear(year)) {
                showMessageDialog(null, year + " is a leap year");
            } else {
                showMessageDialog(null, year + " is not  leap year");
            }
            
        }
    }
    static boolean isLeapYear(int year) {
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }
}