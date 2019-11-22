import java.text.*;
import java.io.*;
public class Flight implements Serializable, Comparable<Flight> {
    private String no, destination;
    private String time;             
    // avgångstid (med formen hh:mm)
    public Flight (String n, String d, String t) {
        no = n; 
        destination = d; 
        time = t;
    }
    public String getNumber() {
        return no;
    }
    public String getDestination() {
        return destination;
    }
    public String getTime() {
        return time;
    }
    public int compareTo(Flight f) {
        Collator c = Collator.getInstance();
        c.setStrength(Collator.PRIMARY);
        return c.compare(time+destination, f.time+f.destination);
    }
}