public class RatNum {
    private int a; // täljaren är uppe och nämnaren är nere a/b
    private int b; // nämnaren

    public RatNum() {
        a = 0;
        b = 1;
    }
    public RatNum(int a) {
        this.a = a;
        b = 1;
    }
    public RatNum(int a, int b) {
        
        if(b == 0) {
            throw new NumberFormatException("Denominator = 0");
        }
        
        if(a == 0 || b == 0) {
            this.a = a;
            this.b = b;
        } else {
     
            int sgda = a /sgd(a,b);
            int sgdb = b /sgd(a,b);
            
            if( (a > 0 && b < 0) || (a < 0 && b < 0) ) {
                sgda = sgda * -1;
                sgdb = sgdb * -1;
            }
            this.a = sgda;
            this.b = sgdb;
        }
        
    }
    public RatNum(String s) {
            this(parse(s));
    }
    public RatNum(RatNum r) {
        a = r.getNumerator();
        b = r.getDenominator();
    }
    public int getNumerator() {
        return a;
    }
    public int getDenominator() {
        return b;
    }
    public Object clone() {
        return new RatNum(a,b);
    }
    public boolean equals(RatNum r) {
        if (r == null) {
            return false;
        }
        if(r.getDenominator() == getDenominator() && r.getNumerator() == getNumerator()) {
            return true;
        }
        return false;
    } 
    public boolean lessThan(RatNum r) {
        Double other = Double.valueOf(r.getNumerator()) / Double.valueOf(r.getDenominator());
        Double me = Double.valueOf(Double.valueOf(a) / Double.valueOf(b));
        if(other > me) {
            return true;
        }
        return false;
    }
    public RatNum add(RatNum r) {
    //Uttrycket a/b+c/d kan t.ex. skrivas om som (ad+bc)/bd. A
     //   System.out.println("-");
     // 1/3 + 1/4
     // ( (1*4) + (1*3) ) / 4 * 3
     // 4 + 3 / 12
        int a = this.a * r.getDenominator() + this.b * r.getNumerator(); 
        int b = this.b * r.getDenominator();
        return new RatNum(a,b);
    }
    public RatNum sub(RatNum r) {
        int a = this.a * r.getDenominator() - this.b * r.getNumerator();
        int b = this.b * r.getDenominator();
        return new RatNum(a,b);
    } 
    public RatNum mul(RatNum r) {
        int a = this.a * r.getNumerator();
        int b = this.b * r.getDenominator();
        return new RatNum(a,b);
    } 
    public RatNum div(RatNum r) {
        int a = this.a * r.getDenominator();
        int b = this.b * r.getNumerator();
        return new RatNum(a,b);
    } 
    public static int sgd(int a, int b) {
  
        if(a == 0 || b == 0) {
            throw new IllegalArgumentException();
        }
        if(a <= 0) {
            a = a * -1;
        } 
        if(b <= 0) {
            b = b * -1;
        }
        
        while (b != 0) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }
    public static RatNum parse(String s) {
        String[] sArray = s.split("/");
        if(sArray.length == 1) {
            return new RatNum(Integer.valueOf(s));
        }  
        return new RatNum(Integer.valueOf(sArray[0]), Integer.valueOf(sArray[1]));
    }
    public double toDouble() {
        return Double.valueOf(a) / Double.valueOf(b);
    }
    @Override
    public String toString(){

        String s;
        int h = 0;
        if(a < 0) {
            h = ((a * -1) / b) * -1;
            
        } else {
            h = a/b;
        }
        if(h == 0) {
            s = a + "/" + b;
        } else {
            if(a < 0) {
                a = a *-1;
            }
            s = h + " " + a%b + "/" + b;
        }
        return s;
    }
}