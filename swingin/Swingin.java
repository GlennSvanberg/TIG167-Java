import static javax.swing.JOptionPane.*;

public class Swingin {
    public static void main(String[] args) {
      String name;
      String greeting;  
      name = showInputDialog("What's yourt name?");
      greeting = "Hello " + name;
      showMessageDialog(null, greeting);
    }   
}