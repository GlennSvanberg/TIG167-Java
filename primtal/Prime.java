import static javax.swing.JOptionPane.*;

public class Prime {

    public static void main(String[] args) {
        while(true) {
            String input = showInputDialog("Enter 2 numbers");

            int a = Integer.parseInt(input.substring(0, input.indexOf(",")).trim());
            int b = Integer.parseInt(input.substring(input.indexOf(",")+1, input.length()).trim());

            if(relPrime(a,b)) {
                showMessageDialog(null, a + " and " + b + " is relative primes");
            } else {
                showMessageDialog(null, a + " and " + b + " is NOT relative primes");
            }
        }
        }
    static boolean relPrime(int a, int b) {
        // a is always the greater digit
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }
        for(int i = 2; i < b-1; i++) {
            System.out.println(i+1);
            if(a % i == 0) {
                if(b % i == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
