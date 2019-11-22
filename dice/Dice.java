public class Dice {


    /*
    Konstruera en klass Tarningsom ska beskriva en vanlig tärning som man använder t.ex. när man spelar Fia. 
    Följande metoder ska finnas: kasta, som ger tärningen ett slumpmässigt värde mellan 1 och 6, avläsVärdesom 
    avläser tärningens värde och ger det som resultat samt sättVärdesom har en parameter vilken anger vilken 
    sida på tärningen man vill ska vara upp. Vidare ska det finnas två konstruktorer, en som initierar tärningen 
    till ett slumpmässigt värde och en som gör det möjligt att ge ett visst första värde till tärningen. 
    Parametern till metoden sättVärde och till den andra konstruktorn  måste  ha  ett  värde  mellan  1  och  6.  
    Skulle  så  inte  vara  fallet  ska  klassen  ge  en exception av typen IllegalArgumentException
    */
    private int value;
    private static int min = 1;
    private static int max = 6;

    public Dice(){
        value = roll();
    }

    public Dice(int value) {
        if(isAcceptedValue(value)) {
            this.value = value;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int roll() {
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    public int getValue() {
        return value;   
    }

    public void setValue(int value) {
        if(isAcceptedValue(value)) {
            this.value = value;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean isAcceptedValue(int value) {
        if(value > max || value < min) {
            return false;
        } else {
            return true;
        }
    } 
}