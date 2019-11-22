import java.util.Scanner;

public class ID {
    public static void main(String[] args) {
        System.out.println("Enter your ID");

        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        System.out.println("Your id is: " + id);
        scanner.close();
        System.out.println("Is correct: " + isCorrect(id));
    }

    public static boolean isCorrect(String id) {
        id = id.trim();
        if(id.length() != 11) {
            System.out.println("ID must be 11 char long");
            return false;
        }
        if(!id.substring(6,7).equals("-")) {
            System.out.println("Id must include -");
            return false;
        }
        if(!controlDigitIsCorrect(id)) {
            System.out.println("Controldigit is not correct");
            return false;
        }

        return true;
    }

    /*
 De nio första siffrorna i personnumret multipliceras omväxlande med 2 och 1, den första med 2 den andra med 1 den tredje med 2 osv. 
 Siffrornai    de    värden    man    då    får    adderas.    I    personnumret    ovan    blir    det (1+0)+6+2+2+6+1+8+9+2 = 37. 
 (Observera att 10 räknas som 1+0.) Kontrollsiffran bestäms sedan av att den summa man fått plus kontrollsiffran ska varajämnt delbar
 med 10. I exemplet blir alltså kontrollsiffran lika med 3.
 */


    public static boolean controlDigitIsCorrect(String id) {
        int sum = 0;
        for(int i = 0; i < id.length() -1; i++) {
            if (i != 6) {
            
                int d = Character.getNumericValue(id.charAt(i));
                int multiplied = multiply(d);

                if(multiplied >= 10) {
                    multiplied = multiplied - 9;
                }
                sum += multiplied;
                System.out.println("digit: " + d);
                System.out.println("multiplied: " + multiplied);
                System.out.println("sum: " + sum);
                System.out.println("-----------------------");
            }
        }
       int lastDigit = Character.getNumericValue(id.charAt(10));
       
       System.out.println("Result: " + sum);
        System.out.println("Result/10: " + sum / 10);
        System.out.println("LastDigit = " + lastDigit);

        String fin = String.valueOf(sum);
        fin = fin.substring(fin.length() -1);
        sum = Integer.parseInt(fin);
        System.out.println("new Sum: " + sum);

        if(10 - sum == lastDigit) {
            return true;
        }
        return false;
    }
    static int multiplier = 2;
    static int res = 0;
    public static int multiply(int d) {
        res = d * multiplier;
        //System.out.println("res : " + res + " digit: " + d + " multiplier: " + multiplier);

        if(multiplier == 2) {
            multiplier = 1;
        } else  {
            multiplier = 2;
        }
        
        return res;

    }
}