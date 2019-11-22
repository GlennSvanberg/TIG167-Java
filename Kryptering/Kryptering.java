public class Kryptering {
    private static char[] letters;
    
    public static void main(String[] args) {
        letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String message = "test";
        String key = "hund";
        boolean encrypt = true;
        System.out.println("start: " + message);
        System.out.println("key: " + key);
        String encrypted = crypt(message, key, encrypt);
        System.out.println("Encrypt: " + encrypted);
        encrypt = false;
        System.out.println("Decrypt: " + crypt(encrypted, key, encrypt));
    }
    public static String crypt(String message, String key, boolean encrypt) {
        message = message.toLowerCase();
        message = message.replaceAll("[^a-z]", "");
        key = key.toLowerCase();
        key = key.replaceAll("[^a-z]", "");
       
        while(message.length() > key.length()) {
            key = key + key;
        }
        
        if(message.length() < key.length()) {
            key = key.substring(0, message.length());
        } 

        String answer = "";
        for(int i = 0; i < message.length(); i++) {
          
            int mInt = getLetterPos(message.charAt(i));
            int kInt = getLetterPos(key.charAt(i));

            int cryptNum;
            if(encrypt) {
                               
                cryptNum = mInt + kInt;
                cryptNum = cryptNum % 26;
                answer += letters[cryptNum];
            
            } else {
                cryptNum = mInt - kInt;
                if(cryptNum < 0) {
                    cryptNum += 26;
                }

                answer += letters[cryptNum];
            }
        }
        return answer;
    }
    private static int getLetterPos(char letter) {
        
        for (int i = 0; i < letters.length; i++) {
            if(letters[i] == letter){
                return i;
            }
        }
        return 0;

    }
}