public class Test {
    public static void main(String[] args) {
        Dice dice = new Dice();
        System.out.println("Dice value: " + dice.getValue());
        try {
            dice.setValue(7);
        } catch(IllegalArgumentException e) {
            System.out.println("Please provide a number between 1 and 6");
        }
        System.out.println("Dice value: " + dice.getValue());
        dice.roll();
        System.out.println("Dice value: " + dice.getValue());
        dice = new Dice(4);
        System.out.println("Dice value: " + dice.getValue());

    }
}