public class TimeIntervall {
    public static void main(String[] args) {
        /*
        Konstruera en klassmetod med namnet tidsintervall vilken får två tidpunkter t1 och t2 som parametrar och 
        som räknar ut hur lång tid det är från t1 till t2. 
        
        Placera metoden i en klass med namnet Tidklass. 
        Parametrarna och resultatet ska vara av typen String och ha formen tt:mm:ss. 
        
        Observera att timmar, minuter och sekunder alltid anges med två siffror, t.ex. 08:17:05. 
        Detta ska gälla även i resultatet. Metoden ska fungera även om t2 anger en tid som är mindre än t1.
        I så fall skaman anta att t2 har inträffar dygnet efter t1. Tips: Räkna om tiderna till sekunder.

        */
        String t1 = "08:00:00";
        String t2 = "09:59:00";
        System.out.println("Time passed: " + timeIntervall(t1, t2));
    }
    public static String timeIntervall(String t1, String t2) {
        //Hur lång tid är det från t1 till t2 räkna om till sekunder
        String[] t1List =  t1.split(":");
        String[] t2List =  t2.split(":");
        int t1Sec = (Integer.valueOf(t1List[0]) * 60 * 60) + (Integer.valueOf(t1List[1]) * 60) + (Integer.valueOf(t1List[2]));
        int t2Sec = (Integer.valueOf(t2List[0]) * 60 * 60) + (Integer.valueOf(t2List[1]) * 60) + (Integer.valueOf(t2List[2]));
        int timePassed = 0;
        if(t2Sec > t1Sec) {
            timePassed = t2Sec - t1Sec;
        } else {
            timePassed = t2Sec - t1Sec + 86400;
        }
        int hours = 0;
        int min = 0;
        int sec = 0;
        
        while(timePassed >= 60) {
            min++;
            timePassed -= 60;
        }
        while(min >= 60) {
            hours ++;
            min -= 60;
        } 
        sec = timePassed;
        String hoursString = String.valueOf(hours);
        if(hours <= 9) {
            hoursString = "0" + hoursString;
        }
        String minString = String.valueOf(min);
        if(min <= 9) {
            minString = "0" + minString;
        }
        String secString = String.valueOf(sec);
        if(sec <= 9) {
            secString = "0" + secString;
        }
        return hoursString + ":" + minString + ":" + secString;
    }   
}