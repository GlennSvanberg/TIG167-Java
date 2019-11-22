public class RatNum1 {
    public static int sgd(int m, int n) {
        
    
        if(m == 0 || n == 0) {
            throw new IllegalArgumentException();
        }
        if(m <= 0) {
            m = m * -1;
        }
        if(n <= 0) {
            n = n* -1;
        }
        int r = m % n;
        while (r != 0) {
            r = m % n;
            m = n;
            n = r;
        }
        return n; 
        
    }
}