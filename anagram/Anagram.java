
import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String a = "atest";
        String b = "testa";
        if(isAnagram(a,b)) {
            System.out.println("Is anagrams of each other");
        } else {
            System.out.println("Is NOT anagrams");
        }
    }

    static boolean isAnagram(String a, String b) {
        char[] ach = new char[a.length()];
        char[] bch = new char[b.length()];
  
        if(a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) { 
            ach[i] = a.charAt(i); 
            bch[i] = b.charAt(i);
        } 

        Arrays.sort(ach);
        Arrays.sort(bch);

        for(int i = 0; i < ach.length; i++) {
            if(ach[i] != bch[i]) {
                return false;
            }
        }
        return true;
    }
}