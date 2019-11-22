import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Wc {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Please provide the name of the file to read (Only one name)");
            System.exit(0);
        }
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(args[0]));
            // read line by line
            int rows = 0;
            int words = 0;
            int chars = 0;
            String line = "";
            String lines = "";
            while ((line = br.readLine()) != null) {
                rows ++;
                String [] w = line.split(" ");
                words += w.length;
                lines += line;
                
            }
            char[] l = lines.toCharArray();
            chars = l.length;
            System.out.println("Rows: " + rows);
            System.out.println("Words: " + words);
            System.out.println("Chars: " + chars);

        } catch (IOException e) {
            System.out.println("Can not open " + args[0]);
        }

    }
}