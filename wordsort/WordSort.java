import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordSort {

    public static void main(String[] args) {
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get("words.txt"));
            List<String> words = new ArrayList<String>();
            String line = "";
            while ((line = br.readLine()) != null) {
                String [] list = line.split(" ");
                for(int i = 0; i < list.length; i++) {
                    words.add(list[i]);
                }
            }
            Collections.sort(words, Comparator.comparing(String::length));
            for(String s : words) {
                System.out.println(s);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
            
    }
}