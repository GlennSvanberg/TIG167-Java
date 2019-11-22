import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.PrintWriter;
import java.io.FileWriter;

public class BMI {
    /*
    Man har i en textfil samlat uppgifter om ett antal personer. 
    För varje person finns två rader i filen. 
    På första raden står personens namn och adress och på andra raden finns personens ålder, längd och vikt. 
    Längden anges i cm och vikten i kg. 
    Man vill göra en medicinsk studie av överviktiga personer och söker därför personer vilkas s.k. body mass index(BMI) överstiger 30.
     BMI beräknas enligt formeln m/h2 där m är vikten i kg och hlängden i m. Skriv ett program som läser filen med person-uppgifter.  
     Programmet  ska  skapa  en  ny  textfil  som  bara  innehåller  uppgifterna  för  dem vilkas BMI överstiger 30. 
     När man startar programmet ska det från kommandofönstret (via System.in) läsa in namnet på den befintliga filen och 
     namnet på den nya filen. Om någon av filernainte går att öppna ska programmet ge en lämplig felutskrift (med ev. filnamn) 
     och avslutas. 
     Tips. Om man misslyckas med att öppna en fil får man en IOException.  
    */
    public static void main(String[] args) {
        // system.in read filename
        System.out.println("Please provide a filename: ");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        //String fileName = "personer.txt";
        System.out.println("What is the name of the new file?");
        String newFileName = sc.nextLine();
        //String newFileName = "out.txt";
        System.out.println("Filename: " + fileName);
        sc.close();
        //System.out.println("BMI: " + bmi(87,184));
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
            // read line by line
            boolean isNameLine = true;
            String name = "";
            String numbersLine = "";
            String line = "";
            while ((line = br.readLine()) != null) {
                if(isNameLine) {
                    name = line;
                    isNameLine = false; 
                } else {
                    numbersLine = line;
                    isNameLine = true;
                    String [] numbers = numbersLine.split(" ");
                    int weight = Integer.valueOf(numbers[1]);
                    int height = Integer.valueOf(numbers[2]);

                    System.out.println(name + " Height: " + height + " Weight: " + weight + " BMI: " + bmi(weight, height)); 
                    if(bmi(weight, height) >= 30) {
                        writeToFile(newFileName, name, weight, height, bmi(weight, height));
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Can not open " + args[0]);
        }
    }

    public static void writeToFile(String fileName, String name, int weight, int height, int bmi) {
        try {

            PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
    
            pw.println(name);
            pw.println(weight + " " + height + " " + bmi);
        
            pw.close();
        } catch(IOException e ){
            System.out.println("Can not write to file " + fileName);
        }
    }
    public static int bmi(int weight, int height) {
        Double h = Double.valueOf(height) /100;
        return (int) Math.round(Double.valueOf(weight)/(h * h));
    }
}