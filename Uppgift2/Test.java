public class Test {
    public static void main(String[] args) {
        RatNum r1 = new RatNum(7,-2);
        RatNum r2 = new RatNum(-2,5);
        System.out.println("R1: " + r1.getNumerator() + "/" + r1.getDenominator());
        System.out.println("R2: " + r2.getNumerator() + "/" + r2.getDenominator());

        RatNum rSum = r1.div(r2);
        System.out.println("expected: " + "8 3/4");
        System.out.println("got:" + rSum.getNumerator() + "/" + rSum.getDenominator());
    }
}