import static javax.swing.JOptionPane.*;

public class Farenheit {

    public static void main(String[] args) {
        String farenheit = showInputDialog("Enter yourt temp in farenheit");
        String greeting = "";
        try { 
            greeting = "Farenheit: " + farenheit + " is " + toCelsius(Double.valueOf(farenheit)) + " Celsius";
        } catch(Exception e) {
            greeting = "Farenheit must be a number";
        }
        showMessageDialog(null, greeting);
    }

    public static double toCelsius(double f) {
        return ((5*(f-32))/9);
    }

}