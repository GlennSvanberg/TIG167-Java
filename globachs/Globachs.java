import java.util.Scanner;
import java.util.ArrayList;

public class Globachs {
    public static void main(String[] args) {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ge ett jämnt tal"); 
            int number = scanner.nextInt();
            scanner.nextLine();
            
            if(number % 2 == 0) {
                ArrayList<Integer> primes = new ArrayList<>();
                for(int i = 2; i < number; i++) {
                    if(isPrime(i)) {
                        primes.add(i);
                    }
                }
                
           // System.out.println("primes: " + primes);
                for(int i = 0; i < primes.size(); i++) {
                    for(int j = 0; j < primes.size(); j++) {
                        if(primes.get(i) + primes.get(j) == number) {
                            System.out.println(primes.get(i) + " + " + primes.get(j) + " = " + number);
                            primes.set(i, 0);
                        }
                    }
                }
            } else {
                System.out.println("Det var inte ett jämnt tal!");
            }
        }
    }
    static boolean isPrime(int nr) {
        for(int i = 2; i < nr; i++) {
            if (nr % i == 0) {
                return false;
            }
        }
        return true;
    }
}